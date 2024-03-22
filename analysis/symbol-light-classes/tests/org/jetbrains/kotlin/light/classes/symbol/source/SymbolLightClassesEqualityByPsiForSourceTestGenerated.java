/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.light.classes.symbol.source;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/asJava/lightClasses/lightClassByPsi")
@TestDataPath("$PROJECT_ROOT")
public class SymbolLightClassesEqualityByPsiForSourceTestGenerated extends AbstractSymbolLightClassesEqualityByPsiForSourceTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInLightClassByPsi() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByPsi"), Pattern.compile("^(.+)\\.(kt|kts)$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("allowedTargets.kt")
  public void testAllowedTargets() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/allowedTargets.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationInAnnotationParameters.kt")
  public void testAnnotationInAnnotationParameters() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/annotationInAnnotationParameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationWithSetParamPropertyModifier.kt")
  public void testAnnotationWithSetParamPropertyModifier() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/annotationWithSetParamPropertyModifier.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationWithVaragArguments.kt")
  public void testAnnotationWithVaragArguments() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/annotationWithVaragArguments.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotations.kt")
  public void testAnnotations() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/annotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationsOnEnumEntry.kt")
  public void testAnnotationsOnEnumEntry() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/AnnotationsOnEnumEntry.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationsWithUnresolvedAnnotations.kt")
  public void testAnnotationsWithUnresolvedAnnotations() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/AnnotationsWithUnresolvedAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("classModifiers.kt")
  public void testClassModifiers() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/classModifiers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("companionDuplication.kt")
  public void testCompanionDuplication() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/companionDuplication.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("constructors.kt")
  public void testConstructors() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/constructors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("coroutines.kt")
  public void testCoroutines() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/coroutines.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("dataClasses.kt")
  public void testDataClasses() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/dataClasses.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultMethodInKotlinWithSettingAll.kt")
  public void testDefaultMethodInKotlinWithSettingAll() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/defaultMethodInKotlinWithSettingAll.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultMethodInKotlinWithSettingAllCompatibility.kt")
  public void testDefaultMethodInKotlinWithSettingAllCompatibility() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/defaultMethodInKotlinWithSettingAllCompatibility.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultParameterValue.kt")
  public void testDefaultParameterValue() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/defaultParameterValue.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DelegatedProperty.kt")
  public void testDelegatedProperty() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/DelegatedProperty.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegatesWithAnnotations.kt")
  public void testDelegatesWithAnnotations() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/delegatesWithAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegatingToInterfaces.kt")
  public void testDelegatingToInterfaces() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/delegatingToInterfaces.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("deprecatedHiddenProperty_accessors.kt")
  public void testDeprecatedHiddenProperty_accessors() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/deprecatedHiddenProperty_accessors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("deprecatedHiddenProperty_getter.kt")
  public void testDeprecatedHiddenProperty_getter() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/deprecatedHiddenProperty_getter.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("deprecatedHiddenProperty_interface.kt")
  public void testDeprecatedHiddenProperty_interface() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/deprecatedHiddenProperty_interface.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("deprecatedHiddenProperty_noAccessor.kt")
  public void testDeprecatedHiddenProperty_noAccessor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/deprecatedHiddenProperty_noAccessor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("deprecatedHiddenProperty_setter.kt")
  public void testDeprecatedHiddenProperty_setter() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/deprecatedHiddenProperty_setter.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("dollarsInNameLocal.kt")
  public void testDollarsInNameLocal() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/dollarsInNameLocal.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enumMembers.kt")
  public void testEnumMembers() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/enumMembers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enums.kt")
  public void testEnums() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/enums.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("exposedAnonymousType.kt")
  public void testExposedAnonymousType() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/exposedAnonymousType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("fieldModifiers.kt")
  public void testFieldModifiers() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/fieldModifiers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("generics.kt")
  public void testGenerics() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/generics.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("implementingKotlinCollections.kt")
  public void testImplementingKotlinCollections() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/implementingKotlinCollections.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("importAliases.kt")
  public void testImportAliases() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/importAliases.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inferringAnonymousObjectTypes.kt")
  public void testInferringAnonymousObjectTypes() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/inferringAnonymousObjectTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inheritance.kt")
  public void testInheritance() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/inheritance.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inlineClasses.kt")
  public void testInlineClasses() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/inlineClasses.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inlineOnly.kt")
  public void testInlineOnly() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/inlineOnly.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inlineReified.kt")
  public void testInlineReified() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/inlineReified.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmField.kt")
  public void testJvmField() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmField.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmName.kt")
  public void testJvmName() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmName.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmOverloads.kt")
  public void testJvmOverloads() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmOverloads.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmRecord.kt")
  public void testJvmRecord() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmRecord.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmStaticOnPropertySetter.kt")
  public void testJvmStaticOnPropertySetter() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmStaticOnPropertySetter.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmSynthetic.kt")
  public void testJvmSynthetic() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmSynthetic.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmSyntheticForAccessors.kt")
  public void testJvmSyntheticForAccessors() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmSyntheticForAccessors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmWildcardAnnotations.kt")
  public void testJvmWildcardAnnotations() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/jvmWildcardAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("LateinitProperties.kt")
  public void testLateinitProperties() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/LateinitProperties.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("lateinitProperty.kt")
  public void testLateinitProperty() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/lateinitProperty.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("localClassDerived.kt")
  public void testLocalClassDerived() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/localClassDerived.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("objects.kt")
  public void testObjects() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/objects.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("properties.kt")
  public void testProperties() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/properties.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("propertyAnnotations.kt")
  public void testPropertyAnnotations() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/propertyAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simpleFunctions.kt")
  public void testSimpleFunctions() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/simpleFunctions.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("strangeIdentifiers.kt")
  public void testStrangeIdentifiers() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/strangeIdentifiers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("targetAnnotation.kt")
  public void testTargetAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/targetAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("throwsAnnotation.kt")
  public void testThrowsAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/throwsAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typeAliases.kt")
  public void testTypeAliases() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/typeAliases.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typeAnnotations.kt")
  public void testTypeAnnotations() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/typeAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typealiasInAnnotation.kt")
  public void testTypealiasInAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/typealiasInAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typealiasInTypeArguments.kt")
  public void testTypealiasInTypeArguments() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/typealiasInTypeArguments.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("unresolvedGenericSupertypes.kt")
  public void testUnresolvedGenericSupertypes() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/unresolvedGenericSupertypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("unresolvedWithAliasedImport.kt")
  public void testUnresolvedWithAliasedImport() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/unresolvedWithAliasedImport.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("unsafePropertyInitializers.kt")
  public void testUnsafePropertyInitializers() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/unsafePropertyInitializers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("valueClassInSignature.kt")
  public void testValueClassInSignature() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/valueClassInSignature.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargParameterWithIncompletedTypeInAnnotationPrimaryConstructor.kt")
  public void testVarargParameterWithIncompletedTypeInAnnotationPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargParameterWithIncompletedTypeInAnnotationPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargParameterWithIncompletedTypeInPrimaryConstructor.kt")
  public void testVarargParameterWithIncompletedTypeInPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargParameterWithIncompletedTypeInPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargParameterWithoutTypeInAnnotationPrimaryConstructor.kt")
  public void testVarargParameterWithoutTypeInAnnotationPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargParameterWithoutTypeInAnnotationPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargParameterWithoutTypeInPrimaryConstructor.kt")
  public void testVarargParameterWithoutTypeInPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargParameterWithoutTypeInPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargPropertyWithIncompletedTypeInAnnotationPrimaryConstructor.kt")
  public void testVarargPropertyWithIncompletedTypeInAnnotationPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargPropertyWithIncompletedTypeInAnnotationPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargPropertyWithIncompletedTypeInPrimaryConstructor.kt")
  public void testVarargPropertyWithIncompletedTypeInPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargPropertyWithIncompletedTypeInPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargPropertyWithoutTypeInAnnotationPrimaryConstructor.kt")
  public void testVarargPropertyWithoutTypeInAnnotationPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargPropertyWithoutTypeInAnnotationPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargPropertyWithoutTypeInPrimaryConstructor.kt")
  public void testVarargPropertyWithoutTypeInPrimaryConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/varargPropertyWithoutTypeInPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("wildcardOptimization.kt")
  public void testWildcardOptimization() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/wildcardOptimization.kt");
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByPsi/facades")
  @TestDataPath("$PROJECT_ROOT")
  public class Facades {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInFacades() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByPsi/facades"), Pattern.compile("^(.+)\\.(kt|kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("coroutines.kt")
    public void testCoroutines() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/coroutines.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("importAliases.kt")
    public void testImportAliases() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/importAliases.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("inlineOnly.kt")
    public void testInlineOnly() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/inlineOnly.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("jvmField.kt")
    public void testJvmField() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/jvmField.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("jvmName.kt")
    public void testJvmName() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/jvmName.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("jvmWildcardAnnotations.kt")
    public void testJvmWildcardAnnotations() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/jvmWildcardAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("lateinitProperty.kt")
    public void testLateinitProperty() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/lateinitProperty.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("multifileFacade.kt")
    public void testMultifileFacade() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/multifileFacade.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("multifileFacadeJvmName.kt")
    public void testMultifileFacadeJvmName() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/multifileFacadeJvmName.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("properties.kt")
    public void testProperties() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/properties.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("reifiedInlineReturnsObject.kt")
    public void testReifiedInlineReturnsObject() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/reifiedInlineReturnsObject.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simpleFunctions.kt")
    public void testSimpleFunctions() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/simpleFunctions.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("throwsAnnotation.kt")
    public void testThrowsAnnotation() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/throwsAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("valueClassInSignature.kt")
    public void testValueClassInSignature() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/valueClassInSignature.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("varargParameterWithIncompletedType.kt")
    public void testVarargParameterWithIncompletedType() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/varargParameterWithIncompletedType.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("varargParameterWithoutType.kt")
    public void testVarargParameterWithoutType() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/varargParameterWithoutType.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("wildcardOptimization.kt")
    public void testWildcardOptimization() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/facades/wildcardOptimization.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByPsi/scripts")
  @TestDataPath("$PROJECT_ROOT")
  public class Scripts {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInScripts() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByPsi/scripts"), Pattern.compile("^(.+)\\.(kt|kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("FunsPropsAndFields.kts")
    public void testFunsPropsAndFields() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/scripts/FunsPropsAndFields.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("HelloWorld.kts")
    public void testHelloWorld() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/scripts/HelloWorld.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("InnerClasses.kts")
    public void testInnerClasses() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByPsi/scripts/InnerClasses.kts");
    }
  }
}
