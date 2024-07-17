/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.backend.js.lower

import org.jetbrains.kotlin.backend.common.DeclarationTransformer
import org.jetbrains.kotlin.backend.common.lower.createIrBuilder
import org.jetbrains.kotlin.backend.common.lower.irBlockBody
import org.jetbrains.kotlin.descriptors.DescriptorVisibilities
import org.jetbrains.kotlin.ir.backend.js.JsIrBackendContext
import org.jetbrains.kotlin.ir.backend.js.export.isExported
import org.jetbrains.kotlin.ir.backend.js.ir.JsIrBuilder
import org.jetbrains.kotlin.ir.backend.js.utils.JsAnnotations
import org.jetbrains.kotlin.ir.backend.js.utils.getJsName
import org.jetbrains.kotlin.ir.backend.js.utils.realOverrideTarget
import org.jetbrains.kotlin.ir.builders.*
import org.jetbrains.kotlin.ir.builders.declarations.buildFun
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.expressions.impl.IrConstructorCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.fromSymbolOwner
import org.jetbrains.kotlin.ir.types.defaultType
import org.jetbrains.kotlin.ir.util.*
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.name.SpecialNames


class PrepareSuspendFunctionsToExportLowering(private val context: JsIrBackendContext) : DeclarationTransformer {
    companion object {
        const val PROMISIFIED_WRAPPER_SUFFIX = "\$promisified"
        const val ORIGINAL_FUNCTION_BODY_SAVER_SUFFIX = "\$original"

        private val PROMISIFIED_WRAPPER by IrDeclarationOriginImpl
        private val ORIGINAL_FUNCTION_BODY_SAVER by IrDeclarationOriginImpl
    }

    private val dynamicType = context.dynamicType
    private val promiseClass = context.intrinsics.promiseClassSymbol
    private val jsNameAnnotation = context.intrinsics.jsNameAnnotationSymbol.owner.constructors.single()
    private val awaitFunctionSymbol = context.intrinsics.awaitFunctionSymbol
    private val jsClassFunctionSymbol = context.intrinsics.jsClass
    private val jsEqeqeqFunctionSymbol = context.intrinsics.jsEqeqeq
    private val promisifyFunctionSymbol = context.intrinsics.promisifyFunctionSymbol
    private val jsExportIgnoreAnnotation = context.intrinsics.jsExportIgnoreAnnotationSymbol.owner.constructors.single()
    private val jsPrototypeFunctionSymbol = context.intrinsics.jsPrototypeOfSymbol
    private val suspendFunctionClassSymbol = context.irBuiltIns.suspendFunctionN(0)

    override fun transformFlat(declaration: IrDeclaration): List<IrDeclaration>? {
        if (declaration is IrSimpleFunction && declaration.isSuspend && declaration.isExported(context)) {
            val realOverrideTarget = declaration.realOverrideTarget

            if (realOverrideTarget !== declaration) {
                if (realOverrideTarget.body == null) realOverrideTarget.excludeFromExport()
                return null
            }

            val promisifiedWrapperFunction = generatePromisifiedWrapper(declaration)

            return if (declaration.isTopLevel) {
                listOf(declaration, promisifiedWrapperFunction)
            } else {
                val originalBodySaverFunction = generateOriginalBodySaverFunction(declaration)
                declaration.replaceBodyWithBridge(originalBodySaverFunction, promisifiedWrapperFunction)
                return listOf(declaration, promisifiedWrapperFunction, originalBodySaverFunction)
            }
        }

        return null
    }

    private fun generateOriginalBodySaverFunction(originalFunc: IrSimpleFunction): IrSimpleFunction {
        return context.irFactory.buildFun {
            updateFrom(originalFunc)
            name = Name.identifier("${originalFunc.name}${ORIGINAL_FUNCTION_BODY_SAVER_SUFFIX}")
            origin = ORIGINAL_FUNCTION_BODY_SAVER
            returnType = originalFunc.returnType
        }.apply {
            parent = originalFunc.parent
            valueParameters = originalFunc.valueParameters
            typeParameters = originalFunc.typeParameters
            dispatchReceiverParameter = originalFunc.dispatchReceiverParameter
            extensionReceiverParameter = originalFunc.extensionReceiverParameter
            contextReceiverParametersCount = originalFunc.contextReceiverParametersCount
            body = originalFunc.body
            annotations = originalFunc.annotations + listOf(generateExportIgnore())
        }
    }

    private fun IrSimpleFunction.replaceBodyWithBridge(
        originalBodySaverFunction: IrSimpleFunction,
        promisifiedWrapperFunction: IrSimpleFunction,
    ) {
        val originalFunc = this
        originalFunc.copyParameterDeclarationsFrom(originalBodySaverFunction)

        val originalName =
            promisifiedWrapperFunction.getJsName() ?: error("Promisified wrapper function should contain at least one @JsName annotation")
        val dispatchReceiverParameter =
            originalFunc.dispatchReceiverParameter ?: error("This function should be applied only to a member function")

        originalFunc.body = context.createIrBuilder(originalFunc.symbol).irBlockBody(originalFunc) {
            val isTheExportedFunctionOverridden = irCall(jsEqeqeqFunctionSymbol).apply {
                putValueArgument(
                    0,
                    JsIrBuilder.buildDynamicMemberExpression(irGet(dispatchReceiverParameter), originalName, dynamicType)
                )
                putValueArgument(
                    1,
                    JsIrBuilder.buildDynamicMemberExpression(
                        irCall(jsPrototypeFunctionSymbol).apply {
                            putValueArgument(0, irCall(jsClassFunctionSymbol).apply { putTypeArgument(0, dispatchReceiverParameter.type) })
                        },
                        originalName,
                        dynamicType
                    )
                )
            }
            +irReturn(
                irIfThenElse(
                    originalFunc.returnType,
                    isTheExportedFunctionOverridden,
                    irCallWithParametersOf(originalBodySaverFunction, originalFunc),
                    irCall(awaitFunctionSymbol).apply {
                        putValueArgument(
                            0,
                            irCallWithParametersOf(promisifiedWrapperFunction, originalFunc)
                        )
                    }
                )
            )
        }
    }

    private fun generatePromisifiedWrapper(originalFunc: IrSimpleFunction): IrSimpleFunction {
        return context.irFactory.buildFun {
            updateFrom(originalFunc)
            name = Name.identifier("${originalFunc.name}${PROMISIFIED_WRAPPER_SUFFIX}")
            origin = PROMISIFIED_WRAPPER
            isSuspend = false
            returnType = promiseClass.defaultType
                .substitute(promiseClass.owner.typeParameters, listOf(originalFunc.returnType))
        }.apply {
            parent = originalFunc.parent
            copyParameterDeclarationsFrom(originalFunc)

            val (exportAnnotations, irrelevantAnnotations) = originalFunc.annotations.partition {
                it.isAnnotation(JsAnnotations.jsExportFqn) || it.isAnnotation(JsAnnotations.jsNameFqn)
            }

            annotations += exportAnnotations

            if (!exportAnnotations.any { it.isAnnotation(JsAnnotations.jsNameFqn) }) {
                annotations += IrConstructorCallImpl.fromSymbolOwner(jsNameAnnotation.returnType, jsNameAnnotation.symbol).apply {
                    putValueArgument(0, originalFunc.name.asString().toIrConst(context.irBuiltIns.stringType))
                }
            }

            originalFunc.annotations = irrelevantAnnotations + listOf(generateExportIgnore())

            body = context.createIrBuilder(symbol).irBlockBody(this) {
                val call = irCallWithParametersOf(originalFunc, this@apply).also {
                    it.dispatchReceiver = dispatchReceiverParameter?.let(::irGet)
                    it.extensionReceiver = extensionReceiverParameter?.let(::irGet)
                    it.contextReceiversCount = contextReceiverParametersCount
                }

                val promisifiedSuspendLambda = context.irFactory.buildFun {
                    name = SpecialNames.NO_NAME_PROVIDED
                    visibility = DescriptorVisibilities.LOCAL
                    isSuspend = true
                    returnType = call.type
                }.also {
                    it.parent = this@apply
                    it.body = irBlockBody(it) { +irReturn(call) }
                }

                +irReturn(
                    irCall(promisifyFunctionSymbol).apply {
                        putValueArgument(
                            0,
                            JsIrBuilder.buildFunctionExpression(
                                suspendFunctionClassSymbol.defaultType.substitute(
                                    suspendFunctionClassSymbol.typeParameters,
                                    listOf(call.type)
                                ),
                                promisifiedSuspendLambda
                            )
                        )
                    }
                )
            }
        }
    }

    private fun IrBuilderWithScope.irCallWithParametersOf(functionToCall: IrSimpleFunction, parametersSource: IrSimpleFunction): IrCall {
        return irCall(functionToCall.symbol).apply {
            parametersSource.valueParameters.forEachIndexed { index, irValueParameter ->
                putValueArgument(index, irGet(irValueParameter))
            }
        }
    }

    private fun IrSimpleFunction.excludeFromExport() {
        annotations = annotations
            .filter { !it.isAnnotation(JsAnnotations.jsExportFqn) && !it.isAnnotation(JsAnnotations.jsNameFqn) }
            .plus(listOf(generateExportIgnore()))
    }

    private fun generateExportIgnore(): IrConstructorCall =
        IrConstructorCallImpl.fromSymbolOwner(jsExportIgnoreAnnotation.returnType, jsExportIgnoreAnnotation.symbol)
}
