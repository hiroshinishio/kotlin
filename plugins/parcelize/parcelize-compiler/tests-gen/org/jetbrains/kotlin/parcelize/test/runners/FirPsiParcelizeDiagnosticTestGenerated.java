/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.parcelize.test.runners;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/parcelize/parcelize-compiler/testData/diagnostics")
@TestDataPath("$PROJECT_ROOT")
public class FirPsiParcelizeDiagnosticTestGenerated extends AbstractFirPsiParcelizeDiagnosticTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInDiagnostics() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/parcelize/parcelize-compiler/testData/diagnostics"), Pattern.compile("^(.+)\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("constructors.kt")
  public void testConstructors() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/constructors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("customCreator.kt")
  public void testCustomCreator() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/customCreator.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("customParcelers.kt")
  public void testCustomParcelers() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/customParcelers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("customWriteToParcel.kt")
  public void testCustomWriteToParcel() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/customWriteToParcel.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegate.kt")
  public void testDelegate() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/delegate.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("deprecatedAnnotations.kt")
  public void testDeprecatedAnnotations() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/deprecatedAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("emptyPrimaryConstructor.kt")
  public void testEmptyPrimaryConstructor() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/emptyPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ignoredOnParcelDefaultValues.kt")
  public void testIgnoredOnParcelDefaultValues() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/ignoredOnParcelDefaultValues.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ignoredOnParcelUnsupportedType.kt")
  public void testIgnoredOnParcelUnsupportedType() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/ignoredOnParcelUnsupportedType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt20062.kt")
  public void testKt20062() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/kt20062.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt47074.kt")
  public void testKt47074() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/kt47074.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("modality.kt")
  public void testModality() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/modality.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("notMagicParcel.kt")
  public void testNotMagicParcel() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/notMagicParcel.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("properties.kt")
  public void testProperties() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/properties.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simple.kt")
  public void testSimple() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/simple.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("unsupportedType.kt")
  public void testUnsupportedType() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/unsupportedType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("withoutParcelableSupertype.kt")
  public void testWithoutParcelableSupertype() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/withoutParcelableSupertype.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("wrongAnnotationTarget.kt")
  public void testWrongAnnotationTarget() {
    runTest("plugins/parcelize/parcelize-compiler/testData/diagnostics/wrongAnnotationTarget.kt");
  }
}
