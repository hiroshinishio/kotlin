/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostic.compiler.based;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/boxModernJdk")
@TestDataPath("$PROJECT_ROOT")
public class LLFirReversedBlackBoxModernJdkCodegenBasedTestGenerated extends AbstractLLFirReversedBlackBoxCodegenBasedTest {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInBoxModernJdk() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Nested
  @Tag("<modernJava>")
  @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava11")
  @TestDataPath("$PROJECT_ROOT")
  public class TestsWithJava11 {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInTestsWithJava11() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava11"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamic.kt")
    public void testConcatDynamic() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamic.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamic199Long.kt")
    public void testConcatDynamic199Long() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamic199Long.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamic200.kt")
    public void testConcatDynamic200() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamic200.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamic200Long.kt")
    public void testConcatDynamic200Long() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamic200Long.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamic201.kt")
    public void testConcatDynamic201() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamic201.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamicIndy199Long.kt")
    public void testConcatDynamicIndy199Long() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamicIndy199Long.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamicIndy200.kt")
    public void testConcatDynamicIndy200() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamicIndy200.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamicIndy200Long.kt")
    public void testConcatDynamicIndy200Long() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamicIndy200Long.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamicIndy201.kt")
    public void testConcatDynamicIndy201() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamicIndy201.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamicInlineClasses.kt")
    public void testConcatDynamicInlineClasses() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamicInlineClasses.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamicSpecialSymbols.kt")
    public void testConcatDynamicSpecialSymbols() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamicSpecialSymbols.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("concatDynamicWithInline.kt")
    public void testConcatDynamicWithInline() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/concatDynamicWithInline.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kt36984.kt")
    public void testKt36984() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/kt36984.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kt47917.kt")
    public void testKt47917() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/kt47917.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kt47917_oldBackend.kt")
    public void testKt47917_oldBackend() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/kt47917_oldBackend.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kt47917_russian.kt")
    public void testKt47917_russian() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/kt47917_russian.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("kt47917_surrogatePairs.kt")
    public void testKt47917_surrogatePairs() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/kt47917_surrogatePairs.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("varHandle.kt")
    public void testVarHandle() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/varHandle.kt");
    }

    @Nested
    @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag")
    @TestDataPath("$PROJECT_ROOT")
    public class ReleaseFlag {
      @RepeatedTest(value = 3)
      public void testAllFilesPresentInReleaseFlag() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer")
      @TestDataPath("$PROJECT_ROOT")
      public class ByteBuffer {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInByteBuffer() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer.kt")
        public void testByteBuffer() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer/byteBuffer.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_10.kt")
        public void testByteBuffer_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer/byteBuffer_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_11.kt")
        public void testByteBuffer_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer/byteBuffer_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_6.kt")
        public void testByteBuffer_6() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer/byteBuffer_6.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_8.kt")
        public void testByteBuffer_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer/byteBuffer_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_9.kt")
        public void testByteBuffer_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/byteBuffer/byteBuffer_9.kt");
        }
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/innerClass")
      @TestDataPath("$PROJECT_ROOT")
      public class InnerClass {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInInnerClass() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/innerClass"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_10.kt")
        public void testThreadState_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/innerClass/threadState_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_11.kt")
        public void testThreadState_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/innerClass/threadState_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_8.kt")
        public void testThreadState_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/innerClass/threadState_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_9.kt")
        public void testThreadState_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/innerClass/threadState_9.kt");
        }
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective")
      @TestDataPath("$PROJECT_ROOT")
      public class Reflective {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInReflective() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("reflective.kt")
        public void testReflective() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective/reflective.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("reflective_10.kt")
        public void testReflective_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective/reflective_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("reflective_11.kt")
        public void testReflective_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective/reflective_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("reflective_6.kt")
        public void testReflective_6() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective/reflective_6.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("reflective_8.kt")
        public void testReflective_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective/reflective_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("reflective_9.kt")
        public void testReflective_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/reflective/reflective_9.kt");
        }
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/withJava")
      @TestDataPath("$PROJECT_ROOT")
      public class WithJava {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInWithJava() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/withJava"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_10.kt")
        public void testWithJava_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/withJava/withJava_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_11.kt")
        public void testWithJava_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/withJava/withJava_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_6.kt")
        public void testWithJava_6() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/withJava/withJava_6.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_8.kt")
        public void testWithJava_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/withJava/withJava_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_9.kt")
        public void testWithJava_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava11/releaseFlag/withJava/withJava_9.kt");
        }
      }
    }
  }

  @Nested
  @Tag("<modernJava>")
  @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17")
  @TestDataPath("$PROJECT_ROOT")
  public class TestsWithJava17 {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInTestsWithJava17() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Nested
    @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17/records")
    @TestDataPath("$PROJECT_ROOT")
    public class Records {
      @RepeatedTest(value = 3)
      public void testAllFilesPresentInRecords() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17/records"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @RepeatedTest(value = 3)
      @TestMetadata("binaryRecord.kt")
      public void testBinaryRecord() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/binaryRecord.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("bytecodeShapeForJava.kt")
      public void testBytecodeShapeForJava() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/bytecodeShapeForJava.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("callableReferenceToGenericRecord.kt")
      public void testCallableReferenceToGenericRecord() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/callableReferenceToGenericRecord.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("collectionSizeOverrides.kt")
      public void testCollectionSizeOverrides() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/collectionSizeOverrides.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("dataJvmRecord.kt")
      public void testDataJvmRecord() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/dataJvmRecord.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("jvmRecordBinary.kt")
      public void testJvmRecordBinary() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/jvmRecordBinary.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("kt54573.kt")
      public void testKt54573() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/kt54573.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("propertiesOverrides.kt")
      public void testPropertiesOverrides() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/propertiesOverrides.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("propertiesOverridesAllCompatibilityJvmDefault.kt")
      public void testPropertiesOverridesAllCompatibilityJvmDefault() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/propertiesOverridesAllCompatibilityJvmDefault.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("propertiesOverridesAllJvmDefault.kt")
      public void testPropertiesOverridesAllJvmDefault() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/propertiesOverridesAllJvmDefault.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("recordDifferentPropertyOverride.kt")
      public void testRecordDifferentPropertyOverride() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/recordDifferentPropertyOverride.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("recordDifferentSyntheticProperty.kt")
      public void testRecordDifferentSyntheticProperty() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/recordDifferentSyntheticProperty.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("recordPropertyAccess.kt")
      public void testRecordPropertyAccess() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/recordPropertyAccess.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("recordWithCompanion.kt")
      public void testRecordWithCompanion() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/records/recordWithCompanion.kt");
      }
    }

    @Nested
    @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag")
    @TestDataPath("$PROJECT_ROOT")
    public class ReleaseFlag {
      @RepeatedTest(value = 3)
      public void testAllFilesPresentInReleaseFlag() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer")
      @TestDataPath("$PROJECT_ROOT")
      public class ByteBuffer {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInByteBuffer() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer.kt")
        public void testByteBuffer() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_10.kt")
        public void testByteBuffer_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_11.kt")
        public void testByteBuffer_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_12.kt")
        public void testByteBuffer_12() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_12.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_13.kt")
        public void testByteBuffer_13() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_13.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_14.kt")
        public void testByteBuffer_14() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_14.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_15.kt")
        public void testByteBuffer_15() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_15.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_16.kt")
        public void testByteBuffer_16() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_16.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_17.kt")
        public void testByteBuffer_17() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_17.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_8.kt")
        public void testByteBuffer_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("byteBuffer_9.kt")
        public void testByteBuffer_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/byteBuffer/byteBuffer_9.kt");
        }
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable")
      @TestDataPath("$PROJECT_ROOT")
      public class Constable {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInConstable() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable.kt")
        public void testConstable() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_10.kt")
        public void testConstable_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_11.kt")
        public void testConstable_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_12.kt")
        public void testConstable_12() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_12.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_13.kt")
        public void testConstable_13() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_13.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_14.kt")
        public void testConstable_14() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_14.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_15.kt")
        public void testConstable_15() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_15.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_16.kt")
        public void testConstable_16() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_16.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_17.kt")
        public void testConstable_17() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_17.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_8.kt")
        public void testConstable_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("constable_9.kt")
        public void testConstable_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/constable/constable_9.kt");
        }
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass")
      @TestDataPath("$PROJECT_ROOT")
      public class InnerClass {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInInnerClass() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_10.kt")
        public void testThreadState_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_11.kt")
        public void testThreadState_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_12.kt")
        public void testThreadState_12() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_12.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_13.kt")
        public void testThreadState_13() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_13.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_14.kt")
        public void testThreadState_14() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_14.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_15.kt")
        public void testThreadState_15() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_15.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_16.kt")
        public void testThreadState_16() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_16.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_17.kt")
        public void testThreadState_17() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_17.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_8.kt")
        public void testThreadState_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("threadState_9.kt")
        public void testThreadState_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/innerClass/threadState_9.kt");
        }
      }

      @Nested
      @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava")
      @TestDataPath("$PROJECT_ROOT")
      public class WithJava {
        @RepeatedTest(value = 3)
        public void testAllFilesPresentInWithJava() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_10.kt")
        public void testWithJava_10() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_10.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_11.kt")
        public void testWithJava_11() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_11.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_12.kt")
        public void testWithJava_12() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_12.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_13.kt")
        public void testWithJava_13() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_13.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_14.kt")
        public void testWithJava_14() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_14.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_15.kt")
        public void testWithJava_15() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_15.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_16.kt")
        public void testWithJava_16() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_16.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_17.kt")
        public void testWithJava_17() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_17.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_8.kt")
        public void testWithJava_8() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_8.kt");
        }

        @RepeatedTest(value = 3)
        @TestMetadata("withJava_9.kt")
        public void testWithJava_9() {
          runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/releaseFlag/withJava/withJava_9.kt");
        }
      }
    }

    @Nested
    @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed")
    @TestDataPath("$PROJECT_ROOT")
    public class Sealed {
      @RepeatedTest(value = 3)
      public void testAllFilesPresentInSealed() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @RepeatedTest(value = 3)
      @TestMetadata("compiledJavaSealedClass.kt")
      public void testCompiledJavaSealedClass() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/compiledJavaSealedClass.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("compiledJavaSealedInterface.kt")
      public void testCompiledJavaSealedInterface() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/compiledJavaSealedInterface.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("javaExhaustiveWhenOnKotlinSealedClass.kt")
      public void testJavaExhaustiveWhenOnKotlinSealedClass() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/javaExhaustiveWhenOnKotlinSealedClass.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("javaRecordsViaKotlinReflection.kt")
      public void testJavaRecordsViaKotlinReflection() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/javaRecordsViaKotlinReflection.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("javaSealedClass.kt")
      public void testJavaSealedClass() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/javaSealedClass.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("javaSealedInterface.kt")
      public void testJavaSealedInterface() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/javaSealedInterface.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("kotlinExhaustiveWhenOnJavaSealedClass.kt")
      public void testKotlinExhaustiveWhenOnJavaSealedClass() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/kotlinExhaustiveWhenOnJavaSealedClass.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("permittedSubclassesOfSealedKotlinClass.kt")
      public void testPermittedSubclassesOfSealedKotlinClass() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/permittedSubclassesOfSealedKotlinClass.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("sealedJavaClassViaJavaReflection.kt")
      public void testSealedJavaClassViaJavaReflection() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/sealedJavaClassViaJavaReflection.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("sealedJavaClassViaKotlinReflection.kt")
      public void testSealedJavaClassViaKotlinReflection() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/sealedJavaClassViaKotlinReflection.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("sealedJavaInterfaceViaKotlinReflection.kt")
      public void testSealedJavaInterfaceViaKotlinReflection() {
        runTest("compiler/testData/codegen/boxModernJdk/testsWithJava17/sealed/sealedJavaInterfaceViaKotlinReflection.kt");
      }
    }
  }

  @Nested
  @TestMetadata("compiler/testData/codegen/boxModernJdk/testsWithJava21")
  @TestDataPath("$PROJECT_ROOT")
  public class TestsWithJava21 {
    @RepeatedTest(value = 3)
    @TestMetadata("addRemoveOnMutableList.kt")
    public void testAddRemoveOnMutableList() {
      runTest("compiler/testData/codegen/boxModernJdk/testsWithJava21/addRemoveOnMutableList.kt");
    }

    @RepeatedTest(value = 3)
    public void testAllFilesPresentInTestsWithJava21() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxModernJdk/testsWithJava21"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }
  }
}
