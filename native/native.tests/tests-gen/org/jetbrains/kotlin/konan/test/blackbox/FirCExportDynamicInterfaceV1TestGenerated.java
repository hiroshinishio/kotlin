/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.blackbox;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.konan.test.blackbox.support.EnforcedProperty;
import org.jetbrains.kotlin.konan.test.blackbox.support.ClassLevelProperty;
import org.junit.jupiter.api.Tag;
import org.jetbrains.kotlin.konan.test.blackbox.support.group.FirPipeline;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/CExport/InterfaceV1")
@TestDataPath("$PROJECT_ROOT")
@EnforcedProperty(property = ClassLevelProperty.BINARY_LIBRARY_KIND, propertyValue = "DYNAMIC")
@EnforcedProperty(property = ClassLevelProperty.C_INTERFACE_MODE, propertyValue = "V1")
@Tag("frontend-fir")
@FirPipeline()
public class FirCExportDynamicInterfaceV1TestGenerated extends AbstractNativeCExportTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInInterfaceV1() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/CExport/InterfaceV1"), Pattern.compile("^([^_](.+))$"), null, false);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt36639")
  public void testKt36639() {
    runTest("native/native.tests/testData/CExport/InterfaceV1/kt36639/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("smoke0")
  public void testSmoke0() {
    runTest("native/native.tests/testData/CExport/InterfaceV1/smoke0/");
  }
}
