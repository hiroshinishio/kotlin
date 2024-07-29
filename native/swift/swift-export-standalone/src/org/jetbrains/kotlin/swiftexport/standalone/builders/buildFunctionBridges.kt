/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.swiftexport.standalone.builders

import org.jetbrains.kotlin.analysis.api.symbols.*
import org.jetbrains.kotlin.name.ErrorProneFqNamesApi
import org.jetbrains.kotlin.sir.*
import org.jetbrains.kotlin.sir.bridge.*
import org.jetbrains.kotlin.sir.providers.source.KotlinSource
import org.jetbrains.kotlin.sir.util.*
import org.jetbrains.kotlin.utils.addIfNotNull

internal fun buildBridgeRequests(generator: BridgeGenerator, container: SirDeclarationContainer): List<BridgeRequest> = buildList {
    addAll(
        container
            .allCallables()
            .filterIsInstance<SirInit>()
            .flatMap { it.constructBridgeRequests(generator) }
    )
    addAll(
        container
            .allCallables()
            .filterIsInstance<SirFunction>()
            .flatMap { it.constructBridgeRequests(generator) }
    )
    addAll(
        container
            .allVariables()
            .flatMap { it.constructBridgeRequests(generator) }
    )
    addAll(
        container
            .allContainers()
            .flatMap { buildBridgeRequests(generator, it) }
    )
}

private fun SirFunction.constructBridgeRequests(generator: BridgeGenerator): List<BridgeRequest> {
    @OptIn(ErrorProneFqNamesApi::class)
    val fqName = ((origin as? KotlinSource)?.symbol as? KaFunctionSymbol)
        ?.callableId?.asSingleFqName()
        ?.pathSegments()?.map { it.toString() }
        ?: return emptyList()

    return listOfNotNull(
        patchCallableBodyAndGenerateRequest(generator, fqName)
    )
}

private fun SirVariable.constructBridgeRequests(generator: BridgeGenerator): List<BridgeRequest> {
    @OptIn(ErrorProneFqNamesApi::class)
    val fqName = when (val origin = origin) {
        is KotlinSource -> (origin.symbol as? KaVariableSymbol)
            ?.callableId?.asSingleFqName()
            ?.pathSegments()?.map { it.toString() }
        is SirOrigin.ObjectAccessor -> ((origin.`for` as KotlinSource).symbol as KaNamedClassSymbol)
            .classId?.asSingleFqName()
            ?.pathSegments()?.map { it.toString() }
        else -> null
    } ?: return emptyList()

    val res = mutableListOf<BridgeRequest>()
    accessors.forEach {
        res.addIfNotNull(
            it.patchCallableBodyAndGenerateRequest(generator, fqName)
        )
    }

    return res.toList()
}

private fun SirInit.constructBridgeRequests(generator: BridgeGenerator): List<BridgeRequest> {
    if (origin is SirOrigin.KotlinBaseInitOverride) {
        val names = parameters.map { it.argumentName!! }
        body = SirFunctionBody(buildList {
            add("super.init(${names.joinToString(separator = ", ") { "$it: $it" }})")
        })
        return emptyList()
    }
    @OptIn(ErrorProneFqNamesApi::class)
    val fqName = ((origin as? KotlinSource)?.symbol as? KaConstructorSymbol)
        ?.containingClassId?.asSingleFqName()
        ?.pathSegments()?.map { it.toString() }
        ?: return emptyList()

    return listOfNotNull(
        patchCallableBodyAndGenerateRequest(generator, fqName)
    )
}

private fun SirCallable.patchCallableBodyAndGenerateRequest(
    generator: BridgeGenerator,
    fqName: List<String>,
): BridgeRequest? {
    val typesUsed = listOf(returnType) + allParameters.map { it.type }
    if (typesUsed.any { !it.isSupported })
        return null
    if (allParameters.any { it.type.isNever })
        return null // If any of the parameters is never - there should be no ability to call this function - therefor we can skip the bridge generation
    val suffix = bridgeSuffix
    val request = BridgeRequest(
        this,
        fqName.forBridge.joinToString("_") + suffix,
        fqName
    )
    body = generator.generateSirFunctionBody(request)
    return request
}

private val SirType.isSupported: Boolean
    get() = when (this) {
        is SirNominalType -> when (val declaration = type) {
            is SirTypealias -> declaration.type.isSupported
            else -> true
        }
        else -> false
    }

private val SirCallable.bridgeSuffix: String
    get() = when (this) {
        is SirAccessor -> "_$bridgeSuffix"
        is SirInit -> "_init"
        else -> ""
    }

private val SirAccessor.bridgeSuffix: String
    get() = when (this) {
        is SirGetter -> "get"
        is SirSetter -> "set"
    }

private val List<String>.forBridge: List<String>
    get() = if (this.count() == 1) {
        listOf("__root__", this.first()) // todo: should be changed with correct mangling KT-64970
    } else {
        this
    }
