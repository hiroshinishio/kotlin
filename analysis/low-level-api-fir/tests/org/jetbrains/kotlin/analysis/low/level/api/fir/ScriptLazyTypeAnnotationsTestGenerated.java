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
@TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations")
@TestDataPath("$PROJECT_ROOT")
public class ScriptLazyTypeAnnotationsTestGenerated extends AbstractScriptLazyTypeAnnotationsTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInLazyResolveTypeAnnotations() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class")
  @TestDataPath("$PROJECT_ROOT")
  public class Class {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInClass() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classAnnotationsInLocalClassScript.kts")
    public void testClassAnnotationsInLocalClassScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/classAnnotationsInLocalClassScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegateFieldWithAnnotationClashScript.kts")
    public void testDelegateFieldWithAnnotationClashScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/delegateFieldWithAnnotationClashScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedNameClashAndAnnotationsScript.kts")
    public void testDelegatedFieldNestedNameClashAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/delegatedFieldNestedNameClashAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedNameClashWithNestedTypesAndAnnotationsScript.kts")
    public void testDelegatedFieldNestedNameClashWithNestedTypesAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/delegatedFieldNestedNameClashWithNestedTypesAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("parameterTypeCollisionAndAnnotationsScript.kts")
    public void testParameterTypeCollisionAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/parameterTypeCollisionAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNameClashWithAnnotationImplicitConstructorScript.kts")
    public void testSuperTypeCallNameClashWithAnnotationImplicitConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/superTypeCallNameClashWithAnnotationImplicitConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNameClashWithAnnotationScript.kts")
    public void testSuperTypeCallNameClashWithAnnotationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/superTypeCallNameClashWithAnnotationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNestedNameClashWithAnnotationImplicitConstructorScript.kts")
    public void testSuperTypeCallNestedNameClashWithAnnotationImplicitConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/superTypeCallNestedNameClashWithAnnotationImplicitConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNestedNameClashWithAnnotationScript.kts")
    public void testSuperTypeCallNestedNameClashWithAnnotationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/class/superTypeCallNestedNameClashWithAnnotationScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor")
  @TestDataPath("$PROJECT_ROOT")
  public class Constructor {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInConstructor() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("callScript.kts")
    public void testCallScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/callScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("callWithConstructorScript.kts")
    public void testCallWithConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/callWithConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("parameterWithAnnotationsScript.kts")
    public void testParameterWithAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/parameterWithAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("parameterWithAnnotationsScriptBodyResolve.kts")
    public void testParameterWithAnnotationsScriptBodyResolve() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/parameterWithAnnotationsScriptBodyResolve.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationToLocalMemberFunctionScript.kts")
    public void testPropagationToLocalMemberFunctionScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/propagationToLocalMemberFunctionScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("referenceScript.kts")
    public void testReferenceScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/referenceScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("referenceWithConstructorScript.kts")
    public void testReferenceWithConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/referenceWithConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("secondaryConstructorScript.kts")
    public void testSecondaryConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/constructor/secondaryConstructorScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate")
  @TestDataPath("$PROJECT_ROOT")
  public class Delegate {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInDelegate() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegateFieldWithAnnotationClashScript.kts")
    public void testDelegateFieldWithAnnotationClashScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegateFieldWithAnnotationClashScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegateWithExplicitTypeScript.kts")
    public void testDelegateWithExplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegateWithExplicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegateWithExplicitTypeUnavailableScript.kts")
    public void testDelegateWithExplicitTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegateWithExplicitTypeUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegateWithImplicitTypeScript.kts")
    public void testDelegateWithImplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegateWithImplicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegateWithImplicitTypeUnavailableScript.kts")
    public void testDelegateWithImplicitTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegateWithImplicitTypeUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedNameClashAndAnnotationsScript.kts")
    public void testDelegatedFieldNestedNameClashAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegatedFieldNestedNameClashAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedNameClashWithNestedTypesAndAnnotationsScript.kts")
    public void testDelegatedFieldNestedNameClashWithNestedTypesAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegatedFieldNestedNameClashWithNestedTypesAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedNameScript.kts")
    public void testDelegatedFieldNestedNameScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/delegatedFieldNestedNameScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("fieldScript.kts")
    public void testFieldScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/fieldScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyWithExplicitTypeScript.kts")
    public void testPropertyWithExplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/propertyWithExplicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyWithExplicitTypeUnavailableScript.kts")
    public void testPropertyWithExplicitTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/propertyWithExplicitTypeUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyWithImplicitTypeScript.kts")
    public void testPropertyWithImplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/propertyWithImplicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyWithImplicitTypeUnavailableScript.kts")
    public void testPropertyWithImplicitTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/delegate/propertyWithImplicitTypeUnavailableScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration")
  @TestDataPath("$PROJECT_ROOT")
  public class DestructuringDeclaration {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInDestructuringDeclaration() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("destruct.kts")
    public void testDestruct() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/destruct.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("destructEntry.kts")
    public void testDestructEntry() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/destructEntry.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("destructEntryUsage.kts")
    public void testDestructEntryUsage() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/destructEntryUsage.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("destructEntryWithType.kts")
    public void testDestructEntryWithType() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/destructEntryWithType.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("destructEntryWithTypeUsage.kts")
    public void testDestructEntryWithTypeUsage() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/destructEntryWithTypeUsage.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("scriptClassLevel.kts")
    public void testScriptClassLevel() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/scriptClassLevel.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("scriptLevel.kts")
    public void testScriptLevel() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/scriptLevel.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("scriptStatementLevel.kts")
    public void testScriptStatementLevel() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/scriptStatementLevel.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("scriptStatementLevelAsLastStatement.kts")
    public void testScriptStatementLevelAsLastStatement() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/destructuringDeclaration/scriptStatementLevelAsLastStatement.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/errorType")
  @TestDataPath("$PROJECT_ROOT")
  public class ErrorType {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInErrorType() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/errorType"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("errorTypeScript.kts")
    public void testErrorTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/errorType/errorTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("nestedErrorReturnTypeScript.kts")
    public void testNestedErrorReturnTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/errorType/nestedErrorReturnTypeScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function")
  @TestDataPath("$PROJECT_ROOT")
  public class Function {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInFunction() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("component1TypeCollisionAndAnnotationsScript.kts")
    public void testComponent1TypeCollisionAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/component1TypeCollisionAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("copyTypeCollisionAndAnnotationsScript.kts")
    public void testCopyTypeCollisionAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/copyTypeCollisionAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedNameClashAndAnnotationsAsConstructorScript.kts")
    public void testDelegatedFieldNestedNameClashAndAnnotationsAsConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/delegatedFieldNestedNameClashAndAnnotationsAsConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedFieldNestedNameClashWithNestedTypesAndAnnotationsAsConstructorScript.kts")
    public void testDelegatedFieldNestedNameClashWithNestedTypesAndAnnotationsAsConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/delegatedFieldNestedNameClashWithNestedTypesAndAnnotationsAsConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("explicitTypeScript.kts")
    public void testExplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/explicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("generatedComponentNScript.kts")
    public void testGeneratedComponentNScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/generatedComponentNScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("generatedCopyScript.kts")
    public void testGeneratedCopyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/generatedCopyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitTypeScript.kts")
    public void testImplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/implicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitTypeUnavailableScript.kts")
    public void testImplicitTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/implicitTypeUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localImplicitTypeUnavailableInImplicitBodyScript.kts")
    public void testLocalImplicitTypeUnavailableInImplicitBodyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/localImplicitTypeUnavailableInImplicitBodyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localImplicitTypeUnavailableScript.kts")
    public void testLocalImplicitTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/localImplicitTypeUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("multiDeclarationScript.kts")
    public void testMultiDeclarationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/multiDeclarationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("parameterAsImplicitReturnTypePropagationScript.kts")
    public void testParameterAsImplicitReturnTypePropagationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/parameterAsImplicitReturnTypePropagationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("parameterAsImplicitReturnTypeScript.kts")
    public void testParameterAsImplicitReturnTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/parameterAsImplicitReturnTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("parameterAsImplicitReturnTypeScriptBodyResolve.kts")
    public void testParameterAsImplicitReturnTypeScriptBodyResolve() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/parameterAsImplicitReturnTypeScriptBodyResolve.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationBetweenLocalMemberFunctionsImplicitBodyScript.kts")
    public void testPropagationBetweenLocalMemberFunctionsImplicitBodyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/propagationBetweenLocalMemberFunctionsImplicitBodyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationBetweenLocalMemberFunctionsScript.kts")
    public void testPropagationBetweenLocalMemberFunctionsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/propagationBetweenLocalMemberFunctionsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationToLocalMemberFunctionImplicitBodyScript.kts")
    public void testPropagationToLocalMemberFunctionImplicitBodyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/propagationToLocalMemberFunctionImplicitBodyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationToLocalMemberFunctionScript.kts")
    public void testPropagationToLocalMemberFunctionScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/propagationToLocalMemberFunctionScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("receiverAsImplicitReturnTypePropagationScript.kts")
    public void testReceiverAsImplicitReturnTypePropagationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/receiverAsImplicitReturnTypePropagationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("receiverAsImplicitReturnTypeScript.kts")
    public void testReceiverAsImplicitReturnTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/receiverAsImplicitReturnTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNameClashWithAnnotationImplicitConstructorScript.kts")
    public void testSuperTypeCallNameClashWithAnnotationImplicitConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/superTypeCallNameClashWithAnnotationImplicitConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNameClashWithAnnotationScript.kts")
    public void testSuperTypeCallNameClashWithAnnotationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/superTypeCallNameClashWithAnnotationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNestedNameClashWithAnnotationImplicitConstructorScript.kts")
    public void testSuperTypeCallNestedNameClashWithAnnotationImplicitConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/superTypeCallNestedNameClashWithAnnotationImplicitConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("superTypeCallNestedNameClashWithAnnotationScript.kts")
    public void testSuperTypeCallNestedNameClashWithAnnotationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/superTypeCallNestedNameClashWithAnnotationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeParameterAnnotationsInLocalClassScript.kts")
    public void testTypeParameterAnnotationsInLocalClassScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/function/typeParameterAnnotationsInLocalClassScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/initializer")
  @TestDataPath("$PROJECT_ROOT")
  public class Initializer {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInInitializer() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/initializer"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classInitializerScript.kts")
    public void testClassInitializerScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/initializer/classInitializerScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property")
  @TestDataPath("$PROJECT_ROOT")
  public class Property {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInProperty() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructorParameterScript.kts")
    public void testConstructorParameterScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/constructorParameterScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("explicitTypeScript.kts")
    public void testExplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/explicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("generatedPropertyFromConstructorScript.kts")
    public void testGeneratedPropertyFromConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/generatedPropertyFromConstructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitTypeFromIncorrectAccessorsPropagationScript.kts")
    public void testImplicitTypeFromIncorrectAccessorsPropagationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/implicitTypeFromIncorrectAccessorsPropagationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitTypeFromIncorrectAccessorsScript.kts")
    public void testImplicitTypeFromIncorrectAccessorsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/implicitTypeFromIncorrectAccessorsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitTypeFromIncorrectSetterPropagationScript.kts")
    public void testImplicitTypeFromIncorrectSetterPropagationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/implicitTypeFromIncorrectSetterPropagationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitTypeFromIncorrectSetterScript.kts")
    public void testImplicitTypeFromIncorrectSetterScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/implicitTypeFromIncorrectSetterScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitTypeScript.kts")
    public void testImplicitTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/implicitTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localDelegatedPropertyWithPropagatedTypeScript.kts")
    public void testLocalDelegatedPropertyWithPropagatedTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/localDelegatedPropertyWithPropagatedTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localDelegatedPropertyWithPropagatedTypeUnavailableScript.kts")
    public void testLocalDelegatedPropertyWithPropagatedTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/localDelegatedPropertyWithPropagatedTypeUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localImplicitTypeUnavailableInImplicitBodyScript.kts")
    public void testLocalImplicitTypeUnavailableInImplicitBodyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/localImplicitTypeUnavailableInImplicitBodyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localImplicitTypeUnavailableScript.kts")
    public void testLocalImplicitTypeUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/localImplicitTypeUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localPropertyWithPropagatedTypeScript.kts")
    public void testLocalPropertyWithPropagatedTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/localPropertyWithPropagatedTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationBetweenLocalMemberPropertiesImplicitBodyScript.kts")
    public void testPropagationBetweenLocalMemberPropertiesImplicitBodyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/propagationBetweenLocalMemberPropertiesImplicitBodyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationBetweenLocalMemberPropertiesScript.kts")
    public void testPropagationBetweenLocalMemberPropertiesScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/propagationBetweenLocalMemberPropertiesScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationToLocalMemberPropertyImplicitBodyScript.kts")
    public void testPropagationToLocalMemberPropertyImplicitBodyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/propagationToLocalMemberPropertyImplicitBodyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propagationToLocalMemberPropertyScript.kts")
    public void testPropagationToLocalMemberPropertyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/propagationToLocalMemberPropertyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyTypeCollisionAndAnnotationsScript.kts")
    public void testPropertyTypeCollisionAndAnnotationsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/propertyTypeCollisionAndAnnotationsScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("receiverAsImplicitReturnTypePropagationScript.kts")
    public void testReceiverAsImplicitReturnTypePropagationScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/receiverAsImplicitReturnTypePropagationScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("receiverAsImplicitReturnTypeScript.kts")
    public void testReceiverAsImplicitReturnTypeScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/receiverAsImplicitReturnTypeScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("resultBodyAnnotation.kts")
    public void testResultBodyAnnotation() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/resultBodyAnnotation.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("resultWithPropagatedType.kts")
    public void testResultWithPropagatedType() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/resultWithPropagatedType.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("resultWithPropagatedTypeUnavailable.kts")
    public void testResultWithPropagatedTypeUnavailable() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/resultWithPropagatedTypeUnavailable.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeParameterAnnotationsInLocalClassScript.kts")
    public void testTypeParameterAnnotationsInLocalClassScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/property/typeParameterAnnotationsInLocalClassScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride")
  @TestDataPath("$PROJECT_ROOT")
  public class SubstitutionOverride {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInSubstitutionOverride() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructorCallSiteScript.kts")
    public void testConstructorCallSiteScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/constructorCallSiteScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructorScript.kts")
    public void testConstructorScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/constructorScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("functionScript.kts")
    public void testFunctionScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/functionScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("functionUnavailableScript.kts")
    public void testFunctionUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/functionUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitFunctionScript.kts")
    public void testImplicitFunctionScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/implicitFunctionScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitFunctionUnavailableScript.kts")
    public void testImplicitFunctionUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/implicitFunctionUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitPropertyAndReceiverScript.kts")
    public void testImplicitPropertyAndReceiverScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/implicitPropertyAndReceiverScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitPropertyScript.kts")
    public void testImplicitPropertyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/implicitPropertyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicitPropertyUnavailableScript.kts")
    public void testImplicitPropertyUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/implicitPropertyUnavailableScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyScript.kts")
    public void testPropertyScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/propertyScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyUnavailableScript.kts")
    public void testPropertyUnavailableScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/substitutionOverride/propertyUnavailableScript.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/syntheticProperty")
  @TestDataPath("$PROJECT_ROOT")
  public class SyntheticProperty {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInSyntheticProperty() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/syntheticProperty"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/typeAlias")
  @TestDataPath("$PROJECT_ROOT")
  public class TypeAlias {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInTypeAlias() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/typeAlias"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("insideFunctionComplexScript.kts")
    public void testInsideFunctionComplexScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/typeAlias/insideFunctionComplexScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("insideFunctionScript.kts")
    public void testInsideFunctionScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/typeAlias/insideFunctionScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("nestedAliasWithNestedAnnotationInLocalClassScript.kts")
    public void testNestedAliasWithNestedAnnotationInLocalClassScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/typeAlias/nestedAliasWithNestedAnnotationInLocalClassScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simpleScript.kts")
    public void testSimpleScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/typeAlias/simpleScript.kts");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("withMissedArgumentsScript.kts")
    public void testWithMissedArgumentsScript() {
      runTest("analysis/low-level-api-fir/testData/lazyResolveTypeAnnotations/typeAlias/withMissedArgumentsScript.kts");
    }
  }
}
