/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:Suppress("DuplicatedCode")

package org.jetbrains.kotlin.fir.expressions.impl

import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.fir.FirImplementationDetail
import org.jetbrains.kotlin.fir.expressions.FirAnnotation
import org.jetbrains.kotlin.fir.expressions.FirArgumentList
import org.jetbrains.kotlin.fir.expressions.FirDelegatedConstructorCall
import org.jetbrains.kotlin.fir.expressions.FirExpression
import org.jetbrains.kotlin.fir.references.FirReference
import org.jetbrains.kotlin.fir.types.FirTypeRef
import org.jetbrains.kotlin.fir.visitors.*

/*
 * This file was generated automatically
 * DO NOT MODIFY IT MANUALLY
 */

class FirLazyDelegatedConstructorCall @FirImplementationDetail constructor(
    override var constructedTypeRef: FirTypeRef,
    override val isThis: Boolean,
) : FirDelegatedConstructorCall() {
    override val source: KtSourceElement? get() = error("FirLazyDelegatedConstructorCall should be calculated before accessing")
    override val annotations: List<FirAnnotation> get() = error("FirLazyDelegatedConstructorCall should be calculated before accessing")
    override val argumentList: FirArgumentList get() = error("FirLazyDelegatedConstructorCall should be calculated before accessing")
    override val contextReceiverArguments: List<FirExpression> get() = error("FirLazyDelegatedConstructorCall should be calculated before accessing")
    override val dispatchReceiver: FirExpression get() = error("FirLazyDelegatedConstructorCall should be calculated before accessing")
    override val calleeReference: FirReference get() = error("FirLazyDelegatedConstructorCall should be calculated before accessing")
    override val isSuper: Boolean get() = !isThis

    override fun <R, D> acceptChildren(visitor: FirVisitor<R, D>, data: D) {
        constructedTypeRef.accept(visitor, data)
    }

    override fun <D> transformChildren(transformer: FirTransformer<D>, data: D): FirLazyDelegatedConstructorCall {
        constructedTypeRef = constructedTypeRef.transform(transformer, data)
        return this
    }

    override fun <D> transformAnnotations(transformer: FirTransformer<D>, data: D): FirLazyDelegatedConstructorCall {
        return this
    }

    override fun <D> transformDispatchReceiver(transformer: FirTransformer<D>, data: D): FirLazyDelegatedConstructorCall {
        return this
    }

    override fun <D> transformCalleeReference(transformer: FirTransformer<D>, data: D): FirLazyDelegatedConstructorCall {
        return this
    }

    override fun replaceArgumentList(newArgumentList: FirArgumentList) {}

    override fun replaceContextReceiverArguments(newContextReceiverArguments: List<FirExpression>) {}

    override fun replaceConstructedTypeRef(newConstructedTypeRef: FirTypeRef) {
        constructedTypeRef = newConstructedTypeRef
    }

    override fun replaceCalleeReference(newCalleeReference: FirReference) {}
}
