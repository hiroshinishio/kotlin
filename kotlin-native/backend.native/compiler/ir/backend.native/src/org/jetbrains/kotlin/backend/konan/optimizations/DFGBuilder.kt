/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package org.jetbrains.kotlin.backend.konan.optimizations

import org.jetbrains.kotlin.backend.common.peek
import org.jetbrains.kotlin.backend.common.pop
import org.jetbrains.kotlin.backend.common.push
import org.jetbrains.kotlin.backend.konan.lower.erasedUpperBound
import org.jetbrains.kotlin.backend.konan.*
import org.jetbrains.kotlin.backend.konan.ir.*
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.UNDEFINED_OFFSET
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.declarations.lazy.IrLazyClass
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.expressions.impl.*
import org.jetbrains.kotlin.ir.symbols.IrClassSymbol
import org.jetbrains.kotlin.ir.symbols.IrSimpleFunctionSymbol
import org.jetbrains.kotlin.ir.symbols.IrTypeParameterSymbol
import org.jetbrains.kotlin.ir.types.*
import org.jetbrains.kotlin.ir.util.*
import org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid
import org.jetbrains.kotlin.ir.visitors.acceptChildrenVoid
import org.jetbrains.kotlin.ir.visitors.acceptVoid
import org.jetbrains.kotlin.util.OperatorNameConventions
import org.jetbrains.kotlin.backend.konan.llvm.*
import org.jetbrains.kotlin.ir.objcinterop.isObjCObjectType

internal val STATEMENT_ORIGIN_PRODUCER_INVOCATION = IrStatementOriginImpl("PRODUCER_INVOCATION")
internal val STATEMENT_ORIGIN_JOB_INVOCATION = IrStatementOriginImpl("JOB_INVOCATION")

private fun IrTypeOperator.isCast() =
        this == IrTypeOperator.CAST || this == IrTypeOperator.IMPLICIT_CAST || this == IrTypeOperator.SAFE_CAST

private fun IrTypeOperator.callsInstanceOf() =
        this == IrTypeOperator.CAST || this == IrTypeOperator.SAFE_CAST
                || this == IrTypeOperator.INSTANCEOF || this == IrTypeOperator.NOT_INSTANCEOF

private class VariableValues {
    data class Variable(val loop: IrLoop?, val values: MutableSet<IrExpression>)

    val elementData = HashMap<IrValueDeclaration, Variable>()

    fun addEmpty(variable: IrValueDeclaration, loop: IrLoop?) {
        elementData[variable] = Variable(loop, mutableSetOf())
    }

    fun add(variable: IrValueDeclaration, element: IrExpression) =
            elementData[variable]?.values?.add(element)

    private fun add(variable: IrValueDeclaration, elements: Set<IrExpression>) =
            elementData[variable]?.values?.addAll(elements)

    fun computeClosure() {
        elementData.forEach { (key, _) ->
            add(key, computeValueClosure(key))
        }
    }

    // Computes closure of all possible values for given variable.
    private fun computeValueClosure(value: IrValueDeclaration): Set<IrExpression> {
        val result = mutableSetOf<IrExpression>()
        val seen = mutableSetOf<IrValueDeclaration>()
        dfs(value, seen, result)
        return result
    }

    private fun dfs(value: IrValueDeclaration, seen: MutableSet<IrValueDeclaration>, result: MutableSet<IrExpression>) {
        seen += value
        val elements = elementData[value]?.values ?: return
        for (element in elements) {
            if (element !is IrGetValue)
                result += element
            else {
                val declaration = element.symbol.owner
                if (declaration is IrVariable && !seen.contains(declaration))
                    dfs(declaration, seen, result)
            }
        }
    }
}

private class ExpressionValuesExtractor(val context: Context,
                                        val returnableBlockValues: Map<IrReturnableBlock, List<IrExpression>>,
                                        val suspendableExpressionValues: Map<IrSuspendableExpression, List<IrSuspensionPoint>>) {

    val unit = IrGetObjectValueImpl(UNDEFINED_OFFSET, UNDEFINED_OFFSET,
            context.irBuiltIns.unitType, context.ir.symbols.unit)

    val nothing = IrGetObjectValueImpl(UNDEFINED_OFFSET, UNDEFINED_OFFSET,
            context.irBuiltIns.nothingType, context.ir.symbols.nothing)

    fun forEachValue(expression: IrExpression, block: (IrExpression) -> Unit) {
        when (expression) {
            is IrReturnableBlock -> returnableBlockValues[expression]!!.forEach { forEachValue(it, block) }

            is IrSuspendableExpression ->
                (suspendableExpressionValues[expression]!! + expression.result).forEach { forEachValue(it, block) }

            is IrSuspensionPoint -> {
                forEachValue(expression.result, block)
                forEachValue(expression.resumeResult, block)
            }

            is IrContainerExpression -> {
                if (expression.statements.isNotEmpty())
                    forEachValue(
                            expression = (expression.statements.last() as? IrExpression) ?: unit,
                            block      = block
                    )
            }

            is IrWhen -> expression.branches.forEach { forEachValue(it.result, block) }

            is IrTypeOperatorCall -> {
                if (!expression.operator.isCast())
                    block(expression)
                else { // Propagate cast to sub-values.
                    forEachValue(expression.argument) { value ->
                        with(expression) {
                            block(IrTypeOperatorCallImpl(startOffset, endOffset, type, operator, typeOperand, value))
                        }
                    }
                }
            }

            is IrTry -> {
                forEachValue(expression.tryResult, block)
                expression.catches.forEach { forEachValue(it.result, block) }
            }

            is IrVararg, /* Sometimes, we keep vararg till codegen phase (for constant arrays). */
            is IrMemberAccessExpression<*>, is IrGetValue, is IrGetField, is IrConst,
            is IrGetObjectValue, is IrFunctionReference, is IrSetField,
            is IrConstantValue -> block(expression)

            else -> when {
                expression.type.isUnit() -> unit
                expression.type.isNothing() -> nothing
                else -> TODO(ir2stringWhole(expression))
            }
        }
    }
}

internal class FunctionDFGBuilder(private val generationState: NativeGenerationState, private val symbolTable: DataFlowIR.SymbolTable) {
    private val context = generationState.context

    // Possible values of a returnable block.
    private val returnableBlockValues = mutableMapOf<IrReturnableBlock, MutableList<IrExpression>>()

    // All suspension points within specified suspendable expression.
    private val suspendableExpressionValues = mutableMapOf<IrSuspendableExpression, MutableList<IrSuspensionPoint>>()

    private val expressionValuesExtractor = ExpressionValuesExtractor(context, returnableBlockValues, suspendableExpressionValues)

    fun build(declaration: IrDeclaration, body: IrElement?): DataFlowIR.Function {
        // Find all interesting expressions, variables and functions.
        val visitor = ElementFinderVisitor()
        body?.acceptVoid(visitor)

        context.logMultiple {
            +"FIRST PHASE"
            visitor.variableValues.elementData.forEach { (t, u) ->
                +"VAR $t [LOOP ${u.loop}]:"
                u.values.forEach { +"    ${ir2stringWhole(it)}" }
            }
            visitor.expressions.forEach { t ->
                +"EXP [LOOP ${t.value}] ${ir2stringWhole(t.key)}"
            }
        }

        // Compute transitive closure of possible values for variables.
        visitor.variableValues.computeClosure()

        context.logMultiple {
            +"SECOND PHASE"
            visitor.variableValues.elementData.forEach { (t, u) ->
                +"VAR $t [LOOP ${u.loop}]:"
                u.values.forEach { +"    ${ir2stringWhole(it)}" }
            }
        }

        val function = FunctionDFGBuilder(expressionValuesExtractor, visitor.variableValues,
                declaration, visitor.expressions, visitor.parentLoops, visitor.returnValues,
                visitor.thrownValues, visitor.catchParameters).build()

        context.logMultiple {
            +function.debugString()
            +""
        }

        return function
    }

    private inner class ElementFinderVisitor : IrElementVisitorVoid {
        val expressions = mutableMapOf<IrExpression, IrLoop?>()
        val parentLoops = mutableMapOf<IrLoop, IrLoop?>()
        val variableValues = VariableValues()
        val returnValues = mutableListOf<IrExpression>()
        val thrownValues = mutableListOf<IrExpression>()
        val catchParameters = mutableSetOf<IrVariable>()

        private val suspendableExpressionStack = mutableListOf<IrSuspendableExpression>()
        private val loopStack = mutableListOf<IrLoop>()
        private val currentLoop get() = loopStack.peek()

        override fun visitElement(element: IrElement) {
            element.acceptChildrenVoid(this)
        }

        private fun assignValue(variable: IrValueDeclaration, value: IrExpression) {
            expressionValuesExtractor.forEachValue(value) {
                variableValues.add(variable, it)
            }
        }

        override fun visitExpression(expression: IrExpression) {
            when (expression) {
                is IrMemberAccessExpression<*>,
                is IrGetField,
                is IrGetObjectValue,
                is IrVararg,
                is IrConst,
                is IrTypeOperatorCall,
                is IrConstantPrimitive ->
                    expressions += expression to currentLoop
            }

            if (expression is IrCall) {
                if (expression.symbol == initInstanceSymbol) {
                    // Skip the constructor call as initInstance is handled specially later.
                    val thiz = expression.getValueArgument(0)!!
                    val constructorCall = expression.getValueArgument(1)!!
                    thiz.acceptVoid(this)
                    constructorCall.acceptChildrenVoid(this)
                    return
                }
                if (expression.symbol == executeImplSymbol) {
                    // Producer and job of executeImpl are called externally, we need to reflect this somehow.
                    val producerInvocation = IrCallImpl.fromSymbolOwner(expression.startOffset, expression.endOffset,
                            executeImplProducerInvoke.returnType,
                            executeImplProducerInvoke.symbol,
                            executeImplProducerInvoke.symbol.owner.typeParameters.size,
                            executeImplProducerInvoke.symbol.owner.valueParameters.size,
                            STATEMENT_ORIGIN_PRODUCER_INVOCATION)
                    producerInvocation.dispatchReceiver = expression.getValueArgument(2)

                    expressions += producerInvocation to currentLoop

                    val jobFunctionReference = expression.getValueArgument(3) as? IrFunctionReference
                            ?: error("A function reference expected")
                    val jobInvocation = IrCallImpl.fromSymbolOwner(expression.startOffset, expression.endOffset,
                            jobFunctionReference.symbol.owner.returnType,
                            jobFunctionReference.symbol as IrSimpleFunctionSymbol,
                            jobFunctionReference.symbol.owner.typeParameters.size,
                            jobFunctionReference.symbol.owner.valueParameters.size,
                            STATEMENT_ORIGIN_JOB_INVOCATION)
                    jobInvocation.putValueArgument(0, producerInvocation)

                    expressions += jobInvocation to currentLoop
                }
                val intrinsicType = tryGetIntrinsicType(expression)
                if (intrinsicType == IntrinsicType.COMPARE_AND_SET || intrinsicType == IntrinsicType.COMPARE_AND_EXCHANGE) {
                    expressions += IrSetFieldImpl(
                            expression.startOffset, expression.endOffset,
                            context.mapping.functionToVolatileField[expression.symbol.owner]!!.symbol,
                            expression.dispatchReceiver,
                            expression.getValueArgument(1)!!,
                            context.irBuiltIns.unitType
                    ) to currentLoop
                }
                if (intrinsicType == IntrinsicType.GET_AND_SET) {
                    expressions += IrSetFieldImpl(
                            expression.startOffset, expression.endOffset,
                            context.mapping.functionToVolatileField[expression.symbol.owner]!!.symbol,
                            expression.dispatchReceiver,
                            expression.getValueArgument(0)!!,
                            context.irBuiltIns.unitType
                    ) to currentLoop
                }
            }

            // TODO: A little bit hacky but it is the simplest solution.
            // See ObjC instanceOf code generation for details.
            if (expression is IrTypeOperatorCall && expression.operator.callsInstanceOf()
                    && expression.typeOperand.isObjCObjectType()) {
                val objcObjGetter = IrCallImpl.fromSymbolOwner(expression.startOffset, expression.endOffset,
                        objCObjectRawValueGetter.owner.returnType,
                        objCObjectRawValueGetter,
                        objCObjectRawValueGetter.owner.typeParameters.size,
                        objCObjectRawValueGetter.owner.valueParameters.size
                ).apply {
                    extensionReceiver = expression.argument
                }
                expressions += objcObjGetter to currentLoop
            }

            if (expression is IrReturnableBlock) {
                returnableBlockValues.put(expression, mutableListOf())
            }
            if (expression is IrSuspendableExpression) {
                suspendableExpressionStack.push(expression)
                suspendableExpressionValues.put(expression, mutableListOf())
            }
            if (expression is IrSuspensionPoint)
                suspendableExpressionValues[suspendableExpressionStack.peek()!!]!!.add(expression)
            if (expression is IrLoop) {
                parentLoops[expression] = currentLoop
                loopStack.push(expression)
            }

            super.visitExpression(expression)

            if (expression is IrLoop)
                loopStack.pop()
            if (expression is IrSuspendableExpression)
                suspendableExpressionStack.pop()
        }

        override fun visitSetField(expression: IrSetField) {
            expressions += expression to currentLoop
            super.visitSetField(expression)
        }

        override fun visitReturn(expression: IrReturn) {
            val returnableBlock = expression.returnTargetSymbol.owner as? IrReturnableBlock
            if (returnableBlock != null) {
                returnableBlockValues[returnableBlock]!!.add(expression.value)
            } else { // Non-local return.
                if (!expression.type.isUnit())
                    returnValues += expression.value
            }
            super.visitReturn(expression)
        }

        override fun visitThrow(expression: IrThrow) {
            thrownValues += expression.value
            super.visitThrow(expression)
        }

        override fun visitCatch(aCatch: IrCatch) {
            catchParameters.add(aCatch.catchParameter)
            super.visitCatch(aCatch)
        }

        override fun visitSetValue(expression: IrSetValue) {
            super.visitSetValue(expression)
            assignValue(expression.symbol.owner, expression.value)
        }

        override fun visitVariable(declaration: IrVariable) {
            variableValues.addEmpty(declaration, currentLoop)
            super.visitVariable(declaration)
            declaration.initializer?.let { assignValue(declaration, it) }
        }

        override fun visitConstantArray(expression: IrConstantArray) {
            super.visitConstantArray(expression)
            expressions += expression to currentLoop
            val arrayClass = expression.type.classOrNull
            val arraySetSymbol = context.ir.symbols.arraySet[arrayClass] ?: error("Unexpected array type ${expression.type.render()}")
            val isGeneric = arrayClass == context.irBuiltIns.arrayClass
            expression.elements.forEachIndexed { index, value ->
                val call = IrCallImpl(
                        expression.startOffset, expression.endOffset,
                        context.irBuiltIns.unitType,
                        arraySetSymbol,
                        typeArgumentsCount = if (isGeneric) 1 else 0,
                        valueArgumentsCount = 2
                ).apply {
                    dispatchReceiver = expression
                    if (isGeneric) putTypeArgument(0, value.type)
                    val constInt = IrConstImpl.int(SYNTHETIC_OFFSET, SYNTHETIC_OFFSET, context.irBuiltIns.intType, index)
                    expressions += constInt to currentLoop
                    putValueArgument(0, constInt)
                    putValueArgument(1, value)
                }
                expressions += call to currentLoop
            }
        }

        override fun visitConstantObject(expression: IrConstantObject) {
            super.visitConstantObject(expression)
            expressions += expression to currentLoop
        }
    }

    private val symbols = context.ir.symbols
    private val arrayGetSymbols = symbols.arrayGet.values
    private val arraySetSymbols = symbols.arraySet.values
    private val createUninitializedInstanceSymbol = symbols.createUninitializedInstance
    private val initInstanceSymbol = symbols.initInstance
    private val executeImplSymbol = symbols.executeImpl
    private val executeImplProducerClass = symbols.functionN(0).owner
    private val executeImplProducerInvoke = executeImplProducerClass.simpleFunctions()
            .single { it.name == OperatorNameConventions.INVOKE }
    private val reinterpret = symbols.reinterpret
    private val objCObjectRawValueGetter = symbols.interopObjCObjectRawValueGetter

    private class Scoped<out T : Any>(val value: T, val scope: DataFlowIR.Node.Scope)

    private inner class FunctionDFGBuilder(
            val expressionValuesExtractor: ExpressionValuesExtractor,
            val variableValues: VariableValues,
            val declaration: IrDeclaration,
            val expressions: Map<IrExpression, IrLoop?>,
            val parentLoops: Map<IrLoop, IrLoop?>,
            val returnValues: List<IrExpression>,
            val thrownValues: List<IrExpression>,
            val catchParameters: Set<IrVariable>,
    ) {

        private val rootScope = DataFlowIR.Node.Scope(0, emptyList())
        private val allParameters = (declaration as? IrFunction)?.allParameters ?: emptyList()
        private val templateParameters = allParameters.withIndex().associateBy({ it.value },
                { Scoped(DataFlowIR.Node.Parameter(it.index), rootScope) }
        )


        private val nodes = mutableMapOf<IrExpression, Scoped<DataFlowIR.Node>>()
        private val variables = mutableMapOf<IrValueDeclaration, Scoped<DataFlowIR.Node.Variable>>()
        private val expressionsScopes = mutableMapOf<IrExpression, DataFlowIR.Node.Scope>()

        fun build(): DataFlowIR.Function {
            val scopes = mutableMapOf<IrLoop, DataFlowIR.Node.Scope>()
            fun transformLoop(loop: IrLoop, parentLoop: IrLoop?): DataFlowIR.Node.Scope {
                scopes[loop]?.let { return it }
                val parentScope =
                        if (parentLoop == null)
                            rootScope
                        else transformLoop(parentLoop, parentLoops[parentLoop])
                val scope = DataFlowIR.Node.Scope(parentScope.depth + 1, emptyList())
                parentScope.nodes += scope
                scopes[loop] = scope
                return scope
            }
            parentLoops.forEach { (loop, parentLoop) -> transformLoop(loop, parentLoop) }
            expressions.forEach { (expression, loop) ->
                val scope = if (loop == null) rootScope else scopes[loop]!!
                expressionsScopes[expression] = scope
            }
            expressionsScopes[expressionValuesExtractor.unit] = rootScope
            expressionsScopes[expressionValuesExtractor.nothing] = rootScope

            variableValues.elementData.forEach { (irVariable, variable) ->
                val loop = variable.loop
                val scope = if (loop == null) rootScope else scopes[loop]!!
                val node = DataFlowIR.Node.Variable(
                        values = mutableListOf(),
                        type = symbolTable.mapType(irVariable.type),
                        kind = if (catchParameters.contains(irVariable))
                            DataFlowIR.VariableKind.CatchParameter
                        else DataFlowIR.VariableKind.Ordinary
                )
                scope.nodes += node
                variables[irVariable] = Scoped(node, scope)
            }

            expressions.forEach { getNode(it.key) }

            val returnNodeType = when (declaration) {
                is IrField -> declaration.type
                is IrFunction -> declaration.returnType
                else -> error(declaration)
            }

            val returnsNode = DataFlowIR.Node.Variable(
                    values = returnValues.map { expressionToEdge(it) },
                    type = symbolTable.mapType(returnNodeType),
                    kind = DataFlowIR.VariableKind.Temporary
            )
            val throwsNode = DataFlowIR.Node.Variable(
                    values = thrownValues.map { expressionToEdge(it) },
                    type = symbolTable.mapClassReferenceType(symbols.throwable.owner),
                    kind = DataFlowIR.VariableKind.Temporary
            )
            variables.forEach { (irVariable, node) ->
                val values = variableValues.elementData[irVariable]!!.values
                values.forEach { node.value.values += expressionToEdge(it) }
            }

            rootScope.nodes += templateParameters.values.map { it.value }
            rootScope.nodes += returnsNode
            rootScope.nodes += throwsNode

            return DataFlowIR.Function(
                    symbol = symbolTable.mapFunction(declaration),
                    body = DataFlowIR.FunctionBody(
                            rootScope, listOf(rootScope) + scopes.values, returnsNode, throwsNode)
            )
        }

        private fun expressionToEdge(expression: IrExpression) = expressionToScopedEdge(expression).value

        private fun expressionToScopedEdge(expression: IrExpression) =
                if (expression is IrTypeOperatorCall && expression.operator.isCast())
                    getNode(expression.argument).let {
                        Scoped(
                                DataFlowIR.Edge(
                                        it.value,
                                        symbolTable.mapClassReferenceType(expression.typeOperand.erasedUpperBound)
                                ), it.scope)
                    }
                else {
                    getNode(expression).let {
                        Scoped(
                                DataFlowIR.Edge(it.value, null),
                                it.scope
                        )
                    }
                }

        private fun mapWrappedType(actualType: IrType, wrapperType: IrType): DataFlowIR.Type {
            val wrapperInlinedClass = wrapperType.getInlinedClassNative()
            val actualInlinedClass = actualType.getInlinedClassNative()

            return if (wrapperInlinedClass == null) {
                if (actualInlinedClass == null) symbolTable.mapType(actualType) else symbolTable.mapClassReferenceType(actualInlinedClass)
            } else {
                symbolTable.mapType(wrapperType)
            }
        }

        private fun mapReturnType(actualType: IrType, returnType: IrType) = mapWrappedType(actualType, returnType)

        private fun getNode(expression: IrExpression): Scoped<DataFlowIR.Node> {
            if (expression is IrGetValue) {
                val valueDeclaration = expression.symbol.owner
                if (valueDeclaration is IrValueParameter)
                    return templateParameters[valueDeclaration]!!
                return variables[valueDeclaration]!!
            }
            return nodes.getOrPut(expression) {
                context.logMultiple {
                    +"Converting expression"
                    +ir2stringWhole(expression)
                }
                val values = mutableListOf<IrExpression>()
                val edges = mutableListOf<DataFlowIR.Edge>()
                var highestScope: DataFlowIR.Node.Scope? = null
                expressionValuesExtractor.forEachValue(expression) {
                    values += it
                    if (it != expression || values.size > 1) {
                        val edge = expressionToScopedEdge(it)
                        val scope = edge.scope
                        if (highestScope == null || highestScope!!.depth > scope.depth)
                            highestScope = scope
                        edges += edge.value
                    }
                }
                if (values.size == 1 && values[0] == expression) {
                    highestScope = expressionsScopes[expression] ?: error("Unknown expression: ${expression.dump()}")
                }
                if (values.size == 0)
                    highestScope = rootScope
                val node = if (values.size != 1) {
                    DataFlowIR.Node.Variable(
                            values = edges,
                            type = symbolTable.mapType(expression.type),
                            kind = DataFlowIR.VariableKind.Temporary
                    )
                } else {
                    val value = values[0]
                    if (value != expression) {
                        val edge = edges[0]
                        if (edge.castToType == null)
                            edge.node
                        else
                            DataFlowIR.Node.Variable(
                                    values = listOf(edge),
                                    type = symbolTable.mapType(expression.type),
                                    kind = DataFlowIR.VariableKind.Temporary
                            )
                    } else {
                        when (value) {
                            is IrGetValue -> getNode(value).value

                            is IrVararg -> DataFlowIR.Node.Const(symbolTable.mapType(value.type))

                            is IrFunctionReference -> {
                                val callee = value.symbol.owner
                                DataFlowIR.Node.FunctionReference(
                                        symbolTable.mapFunction(callee),
                                        symbolTable.mapType(value.type),
                                        /*TODO: substitute*/symbolTable.mapType(callee.returnType))
                            }

                            is IrConst ->
                                if (value.value == null)
                                    DataFlowIR.Node.Null
                                else
                                    DataFlowIR.Node.SimpleConst(symbolTable.mapType(value.type), value.value!!)

                            is IrConstantPrimitive ->
                                if (value.value.value == null)
                                    DataFlowIR.Node.Null
                                else
                                    DataFlowIR.Node.SimpleConst(mapWrappedType(value.value.type, value.type), value.value.value!!)

                            is IrGetObjectValue -> {
                                val constructor = if (value.type.isNothing()) {
                                    // <Nothing> is not a singleton though its instance is get with <IrGetObject> operation.
                                    null
                                } else {
                                    val objectClass = value.symbol.owner
                                    if (objectClass is IrLazyClass) {
                                        // Singleton has a private constructor which is not deserialized.
                                        null
                                    } else {
                                        symbolTable.mapFunction(objectClass.constructors.single())
                                    }
                                }
                                DataFlowIR.Node.Singleton(symbolTable.mapType(value.type), constructor, emptyList())
                            }

                            is IrConstructorCall -> {
                                val callee = value.symbol.owner
                                val arguments = value.getArgumentsWithIr().map { expressionToEdge(it.second) }
                                DataFlowIR.Node.NewObject(
                                        symbolTable.mapFunction(callee),
                                        arguments,
                                        symbolTable.mapClassReferenceType(callee.constructedClass),
                                        value
                                )
                            }

                            is IrCall -> when (value.symbol) {
                                in arrayGetSymbols -> {
                                    val actualCallee = value.actualCallee

                                    DataFlowIR.Node.ArrayRead(
                                            symbolTable.mapFunction(actualCallee),
                                            array = expressionToEdge(value.dispatchReceiver!!),
                                            index = expressionToEdge(value.getValueArgument(0)!!),
                                            type = mapReturnType(value.type, context.irBuiltIns.anyType),
                                            irCallSite = value)
                                }

                                in arraySetSymbols -> {
                                    val actualCallee = value.actualCallee
                                    DataFlowIR.Node.ArrayWrite(
                                            symbolTable.mapFunction(actualCallee),
                                            array = expressionToEdge(value.dispatchReceiver!!),
                                            index = expressionToEdge(value.getValueArgument(0)!!),
                                            value = expressionToEdge(value.getValueArgument(1)!!),
                                            type = mapReturnType(value.getValueArgument(1)!!.type, context.irBuiltIns.anyType))
                                }

                                createUninitializedInstanceSymbol ->
                                    DataFlowIR.Node.AllocInstance(symbolTable.mapClassReferenceType(
                                            value.getTypeArgument(0)!!.getClass()!!
                                    ), value)

                                reinterpret -> getNode(value.extensionReceiver!!).value

                                initInstanceSymbol -> {
                                    val thiz = expressionToEdge(value.getValueArgument(0)!!)
                                    val initializer = value.getValueArgument(1) as IrConstructorCall
                                    val arguments = listOf(thiz) + initializer.getArgumentsWithIr().map { expressionToEdge(it.second) }
                                    val callee = initializer.symbol.owner
                                    DataFlowIR.Node.StaticCall(
                                            symbolTable.mapFunction(callee),
                                            arguments,
                                            symbolTable.mapClassReferenceType(callee.constructedClass),
                                            symbolTable.mapClassReferenceType(symbols.unit.owner),
                                            null
                                    )
                                }

                                else -> {
                                    /*
                                     * Resolve owner of the call with special handling of Any methods:
                                     * if toString/eq/hc is invoked on an interface instance, we resolve
                                     * owner as Any and dispatch it via vtable.
                                     * Note: Keep on par with the codegen.
                                     */
                                    val callee = value.symbol.owner.let { it.findOverriddenMethodOfAny() ?: it }
                                    val arguments = value.getArgumentsWithIr()
                                            .map { expressionToEdge(it.second) }

                                    if (value.isVirtualCall) {
                                        val owner = callee.parentAsClass
                                        val actualReceiverType = value.dispatchReceiver!!.type
                                        val actualReceiverClassifier = actualReceiverType.classifierOrFail

                                        val receiverType =
                                                if (actualReceiverClassifier is IrTypeParameterSymbol
                                                        || !callee.isReal /* Could be a bridge. */)
                                                    symbolTable.mapClassReferenceType(owner)
                                                else {
                                                    if ((actualReceiverClassifier as IrClassSymbol).owner.isSubclassOf(owner)) {
                                                        symbolTable.mapClassReferenceType(actualReceiverClassifier.owner) // Box if inline class.
                                                    } else {
                                                        symbolTable.mapClassReferenceType(owner)
                                                    }
                                                }

                                        val isAnyMethod = callee.target.parentAsClass.isAny()
                                        if (owner.isInterface && !isAnyMethod) {
                                            val itablePlace = context.getLayoutBuilder(owner).itablePlace(callee)
                                            DataFlowIR.Node.ItableCall(
                                                    symbolTable.mapFunction(callee.target),
                                                    receiverType,
                                                    itablePlace.interfaceId,
                                                    itablePlace.methodIndex,
                                                    arguments,
                                                    mapReturnType(value.type, callee.target.returnType),
                                                    value
                                            )
                                        } else {
                                            val vtableIndex = if (isAnyMethod)
                                                context.getLayoutBuilder(context.irBuiltIns.anyClass.owner).vtableIndex(callee.target)
                                            else
                                                context.getLayoutBuilder(owner).vtableIndex(callee)
                                            DataFlowIR.Node.VtableCall(
                                                    symbolTable.mapFunction(callee.target),
                                                    receiverType,
                                                    vtableIndex,
                                                    arguments,
                                                    mapReturnType(value.type, callee.target.returnType),
                                                    value
                                            )
                                        }
                                    } else {
                                        val actualCallee = value.actualCallee
                                        DataFlowIR.Node.StaticCall(
                                                symbolTable.mapFunction(actualCallee),
                                                arguments,
                                                actualCallee.dispatchReceiverParameter?.let { symbolTable.mapType(it.type) },
                                                mapReturnType(value.type, actualCallee.returnType),
                                                value
                                        )
                                    }
                                }
                            }

                            is IrDelegatingConstructorCall -> {
                                val thisReceiver = (declaration as IrConstructor).constructedClass.thisReceiver!!
                                val thiz = IrGetValueImpl(SYNTHETIC_OFFSET, SYNTHETIC_OFFSET, thisReceiver.type,
                                        thisReceiver.symbol)
                                val arguments = listOf(thiz) + value.getArgumentsWithIr().map { it.second }
                                DataFlowIR.Node.StaticCall(
                                        symbolTable.mapFunction(value.symbol.owner),
                                        arguments.map { expressionToEdge(it) },
                                        symbolTable.mapType(thiz.type),
                                        symbolTable.mapClassReferenceType(symbols.unit.owner),
                                        value
                                )
                            }

                            is IrGetField -> {
                                val receiver = value.receiver?.let { expressionToEdge(it) }
                                DataFlowIR.Node.FieldRead(
                                        receiver,
                                        symbolTable.mapField(value.symbol.owner),
                                        mapReturnType(value.type, value.symbol.owner.type),
                                        value
                                )
                            }

                            is IrSetField -> {
                                val receiver = value.receiver?.let { expressionToEdge(it) }
                                DataFlowIR.Node.FieldWrite(
                                        receiver,
                                        symbolTable.mapField(value.symbol.owner),
                                        expressionToEdge(value.value)
                                )
                            }

                            is IrTypeOperatorCall -> {
                                assert(!value.operator.isCast()) { "Casts should've been handled earlier" }
                                expressionToEdge(value.argument) // Put argument as a separate vertex.
                                DataFlowIR.Node.Const(symbolTable.mapType(value.type)) // All operators except casts are basically constants.
                            }

                            is IrConstantArray ->
                                DataFlowIR.Node.Singleton(symbolTable.mapType(value.type), null, null)
                            is IrConstantObject ->
                                DataFlowIR.Node.Singleton(
                                        symbolTable.mapType(value.type),
                                        symbolTable.mapFunction(value.constructor.owner),
                                        value.valueArguments.map { expressionToEdge(it) }
                                )

                            else -> TODO("Unknown expression: ${ir2stringWhole(value)}")
                        }
                    }
                }

                highestScope!!.nodes += node
                Scoped(node, highestScope!!)
            }
        }
    }
}

internal class ModuleDFG(val functions: MutableMap<DataFlowIR.FunctionSymbol, DataFlowIR.Function>,
                         val symbolTable: DataFlowIR.SymbolTable)

internal class ModuleDFGBuilder(val generationState: NativeGenerationState, val irModule: IrModuleFragment) {
    private val context = generationState.context
    private val module = DataFlowIR.Module()
    private val symbolTable = DataFlowIR.SymbolTable(context, module)

    fun build(): ModuleDFG {
        symbolTable.populateWith(irModule)

        val functions = mutableMapOf<DataFlowIR.FunctionSymbol, DataFlowIR.Function>()
        irModule.accept(object : IrElementVisitorVoid {
            override fun visitElement(element: IrElement) {
                element.acceptChildrenVoid(this)
            }

            override fun visitConstructor(declaration: IrConstructor) {
                val body = declaration.body
                assert (body != null) {
                    "Class constructor has empty body"
                }
                context.logMultiple {
                    +"Analysing function ${declaration.render()}"
                    +"IR: ${ir2stringWhole(declaration)}"
                }
                analyze(declaration, body)
            }

            override fun visitFunction(declaration: IrFunction) {
                val body = declaration.body
                if (body == null) {
                    // External function or intrinsic.
                    symbolTable.mapFunction(declaration)
                } else {
                    context.logMultiple {
                        +"Analysing function ${declaration.render()}"
                        +"IR: ${ir2stringWhole(declaration)}"
                    }
                    analyze(declaration, body)
                }
            }

            override fun visitField(declaration: IrField) {
                if (declaration.isStatic)
                    declaration.initializer?.let {
                        context.logMultiple {
                            +"Analysing global field ${declaration.render()}"
                            +"IR: ${ir2stringWhole(declaration)}"
                        }
                        analyze(declaration, IrSetFieldImpl(it.startOffset, it.endOffset, declaration.symbol, null,
                                it.expression, context.irBuiltIns.unitType))
                    }
            }

            private fun analyze(declaration: IrDeclaration, body: IrElement?) {
                val function = FunctionDFGBuilder(generationState, symbolTable).build(declaration, body)
                functions[function.symbol] = function
            }
        }, data = null)

        context.logMultiple {
            +"SYMBOL TABLE:"
            symbolTable.classMap.forEach { (irClass, type) ->
                +"    IR CLASS: ${irClass.render()}"
                +"    TYPE: $type"
                +"        SUPER TYPES:"
                type.superTypes.forEach { +"            $it" }
                +"        VTABLE:"
                type.vtable.forEach { +"            $it" }
                +"        ITABLE:"
                type.itable.forEach { +"            ${it.key} -> ${it.value}" }
            }
        }

        return ModuleDFG(functions, symbolTable)
    }
}
