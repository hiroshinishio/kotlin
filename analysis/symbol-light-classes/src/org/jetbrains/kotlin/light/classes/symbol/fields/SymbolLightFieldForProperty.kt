/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.light.classes.symbol.fields

import com.intellij.psi.*
import kotlinx.collections.immutable.persistentHashMapOf
import org.jetbrains.kotlin.analysis.api.KaConstantInitializerValue
import org.jetbrains.kotlin.analysis.api.KaSession
import org.jetbrains.kotlin.analysis.api.annotations.*
import org.jetbrains.kotlin.analysis.api.base.KaConstantValue
import org.jetbrains.kotlin.analysis.api.symbols.KaBackingFieldSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaKotlinPropertySymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaPropertySymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaSymbolVisibility
import org.jetbrains.kotlin.analysis.api.symbols.pointers.KaSymbolPointer
import org.jetbrains.kotlin.analysis.api.symbols.sourcePsiSafe
import org.jetbrains.kotlin.analysis.api.types.KaTypeMappingMode
import org.jetbrains.kotlin.analysis.api.types.KaTypeNullability
import org.jetbrains.kotlin.asJava.builder.LightMemberOrigin
import org.jetbrains.kotlin.asJava.classes.lazyPub
import org.jetbrains.kotlin.light.classes.symbol.*
import org.jetbrains.kotlin.light.classes.symbol.annotations.*
import org.jetbrains.kotlin.light.classes.symbol.classes.SymbolLightClassBase
import org.jetbrains.kotlin.light.classes.symbol.modifierLists.GranularModifiersBox
import org.jetbrains.kotlin.light.classes.symbol.modifierLists.SymbolLightMemberModifierList
import org.jetbrains.kotlin.light.classes.symbol.modifierLists.with
import org.jetbrains.kotlin.load.java.structure.impl.NotEvaluatedConstAware
import org.jetbrains.kotlin.name.JvmStandardClassIds.TRANSIENT_ANNOTATION_CLASS_ID
import org.jetbrains.kotlin.name.JvmStandardClassIds.VOLATILE_ANNOTATION_CLASS_ID
import org.jetbrains.kotlin.psi.KtCallableDeclaration
import org.jetbrains.kotlin.psi.KtParameter
import org.jetbrains.kotlin.psi.KtProperty

internal class SymbolLightFieldForProperty private constructor(
    private val propertySymbolPointer: KaSymbolPointer<KaPropertySymbol>,
    private val fieldName: String,
    containingClass: SymbolLightClassBase,
    lightMemberOrigin: LightMemberOrigin?,
    private val isStatic: Boolean,
    override val kotlinOrigin: KtCallableDeclaration?,
    private val backingFieldSymbolPointer: KaSymbolPointer<KaBackingFieldSymbol>?,
) : SymbolLightField(containingClass, lightMemberOrigin), NotEvaluatedConstAware {
    internal constructor(
        ktAnalysisSession: KaSession,
        propertySymbol: KaPropertySymbol,
        fieldName: String,
        containingClass: SymbolLightClassBase,
        lightMemberOrigin: LightMemberOrigin?,
        isStatic: Boolean,
    ) : this(
        propertySymbolPointer = with(ktAnalysisSession) { propertySymbol.createPointer() },
        fieldName = fieldName,
        containingClass = containingClass,
        lightMemberOrigin = lightMemberOrigin,
        isStatic = isStatic,
        kotlinOrigin = propertySymbol.sourcePsiSafe<KtCallableDeclaration>(),
        backingFieldSymbolPointer = with(ktAnalysisSession) { propertySymbol.backingFieldSymbol?.createPointer() },
    )

    @Suppress("CONTEXT_RECEIVERS_DEPRECATED")
    private inline fun <T> withPropertySymbol(crossinline action: context(KaSession) (KaPropertySymbol) -> T): T {
        return propertySymbolPointer.withSymbol(ktModule, action)
    }

    private val _returnedType: PsiType by lazyPub {
        withPropertySymbol { propertySymbol ->
            val isDelegated = (propertySymbol as? KaKotlinPropertySymbol)?.isDelegatedProperty == true
            val ktType = if (isDelegated)
                (kotlinOrigin as? KtProperty)?.delegateExpression?.expressionType
            else
                propertySymbol.returnType
            // See [KotlinTypeMapper#writeFieldSignature]
            val typeMappingMode = if (propertySymbol.isVal)
                KaTypeMappingMode.RETURN_TYPE
            else
                KaTypeMappingMode.VALUE_PARAMETER
            ktType?.asPsiType(
                this@SymbolLightFieldForProperty,
                allowErrorTypes = true,
                typeMappingMode,
                suppressWildcards = propertySymbol.suppressWildcardMode(),
            )
        } ?: nonExistentType()
    }

    private val _isDeprecated: Boolean by lazyPub {
        withPropertySymbol { propertySymbol ->
            propertySymbol.hasDeprecatedAnnotation() || propertySymbol.backingFieldSymbol?.hasDeprecatedAnnotation() == true
        }
    }

    override fun isEquivalentTo(another: PsiElement?): Boolean {
        return super.isEquivalentTo(another) ||
                basicIsEquivalentTo(this, another as? PsiMethod) ||
                isOriginEquivalentTo(another)
    }

    override fun isDeprecated(): Boolean = _isDeprecated

    override fun getType(): PsiType = _returnedType

    override fun getName(): String = fieldName

    private fun computeModifiers(modifier: String): Map<String, Boolean>? = when (modifier) {
        in GranularModifiersBox.VISIBILITY_MODIFIERS -> {
            val visibility = withPropertySymbol { propertySymbol ->
                when {
                    propertySymbol.visibility == KaSymbolVisibility.PRIVATE -> PsiModifier.PRIVATE
                    propertySymbol.canHaveNonPrivateField -> {
                        val declaration = propertySymbol.setter ?: propertySymbol
                        declaration.toPsiVisibilityForMember()
                    }
                    else -> PsiModifier.PRIVATE
                }
            }

            GranularModifiersBox.VISIBILITY_MODIFIERS_MAP.with(visibility)
        }
        in GranularModifiersBox.MODALITY_MODIFIERS -> {
            val modality = withPropertySymbol { propertySymbol ->
                if (propertySymbol.isVal || propertySymbol.isDelegatedProperty) {
                    PsiModifier.FINAL
                } else {
                    propertySymbol.computeSimpleModality()?.takeIf { it != PsiModifier.FINAL }
                }
            }

            GranularModifiersBox.MODALITY_MODIFIERS_MAP.with(modality)
        }

        PsiModifier.VOLATILE -> withPropertySymbol { propertySymbol ->
            val hasAnnotation = propertySymbol.backingFieldSymbol?.annotations?.contains(
                VOLATILE_ANNOTATION_CLASS_ID,
            ) == true

            mapOf(modifier to hasAnnotation)
        }

        PsiModifier.TRANSIENT -> withPropertySymbol { propertySymbol ->
            val hasAnnotation = propertySymbol.backingFieldSymbol?.annotations?.contains(
                TRANSIENT_ANNOTATION_CLASS_ID,
            ) == true

            mapOf(modifier to hasAnnotation)
        }

        else -> null
    }

    private val _modifierList: PsiModifierList by lazyPub {
        SymbolLightMemberModifierList(
            containingDeclaration = this,
            modifiersBox = GranularModifiersBox(
                initialValue = persistentHashMapOf(PsiModifier.STATIC to isStatic),
                computer = ::computeModifiers,
            ),
            annotationsBox = GranularAnnotationsBox(
                annotationsProvider = (backingFieldSymbolPointer)?.let { pointer ->
                    SymbolAnnotationsProvider(ktModule = ktModule, annotatedSymbolPointer = pointer)
                } ?: EmptyAnnotationsProvider,
                additionalAnnotationsProvider = NullabilityAnnotationsProvider {
                    withPropertySymbol { propertySymbol ->
                        when {
                            propertySymbol.isDelegatedProperty -> KaTypeNullability.NON_NULLABLE
                            !(propertySymbol is KaKotlinPropertySymbol && propertySymbol.isLateInit) -> getTypeNullability(propertySymbol.returnType)
                            else -> KaTypeNullability.UNKNOWN
                        }
                    }
                }
            ),
        )
    }

    override fun getModifierList(): PsiModifierList = _modifierList

    private val _initializerValue: KaConstantValue? by lazyPub {
        withPropertySymbol { propertySymbol ->
            if (propertySymbol !is KaKotlinPropertySymbol) return@withPropertySymbol null
            (propertySymbol.initializer as? KaConstantInitializerValue)?.constant
        }
    }

    private val _initializer by lazyPub {
        _initializerValue?.createPsiExpression(this) ?: withPropertySymbol { propertySymbol ->
            if (propertySymbol !is KaKotlinPropertySymbol) return@withPropertySymbol null
            val initializerExpression = when (kotlinOrigin) {
                is KtProperty -> kotlinOrigin.initializer
                is KtParameter -> kotlinOrigin.defaultValue
                else -> null
            }
            initializerExpression?.evaluateAsAnnotationValue()?.let(::toPsiExpression)
        }
    }

    private fun toPsiExpression(value: KaAnnotationValue): PsiExpression? =
        project.withElementFactorySafe {
            when (value) {
                is KaAnnotationValue.ConstantValue ->
                    value.value.createPsiExpression(this@SymbolLightFieldForProperty)
                is KaAnnotationValue.EnumEntryValue ->
                    value.callableId?.let { createExpressionFromText(it.asSingleFqName().asString(), this@SymbolLightFieldForProperty) }
                is KaAnnotationValue.ArrayValue ->
                    createExpressionFromText(
                        value.values
                            .map { toPsiExpression(it)?.text ?: return@withElementFactorySafe null }
                            .joinToString(", ", "{", "}"),
                        this@SymbolLightFieldForProperty
                    )
                else -> null
            }
        }

    override fun getInitializer(): PsiExpression? = _initializer

    private val _constantValue by lazyPub {
        _initializerValue?.value?.takeIf {
            withPropertySymbol { propertySymbol ->
                // val => final
                propertySymbol.isVal &&
                        // NB: not as?, since _initializerValue already checks that
                        (propertySymbol as KaKotlinPropertySymbol).isConst &&
                        // javac rejects all non-primitive and non String constants
                        (propertySymbol.returnType.isPrimitiveBacked || propertySymbol.returnType.isStringType)
            }
        }
    }

    override fun computeConstantValue(): Any? = _constantValue

    override fun isNotYetComputed(): Boolean {
        return withPropertySymbol { propertySymbol -> (propertySymbol as? KaKotlinPropertySymbol)?.isConst == true }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SymbolLightFieldForProperty || other.ktModule != ktModule || other.fieldName != fieldName) return false
        if (kotlinOrigin != null || other.kotlinOrigin != null) {
            return kotlinOrigin == other.kotlinOrigin
        }

        return containingClass == other.containingClass &&
                compareSymbolPointers(propertySymbolPointer, other.propertySymbolPointer)
    }

    override fun hashCode(): Int = kotlinOrigin?.hashCode() ?: fieldName.hashCode()

    override fun isValid(): Boolean = super.isValid() && kotlinOrigin?.isValid ?: propertySymbolPointer.isValid(ktModule)
}
