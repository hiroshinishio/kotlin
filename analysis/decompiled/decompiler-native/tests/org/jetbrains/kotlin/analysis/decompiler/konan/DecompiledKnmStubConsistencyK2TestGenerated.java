/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.decompiler.konan;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder")
@TestDataPath("$PROJECT_ROOT")
public class DecompiledKnmStubConsistencyK2TestGenerated extends AbstractDecompiledKnmStubConsistencyK2Test {
  @RepeatedTest(value = 3)
  public void testAllFilesPresentInClsFileStubBuilder() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder"), Pattern.compile("^([^\\.]+)$"), null, false);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotatedFlexibleTypes")
  public void testAnnotatedFlexibleTypes() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotatedFlexibleTypes/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotatedParameterInEnumConstructor")
  public void testAnnotatedParameterInEnumConstructor() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotatedParameterInEnumConstructor/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotatedParameterInInnerClassConstructor")
  public void testAnnotatedParameterInInnerClassConstructor() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotatedParameterInInnerClassConstructor/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationClass")
  public void testAnnotationClass() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationClass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationValues")
  public void testAnnotationValues() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationValues/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Annotations")
  public void testAnnotations() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Annotations/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationsOnNullableTypes")
  public void testAnnotationsOnNullableTypes() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationsOnNullableTypes/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnnotationsOnParenthesizedTypes")
  public void testAnnotationsOnParenthesizedTypes() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationsOnParenthesizedTypes/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("AnonymousReturnWithGenericType")
  public void testAnonymousReturnWithGenericType() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnonymousReturnWithGenericType/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ClassMembers")
  public void testClassMembers() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ClassMembers/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ClassObject")
  public void testClassObject() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ClassObject/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Const")
  public void testConst() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Const/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ContextReceiversCallableMembers")
  public void testContextReceiversCallableMembers() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversCallableMembers/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ContextReceiversOnClass")
  public void testContextReceiversOnClass() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversOnClass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ContextReceiversOnFunctionType")
  public void testContextReceiversOnFunctionType() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversOnFunctionType/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ContextReceiversOnTopLevelCallables")
  public void testContextReceiversOnTopLevelCallables() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversOnTopLevelCallables/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Contracts")
  public void testContracts() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Contracts/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DataClass")
  public void testDataClass() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/DataClass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DefinitelyNotNullTypes")
  public void testDefinitelyNotNullTypes() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/DefinitelyNotNullTypes/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Delegation")
  public void testDelegation() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Delegation/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("DependencyOnNestedClasses")
  public void testDependencyOnNestedClasses() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/DependencyOnNestedClasses/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Enum")
  public void testEnum() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Enum/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("FlexibleTypes")
  public void testFlexibleTypes() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/FlexibleTypes/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("FunInterfaceDeclaration")
  public void testFunInterfaceDeclaration() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/FunInterfaceDeclaration/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InheritingClasses")
  public void testInheritingClasses() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/InheritingClasses/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InnerClassEnumEntry")
  public void testInnerClassEnumEntry() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/InnerClassEnumEntry/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("InnerTypes")
  public void testInnerTypes() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/InnerTypes/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("LocalClass")
  public void testLocalClass() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/LocalClass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Modifiers")
  public void testModifiers() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Modifiers/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("MultifileClass")
  public void testMultifileClass() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/MultifileClass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("NamedCompanionObject")
  public void testNamedCompanionObject() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/NamedCompanionObject/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("NestedClasses")
  public void testNestedClasses() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/NestedClasses/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Objects")
  public void testObjects() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Objects/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("PrivateConstField")
  public void testPrivateConstField() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/PrivateConstField/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("PrivateToThis")
  public void testPrivateToThis() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/PrivateToThis/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Sealed")
  public void testSealed() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Sealed/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SealedInterface")
  public void testSealedInterface() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/SealedInterface/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SecondaryConstructors")
  public void testSecondaryConstructors() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/SecondaryConstructors/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SpecialNames")
  public void testSpecialNames() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/SpecialNames/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("SuspendLambda")
  public void testSuspendLambda() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/SuspendLambda/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopJvmPackageName")
  public void testTopJvmPackageName() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TopJvmPackageName/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelMembersAnnotatedKt")
  public void testTopLevelMembersAnnotatedKt() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TopLevelMembersAnnotatedKt/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TopLevelMembersKt")
  public void testTopLevelMembersKt() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TopLevelMembersKt/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TypeAliases")
  public void testTypeAliases() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeAliases/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TypeBoundsAndDelegationSpecifiers")
  public void testTypeBoundsAndDelegationSpecifiers() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeBoundsAndDelegationSpecifiers/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TypeModifiers")
  public void testTypeModifiers() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeModifiers/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("TypeParams")
  public void testTypeParams() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeParams/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("Types")
  public void testTypes() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Types/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("UnderscoreParameterName")
  public void testUnderscoreParameterName() {
    runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/UnderscoreParameterName/");
  }
}
