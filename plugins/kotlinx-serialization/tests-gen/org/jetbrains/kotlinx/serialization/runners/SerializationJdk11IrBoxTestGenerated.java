/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlinx.serialization.runners;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlinx.serialization.TestGeneratorKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/kotlinx-serialization/testData/jdk11BoxIr")
@TestDataPath("$PROJECT_ROOT")
public class SerializationJdk11IrBoxTestGenerated extends AbstractSerializationJdk11IrBoxTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInJdk11BoxIr() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kotlinx-serialization/testData/jdk11BoxIr"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt57647.kt")
  public void testKt57647() {
    runTest("plugins/kotlinx-serialization/testData/jdk11BoxIr/kt57647.kt");
  }
}
