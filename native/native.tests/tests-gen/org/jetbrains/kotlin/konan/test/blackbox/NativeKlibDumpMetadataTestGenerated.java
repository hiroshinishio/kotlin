/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.blackbox;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/klib/dump-metadata")
@TestDataPath("$PROJECT_ROOT")
public class NativeKlibDumpMetadataTestGenerated extends AbstractNativeKlibDumpMetadataTest {
  @RepeatedTest(value = 3)
  @TestMetadata("Accessors.kt")
  public void testAccessors() {
    runTest("native/native.tests/testData/klib/dump-metadata/Accessors.kt");
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInDump_metadata() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/klib/dump-metadata"), Pattern.compile("^([^_](.+)).kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotations.kt")
  public void testAnnotations() {
    runTest("native/native.tests/testData/klib/dump-metadata/annotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotations_source_retention.kt")
  public void testAnnotations_source_retention() {
    runTest("native/native.tests/testData/klib/dump-metadata/annotations_source_retention.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Classes.kt")
  public void testClasses() {
    runTest("native/native.tests/testData/klib/dump-metadata/Classes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Constructors.kt")
  public void testConstructors() {
    runTest("native/native.tests/testData/klib/dump-metadata/Constructors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("data_class.kt")
  public void testData_class() {
    runTest("native/native.tests/testData/klib/dump-metadata/data_class.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Enum.kt")
  public void testEnum() {
    runTest("native/native.tests/testData/klib/dump-metadata/Enum.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("FunctionModifiers.kt")
  public void testFunctionModifiers() {
    runTest("native/native.tests/testData/klib/dump-metadata/FunctionModifiers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt55464_serializeTypeAnnotation.kt")
  public void testKt55464_serializeTypeAnnotation() {
    runTest("native/native.tests/testData/klib/dump-metadata/kt55464_serializeTypeAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt56018_value_parameters_annotations.kt")
  public void testKt56018_value_parameters_annotations() {
    runTest("native/native.tests/testData/klib/dump-metadata/kt56018_value_parameters_annotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("MethodModality.kt")
  public void testMethodModality() {
    runTest("native/native.tests/testData/klib/dump-metadata/MethodModality.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Objects.kt")
  public void testObjects() {
    runTest("native/native.tests/testData/klib/dump-metadata/Objects.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("property_accessors.kt")
  public void testProperty_accessors() {
    runTest("native/native.tests/testData/klib/dump-metadata/property_accessors.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelFunctions.kt")
  public void testTopLevelFunctions() {
    runTest("native/native.tests/testData/klib/dump-metadata/TopLevelFunctions.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelPropertiesCustomPackage.kt")
  public void testTopLevelPropertiesCustomPackage() {
    runTest("native/native.tests/testData/klib/dump-metadata/TopLevelPropertiesCustomPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelPropertiesRootPackage.kt")
  public void testTopLevelPropertiesRootPackage() {
    runTest("native/native.tests/testData/klib/dump-metadata/TopLevelPropertiesRootPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelPropertiesWithClassesCustomPackage.kt")
  public void testTopLevelPropertiesWithClassesCustomPackage() {
    runTest("native/native.tests/testData/klib/dump-metadata/TopLevelPropertiesWithClassesCustomPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelPropertiesWithClassesRootPackage.kt")
  public void testTopLevelPropertiesWithClassesRootPackage() {
    runTest("native/native.tests/testData/klib/dump-metadata/TopLevelPropertiesWithClassesRootPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("type_annotations.kt")
  public void testType_annotations() {
    runTest("native/native.tests/testData/klib/dump-metadata/type_annotations.kt");
  }

  @Nested
  @TestMetadata("native/native.tests/testData/klib/dump-metadata/builtinsSerializer")
  @TestDataPath("$PROJECT_ROOT")
  public class BuiltinsSerializer {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInBuiltinsSerializer() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/klib/dump-metadata/builtinsSerializer"), Pattern.compile("^([^_](.+)).kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotatedEnumEntry.kt")
    public void testAnnotatedEnumEntry() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotatedEnumEntry.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("annotationTargets.kt")
    public void testAnnotationTargets() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationTargets.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("binaryRetainedAnnotation.kt")
    public void testBinaryRetainedAnnotation() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/binaryRetainedAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("compileTimeConstants.kt")
    public void testCompileTimeConstants() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/compileTimeConstants.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("nestedClassesAndObjects.kt")
    public void testNestedClassesAndObjects() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/nestedClassesAndObjects.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("propertyAccessorAnnotations.kt")
    public void testPropertyAccessorAnnotations() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/propertyAccessorAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("simple.kt")
    public void testSimple() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/simple.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("sourceRetainedAnnotation.kt")
    public void testSourceRetainedAnnotation() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/sourceRetainedAnnotation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("stringConcatenation.kt")
    public void testStringConcatenation() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/stringConcatenation.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("typeParameterAnnotation.kt")
    public void testTypeParameterAnnotation() {
      runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/typeParameterAnnotation.kt");
    }

    @Nested
    @TestMetadata("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments")
    @TestDataPath("$PROJECT_ROOT")
    public class AnnotationArguments {
      @RepeatedTest(value = 3)
      public void testAllFilesPresentInAnnotationArguments() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments"), Pattern.compile("^([^_](.+)).kt$"), null, true);
      }

      @RepeatedTest(value = 3)
      @TestMetadata("annotation.kt")
      public void testAnnotation() {
        runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments/annotation.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("enum.kt")
      public void testEnum() {
        runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments/enum.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("primitiveArrays.kt")
      public void testPrimitiveArrays() {
        runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments/primitiveArrays.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("primitives.kt")
      public void testPrimitives() {
        runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments/primitives.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("string.kt")
      public void testString() {
        runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments/string.kt");
      }

      @RepeatedTest(value = 3)
      @TestMetadata("varargs.kt")
      public void testVarargs() {
        runTest("native/native.tests/testData/klib/dump-metadata/builtinsSerializer/annotationArguments/varargs.kt");
      }
    }
  }

  @Nested
  @TestMetadata("native/native.tests/testData/klib/dump-metadata/klib")
  @TestDataPath("$PROJECT_ROOT")
  public class Klib {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInKlib() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/klib/dump-metadata/klib"), Pattern.compile("^([^_](.+)).kt$"), null, true);
    }

    @RepeatedTest(value = 3)
    @TestMetadata("fieldAnnotations.kt")
    public void testFieldAnnotations() {
      runTest("native/native.tests/testData/klib/dump-metadata/klib/fieldAnnotations.kt");
    }

    @RepeatedTest(value = 3)
    @TestMetadata("receiverAnnotations.kt")
    public void testReceiverAnnotations() {
      runTest("native/native.tests/testData/klib/dump-metadata/klib/receiverAnnotations.kt");
    }
  }
}
