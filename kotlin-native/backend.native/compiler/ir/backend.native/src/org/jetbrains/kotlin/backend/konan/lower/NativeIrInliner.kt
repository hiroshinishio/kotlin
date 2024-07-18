/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.konan.lower

import org.jetbrains.kotlin.backend.konan.NativeGenerationState
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.declarations.IrFunction
import org.jetbrains.kotlin.ir.inline.FunctionInlining
import org.jetbrains.kotlin.ir.inline.isConsideredAsPrivateForInlining
import org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid
import org.jetbrains.kotlin.ir.visitors.acceptChildrenVoid

internal class NativeIrInliner(
        context: NativeGenerationState,
        private val inlineOnlyPrivateFunctions: Boolean
) : FunctionInlining(
        context = context.context,
        NativeInlineFunctionResolver(context, inlineOnlyPrivateFunctions),
        insertAdditionalImplicitCasts = true,
        produceOuterThisFields = false,
) {
    override fun lower(irFile: IrFile) {
        // For consistency, it's important to memoize already lowered inline functions exactly in the same state
        // as they were immediately before inlining.
        irFile.acceptChildrenVoid(object : IrElementVisitorVoid {
            override fun visitElement(element: IrElement) = element.acceptChildrenVoid(this)

            override fun visitFunction(declaration: IrFunction) {
                /** There may be local inline lambdas generated by [NativeInlineCallableReferenceToLambdaPhase].
                 * They need to be memoized even if enclosing function is public. */
                declaration.acceptChildrenVoid(this)

                if (declaration.isInline) {
                    if (!inlineOnlyPrivateFunctions || declaration.isConsideredAsPrivateForInlining()) {
                        declaration.getOrSaveLoweredInlineFunction()
                    }
                }
            }
        })

        super.lower(irFile)
    }
}
