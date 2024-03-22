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
@TestMetadata("analysis/low-level-api-fir/testData/classId")
@TestDataPath("$PROJECT_ROOT")
public class ScriptClassIdConsistencyTestGenerated extends AbstractScriptClassIdConsistencyTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInClassId() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/classId"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("classWithMembers.kts")
  public void testClassWithMembers() {
    runTest("analysis/low-level-api-fir/testData/classId/classWithMembers.kts");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("classWithMembersWithPackage.kts")
  public void testClassWithMembersWithPackage() {
    runTest("analysis/low-level-api-fir/testData/classId/classWithMembersWithPackage.kts");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enum.kts")
  public void testEnum() {
    runTest("analysis/low-level-api-fir/testData/classId/enum.kts");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enumEntry.kts")
  public void testEnumEntry() {
    runTest("analysis/low-level-api-fir/testData/classId/enumEntry.kts");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("namelessClasses.kts")
  public void testNamelessClasses() {
    runTest("analysis/low-level-api-fir/testData/classId/namelessClasses.kts");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("namelessInsideNamelessClasses.kts")
  public void testNamelessInsideNamelessClasses() {
    runTest("analysis/low-level-api-fir/testData/classId/namelessInsideNamelessClasses.kts");
  }
}
