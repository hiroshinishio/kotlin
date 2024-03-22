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
@TestMetadata("plugins/kotlinx-serialization/testData/codegen")
@TestDataPath("$PROJECT_ROOT")
public class SerializationAsmLikeInstructionsListingTestGenerated extends AbstractSerializationAsmLikeInstructionsListingTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInCodegen() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kotlinx-serialization/testData/codegen"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Basic.kt")
  public void testBasic() {
    runTest("plugins/kotlinx-serialization/testData/codegen/Basic.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Intrinsics.kt")
  public void testIntrinsics() {
    runTest("plugins/kotlinx-serialization/testData/codegen/Intrinsics.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("IntrinsicsAdvanced.kt")
  public void testIntrinsicsAdvanced() {
    runTest("plugins/kotlinx-serialization/testData/codegen/IntrinsicsAdvanced.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("IntrinsicsNonReified.kt")
  public void testIntrinsicsNonReified() {
    runTest("plugins/kotlinx-serialization/testData/codegen/IntrinsicsNonReified.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Sealed.kt")
  public void testSealed() {
    runTest("plugins/kotlinx-serialization/testData/codegen/Sealed.kt");
  }
}
