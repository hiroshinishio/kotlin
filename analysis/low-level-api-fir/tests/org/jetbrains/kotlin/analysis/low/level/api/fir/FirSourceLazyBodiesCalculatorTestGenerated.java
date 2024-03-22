/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder")
@TestDataPath("$PROJECT_ROOT")
public class FirSourceLazyBodiesCalculatorTestGenerated extends AbstractFirSourceLazyBodiesCalculatorTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInRawBuilder() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
  }

  @Nested
  @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations")
  @TestDataPath("$PROJECT_ROOT")
  public class Declarations {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInDeclarations() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotation.kt")
    public void testAnnotation() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotationOnField.kt")
    public void testAnnotationOnField() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationOnField.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotationOnProperty.kt")
    public void testAnnotationOnProperty() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationOnProperty.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotationOnSuperType.kt")
    public void testAnnotationOnSuperType() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationOnSuperType.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotationOnSuperTypeCall.kt")
    public void testAnnotationOnSuperTypeCall() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationOnSuperTypeCall.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotationsOnNullableParenthesizedTypes.kt")
    public void testAnnotationsOnNullableParenthesizedTypes() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationsOnNullableParenthesizedTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotationsOnParenthesizedTypes.kt")
    public void testAnnotationsOnParenthesizedTypes() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationsOnParenthesizedTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("anonymousObjectWithAnnotation.kt")
    public void testAnonymousObjectWithAnnotation() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/anonymousObjectWithAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classLevelDestructuringWithAnnotation.kt")
    public void testClassLevelDestructuringWithAnnotation() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/classLevelDestructuringWithAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classWithWrongSuperCall.kt")
    public void testClassWithWrongSuperCall() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/classWithWrongSuperCall.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("complexTypes.kt")
    public void testComplexTypes() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/complexTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructorInObject.kt")
    public void testConstructorInObject() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/constructorInObject.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructorOfAnonymousObject.kt")
    public void testConstructorOfAnonymousObject() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/constructorOfAnonymousObject.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructorWithAnnotations.kt")
    public void testConstructorWithAnnotations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/constructorWithAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructorWithLocalDeclarations.kt")
    public void testConstructorWithLocalDeclarations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/constructorWithLocalDeclarations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("contextReceivers.kt")
    public void testContextReceivers() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contextReceivers.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("danglingAnnotationsClassLevel.kt")
    public void testDanglingAnnotationsClassLevel() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/danglingAnnotationsClassLevel.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("danglingAnnotationsFileLevel.kt")
    public void testDanglingAnnotationsFileLevel() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/danglingAnnotationsFileLevel.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("danglingConstrants.kt")
    public void testDanglingConstrants() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/danglingConstrants.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("dataClassWithAnnotations.kt")
    public void testDataClassWithAnnotations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/dataClassWithAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedName.kt")
    public void testDelegatedFieldNestedName() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/delegatedFieldNestedName.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegates.kt")
    public void testDelegates() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/delegates.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatesWithAnnotations.kt")
    public void testDelegatesWithAnnotations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/delegatesWithAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("derivedClass.kt")
    public void testDerivedClass() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/derivedClass.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("emptyAnonymousObject.kt")
    public void testEmptyAnonymousObject() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/emptyAnonymousObject.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("enumEntryWithAnnotations.kt")
    public void testEnumEntryWithAnnotations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/enumEntryWithAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("enums.kt")
    public void testEnums() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/enums.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("enums2.kt")
    public void testEnums2() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/enums2.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("enums3.kt")
    public void testEnums3() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/enums3.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("expectActual.kt")
    public void testExpectActual() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/expectActual.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("expectClassesAndFunctions.kt")
    public void testExpectClassesAndFunctions() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/expectClassesAndFunctions.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("expectNestedAnnotationClassWithConstructorParameter.kt")
    public void testExpectNestedAnnotationClassWithConstructorParameter() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/expectNestedAnnotationClassWithConstructorParameter.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("expectNestedClassMembers.kt")
    public void testExpectNestedClassMembers() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/expectNestedClassMembers.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("expectNestedEnumClassGeneratedMembers.kt")
    public void testExpectNestedEnumClassGeneratedMembers() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/expectNestedEnumClassGeneratedMembers.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("external.kt")
    public void testExternal() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/external.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("F.kt")
    public void testF() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/F.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("fileAnnotations.kt")
    public void testFileAnnotations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/fileAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("fileAnnotationsWithoutPackage.kt")
    public void testFileAnnotationsWithoutPackage() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/fileAnnotationsWithoutPackage.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("functionTypes.kt")
    public void testFunctionTypes() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/functionTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("functionWithAnnotations.kt")
    public void testFunctionWithAnnotations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/functionWithAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("genericFunctions.kt")
    public void testGenericFunctions() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/genericFunctions.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("genericProperty.kt")
    public void testGenericProperty() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/genericProperty.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("incompletePropertyWithDelegate.kt")
    public void testIncompletePropertyWithDelegate() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/incompletePropertyWithDelegate.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("initBlockWithDeclarations.kt")
    public void testInitBlockWithDeclarations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/initBlockWithDeclarations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("initWithLocalDeclarations.kt")
    public void testInitWithLocalDeclarations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/initWithLocalDeclarations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("invalidDestructing.kt")
    public void testInvalidDestructing() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/invalidDestructing.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kotlinAny.kt")
    public void testKotlinAny() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/kotlinAny.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kotlinAnyNonTopLevel.kt")
    public void testKotlinAnyNonTopLevel() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/kotlinAnyNonTopLevel.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localAnnotations.kt")
    public void testLocalAnnotations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/localAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localDeclarationsInEnumEntry.kt")
    public void testLocalDeclarationsInEnumEntry() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/localDeclarationsInEnumEntry.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localImplicitType.kt")
    public void testLocalImplicitType() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/localImplicitType.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("multiDeclarations.kt")
    public void testMultiDeclarations() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/multiDeclarations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("nestedClass.kt")
    public void testNestedClass() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/nestedClass.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("NestedOfAliasedType.kt")
    public void testNestedOfAliasedType() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/NestedOfAliasedType.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("NestedSuperType.kt")
    public void testNestedSuperType() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/NestedSuperType.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("noPrimaryConstructor.kt")
    public void testNoPrimaryConstructor() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noPrimaryConstructor.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("primaryConstructorWithoutConstructorKeyword.kt")
    public void testPrimaryConstructorWithoutConstructorKeyword() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/primaryConstructorWithoutConstructorKeyword.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyWithBackingField.kt")
    public void testPropertyWithBackingField() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/propertyWithBackingField.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyWithBackingFieldDifferentTypes.kt")
    public void testPropertyWithBackingFieldDifferentTypes() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/propertyWithBackingFieldDifferentTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("secondaryConstructor.kt")
    public void testSecondaryConstructor() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/secondaryConstructor.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simpleClass.kt")
    public void testSimpleClass() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/simpleClass.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simpleFun.kt")
    public void testSimpleFun() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/simpleFun.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simpleTypeAlias.kt")
    public void testSimpleTypeAlias() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/simpleTypeAlias.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("splitModifierList.kt")
    public void testSplitModifierList() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/splitModifierList.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("suspendFunctionTypes.kt")
    public void testSuspendFunctionTypes() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/suspendFunctionTypes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("topLevelDestructuringWithAnnotation.kt")
    public void testTopLevelDestructuringWithAnnotation() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/topLevelDestructuringWithAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeAliasWithGeneric.kt")
    public void testTypeAliasWithGeneric() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/typeAliasWithGeneric.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeParameterVsNested.kt")
    public void testTypeParameterVsNested() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/typeParameterVsNested.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeParameters.kt")
    public void testTypeParameters() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/typeParameters.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("userAny.kt")
    public void testUserAny() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/userAny.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("where.kt")
    public void testWhere() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/where.kt");
    }

    @Nested
    @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts")
    @TestDataPath("$PROJECT_ROOT")
    public class Contracts {
      @RepeatedTest(value = 3)
      public void testAllFilesPresentInContracts() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
      }

      @Nested
      @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax")
      @TestDataPath("$PROJECT_ROOT")
      public class NewSyntax {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInNewSyntax() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("functionWithBothOldAndNewSyntaxContractDescription.kt")
        public void testFunctionWithBothOldAndNewSyntaxContractDescription() {
          runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax/functionWithBothOldAndNewSyntaxContractDescription.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("propertyAccessorsContractDescription.kt")
        public void testPropertyAccessorsContractDescription() {
          runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax/propertyAccessorsContractDescription.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("simpleFunctionsContractDescription.kt")
        public void testSimpleFunctionsContractDescription() {
          runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax/simpleFunctionsContractDescription.kt");
        }
      }

      @Nested
      @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/oldSyntax")
      @TestDataPath("$PROJECT_ROOT")
      public class OldSyntax {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInOldSyntax() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/oldSyntax"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("contractDescription.kt")
        public void testContractDescription() {
          runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/oldSyntax/contractDescription.kt");
        }
      }
    }

    @Nested
    @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType")
    @TestDataPath("$PROJECT_ROOT")
    public class NoParameterType {
      @RepeatedTest(value = 3)
      public void testAllFilesPresentInNoParameterType() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInCatch.kt")
      public void testNoParameterTypRefInCatch() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInCatch.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInFuncionalType.kt")
      public void testNoParameterTypRefInFuncionalType() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInFuncionalType.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInFunction.kt")
      public void testNoParameterTypRefInFunction() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInFunction.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInLambda.kt")
      public void testNoParameterTypRefInLambda() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInLambda.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInPrimaryConstructor.kt")
      public void testNoParameterTypRefInPrimaryConstructor() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInPrimaryConstructor.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInPrimaryConstructorWithVararg.kt")
      public void testNoParameterTypRefInPrimaryConstructorWithVararg() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInPrimaryConstructorWithVararg.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInPrimaryConsturctorVal.kt")
      public void testNoParameterTypRefInPrimaryConsturctorVal() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInPrimaryConsturctorVal.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInPrimaryConsturctorValWithVararg.kt")
      public void testNoParameterTypRefInPrimaryConsturctorValWithVararg() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInPrimaryConsturctorValWithVararg.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInSecondaryConstructor.kt")
      public void testNoParameterTypRefInSecondaryConstructor() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInSecondaryConstructor.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("noParameterTypRefInSetter.kt")
      public void testNoParameterTypRefInSetter() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/noParameterTypRefInSetter.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("uncompletedTypRefInPrimaryConstructorWithVararg.kt")
      public void testUncompletedTypRefInPrimaryConstructorWithVararg() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/uncompletedTypRefInPrimaryConstructorWithVararg.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("uncompletedTypRefInPrimaryConsturctorValWithVararg.kt")
      public void testUncompletedTypRefInPrimaryConsturctorValWithVararg() {
        runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noParameterType/uncompletedTypRefInPrimaryConsturctorValWithVararg.kt");
      }
    }
  }

  @Nested
  @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions")
  @TestDataPath("$PROJECT_ROOT")
  public class Expressions {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInExpressions() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotated.kt")
    public void testAnnotated() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/annotated.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("arrayAccess.kt")
    public void testArrayAccess() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/arrayAccess.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("arrayAssignment.kt")
    public void testArrayAssignment() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/arrayAssignment.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("branches.kt")
    public void testBranches() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/branches.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("callableReferences.kt")
    public void testCallableReferences() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/callableReferences.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("calls.kt")
    public void testCalls() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/calls.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("cascadeIf.kt")
    public void testCascadeIf() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/cascadeIf.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classReference.kt")
    public void testClassReference() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/classReference.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("collectionLiterals.kt")
    public void testCollectionLiterals() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/collectionLiterals.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("destructuring.kt")
    public void testDestructuring() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/destructuring.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("for.kt")
    public void testFor() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/for.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("genericCalls.kt")
    public void testGenericCalls() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/genericCalls.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("in.kt")
    public void testIn() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/in.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("inBrackets.kt")
    public void testInBrackets() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/inBrackets.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("init.kt")
    public void testInit() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/init.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("invalidWhen.kt")
    public void testInvalidWhen() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/invalidWhen.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("labelForInfix.kt")
    public void testLabelForInfix() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/labelForInfix.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("lambda.kt")
    public void testLambda() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/lambda.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("lambdaAndAnonymousFunction.kt")
    public void testLambdaAndAnonymousFunction() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/lambdaAndAnonymousFunction.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localDeclarationWithExpression.kt")
    public void testLocalDeclarationWithExpression() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/localDeclarationWithExpression.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("locals.kt")
    public void testLocals() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/locals.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("modifications.kt")
    public void testModifications() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/modifications.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("namedArgument.kt")
    public void testNamedArgument() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/namedArgument.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("nullability.kt")
    public void testNullability() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/nullability.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("qualifierWithTypeArguments.kt")
    public void testQualifierWithTypeArguments() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/qualifierWithTypeArguments.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("safeCallsWithAssignment.kt")
    public void testSafeCallsWithAssignment() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/safeCallsWithAssignment.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("safeCallsWithAugmentedAssignment.kt")
    public void testSafeCallsWithAugmentedAssignment() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/safeCallsWithAugmentedAssignment.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("safeCallsWithUnaryOperators.kt")
    public void testSafeCallsWithUnaryOperators() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/safeCallsWithUnaryOperators.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simpleReturns.kt")
    public void testSimpleReturns() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/simpleReturns.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("super.kt")
    public void testSuper() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/super.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("these.kt")
    public void testThese() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/these.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("try.kt")
    public void testTry() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/try.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeOperators.kt")
    public void testTypeOperators() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/typeOperators.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("unary.kt")
    public void testUnary() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/unary.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("variables.kt")
    public void testVariables() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/variables.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("while.kt")
    public void testWhile() {
      runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/while.kt");
    }
  }
}
