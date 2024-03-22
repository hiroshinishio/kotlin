/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.blackbox;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/klib/dump-ir")
@TestDataPath("$PROJECT_ROOT")
public class NativeKlibDumpIrTestGenerated extends AbstractNativeKlibDumpIrTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInDump_ir() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/klib/dump-ir"), Pattern.compile("^([^_](.+)).kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("class.kt")
  public void testClass() {
    runTest("native/native.tests/testData/klib/dump-ir/class.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("constructor.kt")
  public void testConstructor() {
    runTest("native/native.tests/testData/klib/dump-ir/constructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enum.kt")
  public void testEnum() {
    runTest("native/native.tests/testData/klib/dump-ir/enum.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("field.kt")
  public void testField() {
    runTest("native/native.tests/testData/klib/dump-ir/field.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("fun.kt")
  public void testFun() {
    runTest("native/native.tests/testData/klib/dump-ir/fun.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typealias.kt")
  public void testTypealias() {
    runTest("native/native.tests/testData/klib/dump-ir/typealias.kt");
  }
}
