/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.blackbox;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.junit.jupiter.api.Tag;
import org.jetbrains.kotlin.konan.test.blackbox.support.group.FirPipeline;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/klib/dump-signatures")
@TestDataPath("$PROJECT_ROOT")
@Tag("frontend-fir")
@FirPipeline()
public class FirNativeKlibDumpIrSignaturesTestGenerated extends AbstractNativeKlibDumpIrSignaturesTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInDump_signatures() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/klib/dump-signatures"), Pattern.compile("^([^_](.+)).kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("callables.kt")
  public void testCallables() {
    runTest("native/native.tests/testData/klib/dump-signatures/callables.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("imported_declarations.kt")
  public void testImported_declarations() {
    runTest("native/native.tests/testData/klib/dump-signatures/imported_declarations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("imported_from_cinterop.kt")
  public void testImported_from_cinterop() {
    runTest("native/native.tests/testData/klib/dump-signatures/imported_from_cinterop.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("type_parameters.kt")
  public void testType_parameters() {
    runTest("native/native.tests/testData/klib/dump-signatures/type_parameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("visibility.kt")
  public void testVisibility() {
    runTest("native/native.tests/testData/klib/dump-signatures/visibility.kt");
  }
}
