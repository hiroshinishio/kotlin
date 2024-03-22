/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.runners.ir;

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
@TestMetadata("compiler/testData/ir/sourceRanges")
@TestDataPath("$PROJECT_ROOT")
public class ClassicJvmIrSourceRangesTestGenerated extends AbstractClassicJvmIrSourceRangesTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInSourceRanges() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/ir/sourceRanges"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotations.kt")
  public void testAnnotations() {
    runTest("compiler/testData/ir/sourceRanges/annotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("augmentedAssignmentWithExpression.kt")
  public void testAugmentedAssignmentWithExpression() {
    runTest("compiler/testData/ir/sourceRanges/augmentedAssignmentWithExpression.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("comments.kt")
  public void testComments() {
    runTest("compiler/testData/ir/sourceRanges/comments.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("elvis.kt")
  public void testElvis() {
    runTest("compiler/testData/ir/sourceRanges/elvis.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("extensionLambdaCall.kt")
  public void testExtensionLambdaCall() {
    runTest("compiler/testData/ir/sourceRanges/extensionLambdaCall.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt17108.kt")
  public void testKt17108() {
    runTest("compiler/testData/ir/sourceRanges/kt17108.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt24258.kt")
  public void testKt24258() {
    runTest("compiler/testData/ir/sourceRanges/kt24258.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt63779.kt")
  public void testKt63779() {
    runTest("compiler/testData/ir/sourceRanges/kt63779.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt63779_2.kt")
  public void testKt63779_2() {
    runTest("compiler/testData/ir/sourceRanges/kt63779_2.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multiLineCall.kt")
  public void testMultiLineCall() {
    runTest("compiler/testData/ir/sourceRanges/multiLineCall.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("operators.kt")
  public void testOperators() {
    runTest("compiler/testData/ir/sourceRanges/operators.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("postfixIncrementDecrement.kt")
  public void testPostfixIncrementDecrement() {
    runTest("compiler/testData/ir/sourceRanges/postfixIncrementDecrement.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("this.kt")
  public void testThis() {
    runTest("compiler/testData/ir/sourceRanges/this.kt");
  }

  @Nested
  @TestMetadata("compiler/testData/ir/sourceRanges/declarations")
  @TestDataPath("$PROJECT_ROOT")
  public class Declarations {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInDeclarations() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/ir/sourceRanges/declarations"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classFuns.kt")
    public void testClassFuns() {
      runTest("compiler/testData/ir/sourceRanges/declarations/classFuns.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classProperties.kt")
    public void testClassProperties() {
      runTest("compiler/testData/ir/sourceRanges/declarations/classProperties.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("classes.kt")
    public void testClasses() {
      runTest("compiler/testData/ir/sourceRanges/declarations/classes.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("delegatedProperties.kt")
    public void testDelegatedProperties() {
      runTest("compiler/testData/ir/sourceRanges/declarations/delegatedProperties.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("fakeOverrides.kt")
    public void testFakeOverrides() {
      runTest("compiler/testData/ir/sourceRanges/declarations/fakeOverrides.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("fakeOverrides2.kt")
    public void testFakeOverrides2() {
      runTest("compiler/testData/ir/sourceRanges/declarations/fakeOverrides2.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kt29862.kt")
    public void testKt29862() {
      runTest("compiler/testData/ir/sourceRanges/declarations/kt29862.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("primaryConstructors.kt")
    public void testPrimaryConstructors() {
      runTest("compiler/testData/ir/sourceRanges/declarations/primaryConstructors.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("secondaryConstructors.kt")
    public void testSecondaryConstructors() {
      runTest("compiler/testData/ir/sourceRanges/declarations/secondaryConstructors.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("synthesizedDataClassMembers.kt")
    public void testSynthesizedDataClassMembers() {
      runTest("compiler/testData/ir/sourceRanges/declarations/synthesizedDataClassMembers.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("topLevelFuns.kt")
    public void testTopLevelFuns() {
      runTest("compiler/testData/ir/sourceRanges/declarations/topLevelFuns.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("topLevelProperties.kt")
    public void testTopLevelProperties() {
      runTest("compiler/testData/ir/sourceRanges/declarations/topLevelProperties.kt");
    }
  }
}
