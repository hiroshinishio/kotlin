/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.light.classes.symbol.source;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/symbol-light-classes/testData/annotationsEquality")
@TestDataPath("$PROJECT_ROOT")
public class SymbolLightClassesAnnotationEqualityForSourceTestGenerated extends AbstractSymbolLightClassesAnnotationEqualityForSourceTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInAnnotationsEquality() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/symbol-light-classes/testData/annotationsEquality"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Deprecated.kt")
  public void testDeprecated() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/Deprecated.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("EnumConstantNameInQuotes.kt")
  public void testEnumConstantNameInQuotes() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/EnumConstantNameInQuotes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ExplicitRetension.kt")
  public void testExplicitRetension() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/ExplicitRetension.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ImplicitRetension.kt")
  public void testImplicitRetension() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/ImplicitRetension.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("JavaRepeatable.kt")
  public void testJavaRepeatable() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/JavaRepeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("JvmRepeatable.kt")
  public void testJvmRepeatable() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/JvmRepeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("KotlinTargetFirst.kt")
  public void testKotlinTargetFirst() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/KotlinTargetFirst.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("OverrideMethod.kt")
  public void testOverrideMethod() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/OverrideMethod.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Repeatable.kt")
  public void testRepeatable() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/Repeatable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Target.kt")
  public void testTarget() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/Target.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelFunctionWithDeprecatedAnnotation.kt")
  public void testTopLevelFunctionWithDeprecatedAnnotation() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/TopLevelFunctionWithDeprecatedAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelFunctionWithRegularAnnotation.kt")
  public void testTopLevelFunctionWithRegularAnnotation() {
    runTest("analysis/symbol-light-classes/testData/annotationsEquality/TopLevelFunctionWithRegularAnnotation.kt");
  }
}
