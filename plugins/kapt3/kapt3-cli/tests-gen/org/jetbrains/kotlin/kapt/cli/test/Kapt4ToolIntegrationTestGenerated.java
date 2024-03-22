/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.kapt.cli.test;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/kapt3/kapt3-cli/testData/integration-kapt4")
@TestDataPath("$PROJECT_ROOT")
public class Kapt4ToolIntegrationTestGenerated extends AbstractKapt4ToolIntegrationTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInIntegration_kapt4() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kapt3/kapt3-cli/testData/integration-kapt4"), Pattern.compile("^([^\\.]+)$"), null, false);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("argfile")
  public void testArgfile() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/argfile/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("compileModeUnsupported")
  public void testCompileModeUnsupported() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/compileModeUnsupported/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("correctErrorTypesOn")
  public void testCorrectErrorTypesOn() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/correctErrorTypesOn/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultMethodsAllCompatibilityNoWarning")
  public void testDefaultMethodsAllCompatibilityNoWarning() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/defaultMethodsAllCompatibilityNoWarning/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultMethodsAllNoWarning")
  public void testDefaultMethodsAllNoWarning() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/defaultMethodsAllNoWarning/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultMethodsWarning")
  public void testDefaultMethodsWarning() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/defaultMethodsWarning/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultPackage")
  public void testDefaultPackage() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/defaultPackage/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kaptUseK2Flag")
  public void testKaptUseK2Flag() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/kaptUseK2Flag/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kotlinFileGeneration")
  public void testKotlinFileGeneration() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/kotlinFileGeneration/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kotlinFileGenerationDefaultOutput")
  public void testKotlinFileGenerationDefaultOutput() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/kotlinFileGenerationDefaultOutput/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt33800")
  public void testKt33800() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/kt33800/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multipass")
  public void testMultipass() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/multipass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("separateStubAptCompilation")
  public void testSeparateStubAptCompilation() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/separateStubAptCompilation/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simple")
  public void testSimple() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/simple/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("withoutService")
  public void testWithoutService() {
    runTest("plugins/kapt3/kapt3-cli/testData/integration-kapt4/withoutService/");
  }
}
