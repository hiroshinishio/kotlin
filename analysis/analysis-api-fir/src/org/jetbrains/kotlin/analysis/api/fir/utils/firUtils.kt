/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
package org.jetbrains.kotlin.analysis.api.fir.utils

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.analysis.api.KtConstantInitializerValue
import org.jetbrains.kotlin.analysis.api.KtConstantValueForAnnotation
import org.jetbrains.kotlin.analysis.api.KtInitializerValue
import org.jetbrains.kotlin.analysis.api.KtNonConstantInitializerValue
import org.jetbrains.kotlin.analysis.api.components.KtConstantEvaluationMode
import org.jetbrains.kotlin.analysis.api.fir.KtFirAnalysisSession
import org.jetbrains.kotlin.analysis.api.fir.KtSymbolByFirBuilder
import org.jetbrains.kotlin.analysis.api.fir.evaluate.FirAnnotationValueConverter
import org.jetbrains.kotlin.analysis.api.fir.evaluate.FirCompileTimeConstantEvaluator
import org.jetbrains.kotlin.analysis.api.types.KtTypeNullability
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.analysis.checkers.classKind
import org.jetbrains.kotlin.fir.analysis.checkers.getContainingClassSymbol
import org.jetbrains.kotlin.fir.declarations.FirDeclarationOrigin
import org.jetbrains.kotlin.fir.declarations.FirResolvePhase
import org.jetbrains.kotlin.fir.expressions.FirEqualityOperatorCall
import org.jetbrains.kotlin.fir.expressions.FirExpression
import org.jetbrains.kotlin.fir.expressions.FirOperation
import org.jetbrains.kotlin.fir.expressions.arguments
import org.jetbrains.kotlin.fir.psi
import org.jetbrains.kotlin.fir.resolve.fullyExpandedType
import org.jetbrains.kotlin.fir.resolve.scope
import org.jetbrains.kotlin.fir.scopes.CallableCopyTypeCalculator
import org.jetbrains.kotlin.fir.symbols.impl.FirCallableSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirConstructorSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirNamedFunctionSymbol
import org.jetbrains.kotlin.fir.types.ConeNullability
import org.jetbrains.kotlin.fir.types.coneType
import org.jetbrains.kotlin.fir.types.isNullableAny
import org.jetbrains.kotlin.fir.types.resolvedType
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.util.OperatorNameConventions

internal fun PsiElement.unwrap(): PsiElement {
    return when (this) {
        is KtExpression -> this.unwrap()
        else -> this
    }
}

internal fun KtExpression.unwrap(): KtExpression {
    return when (this) {
        is KtLabeledExpression -> baseExpression?.unwrap()
        is KtAnnotatedExpression -> baseExpression?.unwrap()
        is KtFunctionLiteral -> (parent as? KtLambdaExpression)?.unwrap()
        else -> this
    } ?: this
}

internal fun KtTypeNullability.toConeNullability() = when (this) {
    KtTypeNullability.NULLABLE -> ConeNullability.NULLABLE
    KtTypeNullability.NON_NULLABLE -> ConeNullability.NOT_NULL
    KtTypeNullability.UNKNOWN -> ConeNullability.UNKNOWN
}

/**
 * @receiver A symbol that needs to be imported
 * @param useSiteSession A use-site fir session.
 * @return An [FqName] by which this symbol can be imported (if it is possible)
 */
internal fun FirCallableSymbol<*>.computeImportableName(useSiteSession: FirSession): FqName? {
    if (callableId.isLocal) return null

    // SAM constructors are synthetic, but can be imported
    if (origin is FirDeclarationOrigin.SamConstructor) return callableId.asSingleFqName()

    // if classId == null, callable is topLevel
    val containingClassId = callableId.classId
        ?: return callableId.asSingleFqName()

    if (this is FirConstructorSymbol) return containingClassId.asSingleFqName()

    val containingClass = getContainingClassSymbol(useSiteSession) ?: return null

    // Java static members, enums, and object members can be imported
    val canBeImported = containingClass.origin is FirDeclarationOrigin.Java ||
            containingClass.classKind == ClassKind.ENUM_CLASS ||
            containingClass.classKind == ClassKind.OBJECT

    return if (canBeImported) callableId.asSingleFqName() else null
}

internal fun FirExpression.asKtInitializerValue(builder: KtSymbolByFirBuilder, forAnnotationDefaultValue: Boolean): KtInitializerValue {
    val ktExpression = psi as? KtExpression
    val evaluated = FirCompileTimeConstantEvaluator.evaluateAsKtConstantValue(this, KtConstantEvaluationMode.CONSTANT_EXPRESSION_EVALUATION)

    return when (evaluated) {
        null -> if (forAnnotationDefaultValue) {
            val annotationConstantValue = FirAnnotationValueConverter.toConstantValue(this, builder)
            if (annotationConstantValue != null) {
                KtConstantValueForAnnotation(annotationConstantValue, ktExpression)
            } else {
                KtNonConstantInitializerValue(ktExpression)
            }
        } else {
            KtNonConstantInitializerValue(ktExpression)
        }
        else -> KtConstantInitializerValue(evaluated, ktExpression)
    }
}

internal fun FirEqualityOperatorCall.processEqualsFunctions(
    session: FirSession,
    analysisSession: KtFirAnalysisSession,
    processor: (FirNamedFunctionSymbol) -> Unit,
) {
    when (operation) {
        FirOperation.EQ, FirOperation.NOT_EQ -> {}
        else -> return
    }

    val lhs = arguments.firstOrNull() ?: return
    val scope = lhs.resolvedType.scope(
        session,
        analysisSession.getScopeSessionFor(analysisSession.useSiteSession),
        CallableCopyTypeCalculator.DoNothing,
        requiredMembersPhase = FirResolvePhase.STATUS,
    ) ?: return

    scope.processFunctionsByName(OperatorNameConventions.EQUALS) { functionSymbol ->
        val parameterSymbol = functionSymbol.valueParameterSymbols.singleOrNull()
        if (parameterSymbol != null && parameterSymbol.fir.returnTypeRef.coneType.fullyExpandedType(session).isNullableAny) {
            processor(functionSymbol)
        }
    }
}