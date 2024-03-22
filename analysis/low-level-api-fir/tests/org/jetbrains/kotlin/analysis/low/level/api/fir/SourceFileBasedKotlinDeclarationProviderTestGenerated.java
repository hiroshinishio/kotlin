/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/low-level-api-fir/testData/fileBasedDeclarationProvider")
@TestDataPath("$PROJECT_ROOT")
public class SourceFileBasedKotlinDeclarationProviderTestGenerated extends AbstractSourceFileBasedKotlinDeclarationProviderTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInFileBasedDeclarationProvider() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/fileBasedDeclarationProvider"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultPackage.kt")
  public void testDefaultPackage() {
    runTest("analysis/low-level-api-fir/testData/fileBasedDeclarationProvider/defaultPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("local.kt")
  public void testLocal() {
    runTest("analysis/low-level-api-fir/testData/fileBasedDeclarationProvider/local.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nestedTypeAlias.kt")
  public void testNestedTypeAlias() {
    runTest("analysis/low-level-api-fir/testData/fileBasedDeclarationProvider/nestedTypeAlias.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("sameNames.kt")
  public void testSameNames() {
    runTest("analysis/low-level-api-fir/testData/fileBasedDeclarationProvider/sameNames.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simple.kt")
  public void testSimple() {
    runTest("analysis/low-level-api-fir/testData/fileBasedDeclarationProvider/simple.kt");
  }
}
