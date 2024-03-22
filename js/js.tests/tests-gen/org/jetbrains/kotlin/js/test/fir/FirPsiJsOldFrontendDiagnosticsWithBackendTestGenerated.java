/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.js.test.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateJsTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation")
@TestDataPath("$PROJECT_ROOT")
public class FirPsiJsOldFrontendDiagnosticsWithBackendTestGenerated extends AbstractFirPsiJsDiagnosticWithBackendTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInTestsWithJsStdLibAndBackendCompilation() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation"), Pattern.compile("^([^_](.+))\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), TargetBackend.JS_IR, true);
  }

  @Nested
  @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash")
  @TestDataPath("$PROJECT_ROOT")
  public class ExportedNamesClash {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInExportedNamesClash() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash"), Pattern.compile("^([^_](.+))\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), TargetBackend.JS_IR, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("functionAndFunction.kt")
    public void testFunctionAndFunction() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/functionAndFunction.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("functionAndProperty.kt")
    public void testFunctionAndProperty() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/functionAndProperty.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("functionDifferentPackages.kt")
    public void testFunctionDifferentPackages() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/functionDifferentPackages.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("multipleClash.kt")
    public void testMultipleClash() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/multipleClash.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("multipleClashESModules.kt")
    public void testMultipleClashESModules() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/multipleClashESModules.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("packageAndFunction.kt")
    public void testPackageAndFunction() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/packageAndFunction.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("packageAndProperty.kt")
    public void testPackageAndProperty() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/packageAndProperty.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyAndProperty.kt")
    public void testPropertyAndProperty() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/propertyAndProperty.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyDifferentPackages.kt")
    public void testPropertyDifferentPackages() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/exportedNamesClash/propertyDifferentPackages.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/inline")
  @TestDataPath("$PROJECT_ROOT")
  public class Inline {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInInline() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/inline"), Pattern.compile("^([^_](.+))\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), TargetBackend.JS_IR, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("recursionCycle.kt")
    public void testRecursionCycle() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/inline/recursionCycle.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("recursionCycleLambda.kt")
    public void testRecursionCycleLambda() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/inline/recursionCycleLambda.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("recursionCycleWithPublicFun.kt")
    public void testRecursionCycleWithPublicFun() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/inline/recursionCycleWithPublicFun.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("recursionCycleWithStdlibCall.kt")
    public void testRecursionCycleWithStdlibCall() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/inline/recursionCycleWithStdlibCall.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode")
  @TestDataPath("$PROJECT_ROOT")
  public class JsCode {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInJsCode() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode"), Pattern.compile("^([^_](.+))\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), TargetBackend.JS_IR, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("argumentIsLiteral.kt")
    public void testArgumentIsLiteral() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/argumentIsLiteral.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("badAssignment.kt")
    public void testBadAssignment() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/badAssignment.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeString.kt")
    public void testCompileTimeString() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/compileTimeString.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeStringWithCompanionVal.kt")
    public void testCompileTimeStringWithCompanionVal() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/compileTimeStringWithCompanionVal.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeStringWithConstVal.kt")
    public void testCompileTimeStringWithConstVal() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/compileTimeStringWithConstVal.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeStringWithFunCall.kt")
    public void testCompileTimeStringWithFunCall() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/compileTimeStringWithFunCall.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeStringWithIntrinConstCall.kt")
    public void testCompileTimeStringWithIntrinConstCall() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/compileTimeStringWithIntrinConstCall.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeStringWithTopLevelVal.kt")
    public void testCompileTimeStringWithTopLevelVal() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/compileTimeStringWithTopLevelVal.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeStringWithVal.kt")
    public void testCompileTimeStringWithVal() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/compileTimeStringWithVal.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("deleteOperation.kt")
    public void testDeleteOperation() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/deleteOperation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("error.kt")
    public void testError() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/error.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("javaScriptEmpty.kt")
    public void testJavaScriptEmpty() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/javaScriptEmpty.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("javaScriptError.kt")
    public void testJavaScriptError() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/javaScriptError.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("javaScriptWarning.kt")
    public void testJavaScriptWarning() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/javaScriptWarning.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("noJavaScriptProduced.kt")
    public void testNoJavaScriptProduced() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/noJavaScriptProduced.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("warning.kt")
    public void testWarning() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/jsCode/warning.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/unsupportedFeatures")
  @TestDataPath("$PROJECT_ROOT")
  public class UnsupportedFeatures {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInUnsupportedFeatures() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/unsupportedFeatures"), Pattern.compile("^([^_](.+))\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), TargetBackend.JS_IR, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotations.kt")
    public void testAnnotations() {
      runTest("compiler/testData/diagnostics/testsWithJsStdLibAndBackendCompilation/unsupportedFeatures/annotations.kt");
    }
  }
}
