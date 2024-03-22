/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.light.classes.symbol.decompiled;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/asJava/lightClasses/lightClassByFqName")
@TestDataPath("$PROJECT_ROOT")
public class SymbolLightClassesByFqNameForLibraryTestGenerated extends AbstractSymbolLightClassesByFqNameForLibraryTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInLightClassByFqName() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByFqName"), Pattern.compile("^([^.]+)\\.kt$"), null, true, "compilationErrors");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotatedParameterInEnumConstructor.kt")
  public void testAnnotatedParameterInEnumConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotatedParameterInEnumConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotatedParameterInInnerClassConstructor.kt")
  public void testAnnotatedParameterInInnerClassConstructor() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotatedParameterInInnerClassConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotatedPropertyWithSites.kt")
  public void testAnnotatedPropertyWithSites() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotatedPropertyWithSites.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationBinaryRetention.kt")
  public void testAnnotationBinaryRetention() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/annotationBinaryRetention.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationClass.kt")
  public void testAnnotationClass() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotationClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationJavaRepeatable.kt")
  public void testAnnotationJavaRepeatable() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotationJavaRepeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationJvmRepeatable.kt")
  public void testAnnotationJvmRepeatable() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotationJvmRepeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationKotlinAndJavaRepeatable.kt")
  public void testAnnotationKotlinAndJavaRepeatable() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotationKotlinAndJavaRepeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationKotlinAndJvmRepeatable.kt")
  public void testAnnotationKotlinAndJvmRepeatable() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotationKotlinAndJvmRepeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationRepeatable.kt")
  public void testAnnotationRepeatable() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/AnnotationRepeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("BackingFields.kt")
  public void testBackingFields() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/BackingFields.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ClassTypeParameterAnnotation.kt")
  public void testClassTypeParameterAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ClassTypeParameterAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("CompanionObject.kt")
  public void testCompanionObject() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/CompanionObject.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Constructors.kt")
  public void testConstructors() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/Constructors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DataClassWithCustomImplementedMembers.kt")
  public void testDataClassWithCustomImplementedMembers() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/DataClassWithCustomImplementedMembers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DefaultImplsWithTypeParameters.kt")
  public void testDefaultImplsWithTypeParameters() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/DefaultImplsWithTypeParameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DelegatedNested.kt")
  public void testDelegatedNested() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/DelegatedNested.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Delegation.kt")
  public void testDelegation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/Delegation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DeprecatedEnumEntry.kt")
  public void testDeprecatedEnumEntry() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/DeprecatedEnumEntry.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DeprecatedNotHiddenInClass.kt")
  public void testDeprecatedNotHiddenInClass() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/DeprecatedNotHiddenInClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DollarsInName.kt")
  public void testDollarsInName() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/DollarsInName.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DollarsInNameNoPackage.kt")
  public void testDollarsInNameNoPackage() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/DollarsInNameNoPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("EnumClass.kt")
  public void testEnumClass() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/EnumClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("EnumClassWithEnumEntries.kt")
  public void testEnumClassWithEnumEntries() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/EnumClassWithEnumEntries.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("EnumEntry.kt")
  public void testEnumEntry() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/EnumEntry.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ExtendingInterfaceWithDefaultImpls.kt")
  public void testExtendingInterfaceWithDefaultImpls() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ExtendingInterfaceWithDefaultImpls.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("HiddenDeprecated.kt")
  public void testHiddenDeprecated() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/HiddenDeprecated.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("HiddenDeprecatedInClass.kt")
  public void testHiddenDeprecatedInClass() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/HiddenDeprecatedInClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InheritingInterfaceDefaultImpls.kt")
  public void testInheritingInterfaceDefaultImpls() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/InheritingInterfaceDefaultImpls.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InlineReified.kt")
  public void testInlineReified() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/InlineReified.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InterfaceTypeParameterAnnotation.kt")
  public void testInterfaceTypeParameterAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/InterfaceTypeParameterAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InvalidJavaIdentifierAsAnnotationArgument.kt")
  public void testInvalidJavaIdentifierAsAnnotationArgument() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/InvalidJavaIdentifierAsAnnotationArgument.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InvalidJavaIdentifierAsPropertyInitializer.kt")
  public void testInvalidJavaIdentifierAsPropertyInitializer() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/InvalidJavaIdentifierAsPropertyInitializer.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("JavaBetween.kt")
  public void testJavaBetween() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/JavaBetween.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("JavaClassWithAnnotation.kt")
  public void testJavaClassWithAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/JavaClassWithAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("JvmNameOnMember.kt")
  public void testJvmNameOnMember() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/JvmNameOnMember.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("JvmStatic.kt")
  public void testJvmStatic() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/JvmStatic.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("LocalFunctions.kt")
  public void testLocalFunctions() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/LocalFunctions.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("MethodTypeParameterAnnotation.kt")
  public void testMethodTypeParameterAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/MethodTypeParameterAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("NestedObjects.kt")
  public void testNestedObjects() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/NestedObjects.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("NestedTypeAnnotations.kt")
  public void testNestedTypeAnnotations() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/NestedTypeAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("NonDataClassWithComponentFunctions.kt")
  public void testNonDataClassWithComponentFunctions() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/NonDataClassWithComponentFunctions.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("OnlySecondaryConstructors.kt")
  public void testOnlySecondaryConstructors() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/OnlySecondaryConstructors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("PrivateObject.kt")
  public void testPrivateObject() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/PrivateObject.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("PropertyTypeParameterAnnotation.kt")
  public void testPropertyTypeParameterAnnotation() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/PropertyTypeParameterAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("PublishedApi.kt")
  public void testPublishedApi() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/PublishedApi.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SimpleObject.kt")
  public void testSimpleObject() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/SimpleObject.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SimplePublicField.kt")
  public void testSimplePublicField() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/SimplePublicField.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SpecialAnnotationsOnAnnotationClass.kt")
  public void testSpecialAnnotationsOnAnnotationClass() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/SpecialAnnotationsOnAnnotationClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("StubOrderForOverloads.kt")
  public void testStubOrderForOverloads() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/StubOrderForOverloads.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SubstitutionOverride.kt")
  public void testSubstitutionOverride() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/SubstitutionOverride.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Throws.kt")
  public void testThrows() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/Throws.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TypePararametersInClass.kt")
  public void testTypePararametersInClass() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/TypePararametersInClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("UnitAsTypeAlias.kt")
  public void testUnitAsTypeAlias() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/UnitAsTypeAlias.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ValueClassInParametersWithJvmName.kt")
  public void testValueClassInParametersWithJvmName() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ValueClassInParametersWithJvmName.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("VarArgs.kt")
  public void testVarArgs() {
    runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/VarArgs.kt");
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByFqName/delegation")
  @TestDataPath("$PROJECT_ROOT")
  public class Delegation {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInDelegation() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByFqName/delegation"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("Function.kt")
    public void testFunction() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/delegation/Function.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("Property.kt")
    public void testProperty() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/delegation/Property.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("WithImplicitType.kt")
    public void testWithImplicitType() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/delegation/WithImplicitType.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByFqName/facades")
  @TestDataPath("$PROJECT_ROOT")
  public class Facades {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInFacades() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByFqName/facades"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("AllPrivate.kt")
    public void testAllPrivate() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/AllPrivate.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("FunctionTypeParameterAnnotation.kt")
    public void testFunctionTypeParameterAnnotation() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/FunctionTypeParameterAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("InternalFacadeClass.kt")
    public void testInternalFacadeClass() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/InternalFacadeClass.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("MultiFile.kt")
    public void testMultiFile() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/MultiFile.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("PropertyTypeParameterAnnotation.kt")
    public void testPropertyTypeParameterAnnotation() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/PropertyTypeParameterAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("SingleFile.kt")
    public void testSingleFile() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/SingleFile.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("SingleJvmClassName.kt")
    public void testSingleJvmClassName() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/SingleJvmClassName.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ValueClassInParametersWithJvmName.kt")
    public void testValueClassInParametersWithJvmName() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/facades/ValueClassInParametersWithJvmName.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression")
  @TestDataPath("$PROJECT_ROOT")
  public class IdeRegression {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInIdeRegression() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("AllOpenAnnotatedClasses.kt")
    public void testAllOpenAnnotatedClasses() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/AllOpenAnnotatedClasses.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ImplementingCharSequenceAndNumber.kt")
    public void testImplementingCharSequenceAndNumber() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/ImplementingCharSequenceAndNumber.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ImplementingMap.kt")
    public void testImplementingMap() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/ImplementingMap.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ImplementingMutableSet.kt")
    public void testImplementingMutableSet() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/ImplementingMutableSet.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("InheritingInterfaceDefaultImpls.kt")
    public void testInheritingInterfaceDefaultImpls() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/InheritingInterfaceDefaultImpls.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("OverridingFinalInternal.kt")
    public void testOverridingFinalInternal() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/OverridingFinalInternal.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("OverridingInternal.kt")
    public void testOverridingInternal() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/OverridingInternal.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("OverridingProtected.kt")
    public void testOverridingProtected() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/ideRegression/OverridingProtected.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations")
  @TestDataPath("$PROJECT_ROOT")
  public class NullabilityAnnotations {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInNullabilityAnnotations() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("Class.kt")
    public void testClass() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/Class.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ClassObjectField.kt")
    public void testClassObjectField() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/ClassObjectField.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ClassWithConstructor.kt")
    public void testClassWithConstructor() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/ClassWithConstructor.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ClassWithConstructorAndProperties.kt")
    public void testClassWithConstructorAndProperties() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/ClassWithConstructorAndProperties.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("FileFacade.kt")
    public void testFileFacade() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/FileFacade.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("Generic.kt")
    public void testGeneric() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/Generic.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("ImplicitArrayWithFlexibleParameterTypes.kt")
    public void testImplicitArrayWithFlexibleParameterTypes() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/ImplicitArrayWithFlexibleParameterTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("IntOverridesAny.kt")
    public void testIntOverridesAny() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/IntOverridesAny.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("JvmOverloads.kt")
    public void testJvmOverloads() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/JvmOverloads.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("NullableUnitReturn.kt")
    public void testNullableUnitReturn() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/NullableUnitReturn.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("OverrideAnyWithUnit.kt")
    public void testOverrideAnyWithUnit() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/OverrideAnyWithUnit.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("PlatformTypes.kt")
    public void testPlatformTypes() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/PlatformTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("PrimitiveBackedInlineClasses.kt")
    public void testPrimitiveBackedInlineClasses() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/PrimitiveBackedInlineClasses.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("Primitives.kt")
    public void testPrimitives() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/Primitives.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("PrivateInClass.kt")
    public void testPrivateInClass() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/PrivateInClass.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("Synthetic.kt")
    public void testSynthetic() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/Synthetic.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("Trait.kt")
    public void testTrait() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/Trait.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeAlias.kt")
    public void testTypeAlias() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/typeAlias.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("UnitAsGenericArgument.kt")
    public void testUnitAsGenericArgument() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/UnitAsGenericArgument.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("UnitParameter.kt")
    public void testUnitParameter() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/UnitParameter.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("VoidReturn.kt")
    public void testVoidReturn() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/nullabilityAnnotations/VoidReturn.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByFqName/script")
  @TestDataPath("$PROJECT_ROOT")
  public class Script {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInScript() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByFqName/script"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
    }
  }

  @Nested
  @TestMetadata("compiler/testData/asJava/lightClasses/lightClassByFqName/withTestCompilerPluginEnabled")
  @TestDataPath("$PROJECT_ROOT")
  public class WithTestCompilerPluginEnabled {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInWithTestCompilerPluginEnabled() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClassByFqName/withTestCompilerPluginEnabled"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("allOpen.kt")
    public void testAllOpen() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/withTestCompilerPluginEnabled/allOpen.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("companionWithFoo_companionTypeUsedInJava_ReferenceFromKotlin.kt")
    public void testCompanionWithFoo_companionTypeUsedInJava_ReferenceFromKotlin() {
      runTest("compiler/testData/asJava/lightClasses/lightClassByFqName/withTestCompilerPluginEnabled/companionWithFoo_companionTypeUsedInJava_ReferenceFromKotlin.kt");
    }
  }
}
