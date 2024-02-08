/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.jvm.codegen

import org.jetbrains.kotlin.backend.jvm.MultifileFacadeFileEntry
import org.jetbrains.kotlin.backend.jvm.ir.fileParentBeforeInline
import org.jetbrains.kotlin.backend.jvm.ir.getAttributeOwnerBeforeInline
import org.jetbrains.kotlin.backend.jvm.ir.isInlineOnly
import org.jetbrains.kotlin.backend.jvm.mapping.mapClass
import org.jetbrains.kotlin.codegen.inline.SMAP
import org.jetbrains.kotlin.codegen.inline.SourceMapCopier
import org.jetbrains.kotlin.codegen.inline.SourceMapper
import org.jetbrains.kotlin.codegen.inline.SourcePosition
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.IrFunction
import org.jetbrains.kotlin.ir.declarations.IrValueParameter
import org.jetbrains.kotlin.ir.declarations.name
import org.jetbrains.kotlin.ir.expressions.IrFunctionExpression
import org.jetbrains.kotlin.ir.expressions.IrGetValue
import org.jetbrains.kotlin.ir.expressions.IrInlinedFunctionBlock
import org.jetbrains.kotlin.ir.util.*
import org.jetbrains.kotlin.util.OperatorNameConventions
import org.jetbrains.org.objectweb.asm.Label
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * This class serves two purposes:
 * 1. Generate line numbers for given `IrElement`
 * 2. Keep track of `smap` for functions inlined by IR inliner. We can consider this class as basically just another wrapper around SMAP.
 * It is used to unify smap creation for functions inlined from IR and from bytecode.
 */
class LineNumberMapper(private val expressionCodegen: ExpressionCodegen) {
    private val smap = expressionCodegen.smap
    private val irFunction = expressionCodegen.irFunction
    private val fileEntry = irFunction.fileParentBeforeInline.fileEntry

    private var lastLineNumber: Int = -1
    private var lastLineNumberBeforeInline: Int = -1
    private var noLineNumberScope: Boolean = false

    private val sourceMapCopierStack = mutableListOf<SourceMapCopier>()
    private val inlineBlockStack = mutableListOf<IrInlinedFunctionBlock>()

    private data class DataForIrInlinedFunction(
        val smap: SourceMapCopier,
        val inlinedBlock: IrInlinedFunctionBlock,
        val parentSmap: SourceMapper, // this property is used to simulate change in smap but without ruining previous one
        val tryInfo: TryWithFinallyInfo?
    )

    private fun markNewLabel() = Label().apply { expressionCodegen.mv.visitLabel(this) }

    fun markLineNumber(element: IrElement, startOffset: Boolean) {
        if (noLineNumberScope) return
        val offset = if (startOffset) element.startOffset else element.endOffset
        if (offset < 0) return

        val lineNumber = getLineNumberForOffset(offset)

        assert(lineNumber > 0)
        if (lastLineNumber != lineNumber) {
            lastLineNumber = lineNumber
            expressionCodegen.mv.visitLineNumber(lineNumber, markNewLabel())
        }

        if (inlineBlockStack.isEmpty() && lastLineNumberBeforeInline != lineNumber) {
            lastLineNumberBeforeInline = lineNumber
        }
    }

    @OptIn(ExperimentalContracts::class)
    internal inline fun noLineNumberScopeWithCondition(flag: Boolean, block: () -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        val previousState = noLineNumberScope
        noLineNumberScope = noLineNumberScope || flag
        block()
        noLineNumberScope = previousState
    }

    fun noLineNumberScope(block: () -> Unit) {
        val previousState = noLineNumberScope
        noLineNumberScope = true
        block()
        noLineNumberScope = previousState
    }

    fun markLineNumberAfterInlineIfNeeded(registerLineNumberAfterwards: Boolean) {
        if (noLineNumberScope || registerLineNumberAfterwards) {
            if (lastLineNumber > -1) {
                val label = Label()
                expressionCodegen.mv.visitLabel(label)
                expressionCodegen.mv.visitLineNumber(lastLineNumber, label)
            }
        } else {
            // Inline function has its own line number which is in a separate instance of codegen,
            // therefore we need to reset lastLineNumber to force a line number generation after visiting inline function.
            lastLineNumber = -1
        }
    }

    fun getLineNumber(): Int {
        return lastLineNumber
    }

    fun resetLineNumber() {
        lastLineNumber = -1
    }

    fun beforeIrInline(inlinedBlock: IrInlinedFunctionBlock) {
        if (inlinedBlock.isLambdaInlining()) {
            setUpAdditionalLineNumbersBeforeLambdaInlining(inlinedBlock)
        }
    }

    fun afterIrInline(inlinedBlock: IrInlinedFunctionBlock) {
        if (inlinedBlock.isFunctionInlining()) {
            val callLineNumber = getLineNumberForOffset(inlinedBlock.inlineCall.startOffset)
            // `takeUnless` is required to avoid `markLineNumberAfterInlineIfNeeded` for inline only
            lastLineNumber = callLineNumber.takeUnless { noLineNumberScope } ?: -1
            markLineNumberAfterInlineIfNeeded(expressionCodegen.isInsideCondition)
        } else {
            setUpAdditionalLineNumbersAfterLambdaInlining(inlinedBlock)
        }
    }

    fun dropCurrentSmap() {
        sourceMapCopierStack.removeFirst()
        inlineBlockStack.removeFirst()
    }

    private fun getLineNumberForOffset(offset: Int): Int {
        val line = if (sourceMapCopierStack.isEmpty()) {
            fileEntry.getLineNumber(offset) + 1
        } else {
            val currentFileEntry = inlineBlockStack.firstOrNull()?.inlineDeclaration?.fileParentBeforeInline?.fileEntry ?: fileEntry
            val lineNumber = currentFileEntry.getLineNumber(offset) + 1
            sourceMapCopierStack.first().mapLineNumber(lineNumber)
        }
        return line
    }

    fun buildSmapFor(inlinedBlock: IrInlinedFunctionBlock/*, classSMAP: SMAP, data: BlockInfo*/) {
        // TODO can I do KotlinDebug to be the same as for bytecode inliner?
//        val callSite = if (inlinedBlock.isLambdaInlining()) {
//            val callSite = sourceMapCopierStack.firstOrNull()?.callSite?.takeIf { inlinedBlock.isInvokeOnDefaultArg() }
//            callSite
//        } else {
//            val currentFile = if (inlineBlockStack.isEmpty()) {
//                irFunction.fileParentBeforeInline
//            } else {
//                inlineBlockStack.last().inlineDeclaration.fileParentBeforeInline
//            }
//
//            val sourceFileName = when (val currentFileEntry = currentFile.fileEntry) {
//                is MultifileFacadeFileEntry -> currentFileEntry.partFiles.single().name
//                else -> currentFile.name
//            }
//
//            val currentClass = if (inlineBlockStack.isEmpty()) {
//                expressionCodegen.classCodegen.irClass
//            } else {
//                inlineBlockStack.last().inlineDeclaration.parentClassOrNull!!
//            }
//            val type = currentClass.getAttributeOwnerBeforeInline()?.let { expressionCodegen.context.getLocalClassType(it) }
//                ?: expressionCodegen.context.defaultTypeMapper.mapClass(currentClass)
//
//            val offset = inlinedBlock.inlineCall.startOffset
//            val line = currentFile.fileEntry.getLineNumber(offset) + 1
//
//            val sourcePosition = SourcePosition(line, sourceFileName, type.internalName)
//            sourcePosition
//        }
        var callSite: SourcePosition? = null
        if (inlineBlockStack.isEmpty() && !inlinedBlock.isLambdaInlining()) {
            val currentFile = irFunction.fileParentBeforeInline

            val sourceFileName = when (val currentFileEntry = currentFile.fileEntry) {
                is MultifileFacadeFileEntry -> currentFileEntry.partFiles.single().name
                else -> currentFile.name
            }

            val currentClass = expressionCodegen.classCodegen.irClass
            val type = currentClass.getAttributeOwnerBeforeInline()?.let { expressionCodegen.context.getLocalClassType(it) }
                ?: expressionCodegen.context.defaultTypeMapper.mapClass(currentClass)

//            val offset = inlinedBlock.inlineCall.startOffset
            val line = lastLineNumberBeforeInline//currentFile.fileEntry.getLineNumber(offset) + 1
            callSite = SourcePosition(line, sourceFileName, type.internalName)
        } else if (inlinedBlock.isLambdaInlining()) {
            callSite = sourceMapCopierStack.firstOrNull()?.callSite//?.takeIf { inlinedBlock.isInvokeOnDefaultArg() }
        } else {
            callSite = sourceMapCopierStack.firstOrNull()?.callSite
        }

        val emptySourceMapper = expressionCodegen.context.getSourceMapper(inlinedBlock.inlineDeclaration.parentClassOrNull!!)
        val emptySMAP = SMAP(emptySourceMapper.resultMappings)
        val newCopier = SourceMapCopier(smap, emptySMAP, callSite)

        inlineBlockStack.add(0, inlinedBlock)
        sourceMapCopierStack.add(0, newCopier)
    }

    private fun setUpAdditionalLineNumbersBeforeLambdaInlining(inlinedBlock: IrInlinedFunctionBlock) {
        val lineNumberForOffset = getLineNumberForOffset(inlinedBlock.inlineCall.startOffset)
        val callee = inlinedBlock.inlineDeclaration as? IrFunction

        // TODO: reuse code from org/jetbrains/kotlin/codegen/inline/MethodInliner.kt:267
        val overrideLineNumber = inlineBlockStack
            .firstOrNull { !it.isLambdaInlining() }?.inlineDeclaration?.isInlineOnly() == true
        val currentLineNumber = if (overrideLineNumber) sourceMapCopierStack.first().callSite!!.line else lineNumberForOffset

        val firstLine = callee?.body?.statements?.firstOrNull()?.let {
            inlinedBlock.inlineDeclaration.fileEntry.getLineNumber(it.startOffset) + 1
        } ?: -1
        if ((inlinedBlock.isInvokeOnDefaultArg() != overrideLineNumber) && currentLineNumber >= 0 && firstLine == currentLineNumber) {
            val label = Label()
            val fakeLineNumber = (sourceMapCopierStack.firstOrNull()?.parent ?: smap)
                .mapSyntheticLineNumber(SourceMapper.LOCAL_VARIABLE_INLINE_ARGUMENT_SYNTHETIC_LINE_NUMBER)
            expressionCodegen.mv.visitLabel(label)
            expressionCodegen.mv.visitLineNumber(fakeLineNumber, label)
        }
    }

    private fun setUpAdditionalLineNumbersAfterLambdaInlining(inlinedBlock: IrInlinedFunctionBlock) {
        val lineNumberForOffset = getLineNumberForOffset(inlinedBlock.inlineCall.startOffset)

        // TODO: reuse code from org/jetbrains/kotlin/codegen/inline/MethodInliner.kt:316
        val overrideLineNumber = inlineBlockStack
            .firstOrNull { !it.isLambdaInlining() }?.inlineDeclaration?.isInlineOnly() == true
        val currentLineNumber = if (overrideLineNumber) sourceMapCopierStack.first().callSite!!.line else lineNumberForOffset
        if (currentLineNumber != -1) {
            if (overrideLineNumber) {
                // This is from the function we're inlining into, so no need to remap.
                expressionCodegen.mv.visitLineNumber(currentLineNumber, markNewLabel())
            } else {
                // Need to go through the superclass here to properly remap the line number via `sourceMapper`.
                markLineNumber(inlinedBlock.inlineCall, startOffset = true)
            }
            expressionCodegen.mv.nop()
        }
    }

    private fun IrInlinedFunctionBlock.isInvokeOnDefaultArg(): Boolean {
        val call = this.inlineCall
        val expected = this.inlineDeclaration
        if (call.symbol.owner.name != OperatorNameConventions.INVOKE) return false

        val dispatch = call.dispatchReceiver as? IrGetValue
        val parameter = dispatch?.symbol?.owner as? IrValueParameter
        val default = parameter?.defaultValue?.expression as? IrFunctionExpression

        return default?.function == expected
    }
}