/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.assignment.plugin;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/assign-plugin/testData/codegen")
@TestDataPath("$PROJECT_ROOT")
public class FirLightTreeBlackBoxCodegenTestForAssignmentPluginGenerated extends AbstractFirLightTreeBlackBoxCodegenTestForAssignmentPlugin {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInCodegen() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/assign-plugin/testData/codegen"), Pattern.compile("^(.+)\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), TargetBackend.JVM_IR, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotation.kt")
  public void testAnnotation() {
    runTest("plugins/assign-plugin/testData/codegen/annotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("otherOperators.kt")
  public void testOtherOperators() {
    runTest("plugins/assign-plugin/testData/codegen/otherOperators.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("plusAssignPrecedence.kt")
  public void testPlusAssignPrecedence() {
    runTest("plugins/assign-plugin/testData/codegen/plusAssignPrecedence.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("qualifiedAnnotation.kt")
  public void testQualifiedAnnotation() {
    runTest("plugins/assign-plugin/testData/codegen/qualifiedAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("supportedUsage.kt")
  public void testSupportedUsage() {
    runTest("plugins/assign-plugin/testData/codegen/supportedUsage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typealias.kt")
  public void testTypealias() {
    runTest("plugins/assign-plugin/testData/codegen/typealias.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varBehaviour.kt")
  public void testVarBehaviour() {
    runTest("plugins/assign-plugin/testData/codegen/varBehaviour.kt");
  }
}
