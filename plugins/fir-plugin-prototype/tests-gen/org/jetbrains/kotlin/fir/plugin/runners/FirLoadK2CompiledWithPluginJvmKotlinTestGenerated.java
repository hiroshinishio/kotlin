/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.plugin.runners;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/fir-plugin-prototype/testData/firLoadK2Compiled")
@TestDataPath("$PROJECT_ROOT")
public class FirLoadK2CompiledWithPluginJvmKotlinTestGenerated extends AbstractFirLoadK2CompiledWithPluginJvmKotlinTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInFirLoadK2Compiled() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/fir-plugin-prototype/testData/firLoadK2Compiled"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationsGeneratedInBackend.kt")
  public void testAnnotationsGeneratedInBackend() {
    runTest("plugins/fir-plugin-prototype/testData/firLoadK2Compiled/annotationsGeneratedInBackend.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationsGeneratedInBackend_MPP.kt")
  public void testAnnotationsGeneratedInBackend_MPP() {
    runTest("plugins/fir-plugin-prototype/testData/firLoadK2Compiled/annotationsGeneratedInBackend_MPP.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simple.kt")
  public void testSimple() {
    runTest("plugins/fir-plugin-prototype/testData/firLoadK2Compiled/simple.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simple-lang-ver-2.1.kt")
  public void testSimple_lang_ver_2_1() {
    runTest("plugins/fir-plugin-prototype/testData/firLoadK2Compiled/simple-lang-ver-2.1.kt");
  }
}
