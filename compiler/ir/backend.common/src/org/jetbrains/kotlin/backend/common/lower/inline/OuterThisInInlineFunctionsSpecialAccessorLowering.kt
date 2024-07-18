/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.common.lower.inline

import org.jetbrains.kotlin.backend.common.CommonBackendContext
import org.jetbrains.kotlin.backend.common.FileLoweringPass
import org.jetbrains.kotlin.backend.common.lower.inline.OuterThisInInlineFunctionsSpecialAccessorLowering.TransformerData.Companion.createNewData
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin.Companion.INSTANCE_RECEIVER
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrGetValue
import org.jetbrains.kotlin.ir.expressions.impl.IrCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrGetValueImpl
import org.jetbrains.kotlin.ir.expressions.impl.fromSymbolOwner
import org.jetbrains.kotlin.ir.util.irError
import org.jetbrains.kotlin.ir.visitors.*

class OuterThisInInlineFunctionsSpecialAccessorLowering(context: CommonBackendContext) : FileLoweringPass {
    private val accessorGenerator = KlibSyntheticAccessorGenerator(context)

    override fun lower(irFile: IrFile) {
        if (irFile.module.name.asString() != "<kotlin>")
            print("")

        irFile.transformChildren(Transformer(), null)
    }

    private class TransformerData private constructor(
        val parent: TransformerData?,
        val clazz: IrClass,
        val inlineFunction: IrFunction?,
        val accessors: MutableSet<IrSimpleFunction>
    ) {
        val level: Int = parent?.let { it.level + 1 } ?: 0

        fun findParentData(outerClass: IrClass): TransformerData? =
            if (outerClass == clazz) this else parent?.findParentData(outerClass)

        companion object {
            fun createNewData(data: TransformerData?, clazz: IrClass): TransformerData {
                return TransformerData(
                    parent = data,
                    clazz,
                    inlineFunction = data?.inlineFunction,
                    accessors = hashSetOf()
                )
            }

            fun createNewData(data: TransformerData?, function: IrFunction): TransformerData? {
                return if (data == null || !function.isInline)
                    data
                else
                    TransformerData(
                        parent = data.parent,
                        clazz = data.clazz,
                        inlineFunction = function,
                        accessors = data.accessors
                    )
            }
        }
    }

    private inner class Transformer : IrElementTransformer<TransformerData?> {

        override fun visitClass(declaration: IrClass, data: TransformerData?): IrStatement {
            val newData = createNewData(data, clazz = declaration)

            super.visitClass(declaration, newData)

            val pendingAccessors = newData.accessors
            when (pendingAccessors.size) {
                0 -> Unit
                1 -> declaration.declarations += pendingAccessors.first()
                else -> {
                    // Sort accessors to always have a stable order.
                    declaration.declarations += pendingAccessors.sortedBy { it.name }
                }
            }

            return declaration
        }

        override fun visitFunction(declaration: IrFunction, data: TransformerData?): IrStatement {
            val newData = createNewData(data, declaration)

            // Wrap it to the stage controller to avoid JS BE failing with not found lowered declaration signature
            // in `IrDeclaration.signatureForJsIC` cache.
            return declaration.factory.stageController.restrictTo(declaration) {
                super.visitFunction(declaration, newData)
            }
        }

        override fun visitGetValue(expression: IrGetValue, data: TransformerData?): IrExpression {
            val inlineFunction = data?.inlineFunction
                ?: // Don't inspect value parameters inside non-inline functions.
                return expression

            val valueParameter = expression.symbol.owner as? IrValueParameter
            if (valueParameter?.origin != INSTANCE_RECEIVER)
                return expression

            val outerClass = valueParameter.parent as? IrClass
                ?: return expression

            val innerClass = data.clazz
            if (outerClass == innerClass)
                return expression

            val outerClassData = data.findParentData(outerClass)
                ?: irError("No outer class found for inner class") {
                    withIrEntry("innerClass", innerClass)
                    withIrEntry("outerClass", outerClass)
                }

            val accessor = accessorGenerator.getSyntheticOuterThisParameterAccessor(
                expression,
                valueParameter,
                levelDifference = data.level - outerClassData.level,
                innerClass
            )

            data.accessors += accessor

            return IrCallImpl.fromSymbolOwner(expression.startOffset, expression.endOffset, accessor.symbol).apply {
                dispatchReceiver = IrGetValueImpl(
                    startOffset,
                    endOffset,
                    inlineFunction.dispatchReceiverParameter!!.symbol,
                    origin
                )
            }
        }
    }
}
