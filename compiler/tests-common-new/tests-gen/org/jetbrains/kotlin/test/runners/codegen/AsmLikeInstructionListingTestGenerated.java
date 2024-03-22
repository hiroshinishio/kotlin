/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.runners.codegen;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.test.generators.GenerateCompilerTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/asmLike")
@TestDataPath("$PROJECT_ROOT")
public class AsmLikeInstructionListingTestGenerated extends AbstractAsmLikeInstructionListingTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInAsmLike() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/asmLike"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM, true);
  }

  @Nested
  @TestMetadata("compiler/testData/codegen/asmLike/receiverMangling")
  @TestDataPath("$PROJECT_ROOT")
  public class ReceiverMangling {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInReceiverMangling() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/asmLike/receiverMangling"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("deepInline.kt")
    public void testDeepInline() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/deepInline.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("deepInlineWithLabels.kt")
    public void testDeepInlineWithLabels() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/deepInlineWithLabels.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("deepNoinlineWithLabels_after.kt")
    public void testDeepNoinlineWithLabels_after() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/deepNoinlineWithLabels_after.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("deepNoinlineWithLabels_before.kt")
    public void testDeepNoinlineWithLabels_before() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/deepNoinlineWithLabels_before.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("deepNoinline_after.kt")
    public void testDeepNoinline_after() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/deepNoinline_after.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("deepNoinline_before.kt")
    public void testDeepNoinline_before() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/deepNoinline_before.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("inlineClassCapture.kt")
    public void testInlineClassCapture() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/inlineClassCapture.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("inlineReceivers.kt")
    public void testInlineReceivers() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/inlineReceivers.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("localFunctions.kt")
    public void testLocalFunctions() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/localFunctions.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("mangledNames.kt")
    public void testMangledNames() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/mangledNames.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("nonInlineReceivers_after.kt")
    public void testNonInlineReceivers_after() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/nonInlineReceivers_after.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("nonInlineReceivers_before.kt")
    public void testNonInlineReceivers_before() {
      runTest("compiler/testData/codegen/asmLike/receiverMangling/nonInlineReceivers_before.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/codegen/asmLike/typeAnnotations")
  @TestDataPath("$PROJECT_ROOT")
  public class TypeAnnotations {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInTypeAnnotations() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/asmLike/typeAnnotations"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("complex.kt")
    public void testComplex() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/complex.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("constructor.kt")
    public void testConstructor() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/constructor.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("defaultArgs.kt")
    public void testDefaultArgs() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/defaultArgs.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("dontEmit.kt")
    public void testDontEmit() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/dontEmit.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("enumClassConstructor.kt")
    public void testEnumClassConstructor() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/enumClassConstructor.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("extension.kt")
    public void testExtension() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/extension.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("implicit.kt")
    public void testImplicit() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/implicit.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("innerClassConstructor.kt")
    public void testInnerClassConstructor() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/innerClassConstructor.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("jvmOverload.kt")
    public void testJvmOverload() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/jvmOverload.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("jvmStatic.kt")
    public void testJvmStatic() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/jvmStatic.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("notYetSupported.kt")
    public void testNotYetSupported() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/notYetSupported.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("property.kt")
    public void testProperty() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/property.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simple.kt")
    public void testSimple() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/simple.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simple2Params.kt")
    public void testSimple2Params() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/simple2Params.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("staticNested.kt")
    public void testStaticNested() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/staticNested.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("syntheticAccessors.kt")
    public void testSyntheticAccessors() {
      runTest("compiler/testData/codegen/asmLike/typeAnnotations/syntheticAccessors.kt");
    }
  }
}
