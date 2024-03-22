/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.js.test.ir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateJsTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/klib/partial-linkage")
@TestDataPath("$PROJECT_ROOT")
public class JsPartialLinkageNoICES6TestCaseGenerated extends AbstractJsPartialLinkageNoICES6TestCase {
  @RepeatedTest(value = 3)
  @TestMetadata("addEnumEntry")
  public void testAddEnumEntry() {
    runTest("compiler/testData/klib/partial-linkage/addEnumEntry/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("addSealedSubclass")
  public void testAddSealedSubclass() {
    runTest("compiler/testData/klib/partial-linkage/addSealedSubclass/");
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInPartial_linkage() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/klib/partial-linkage"), Pattern.compile("^([^_](.+))$"), null, TargetBackend.JS_IR_ES6, false);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("changeClassVisibility")
  public void testChangeClassVisibility() {
    runTest("compiler/testData/klib/partial-linkage/changeClassVisibility/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("changeFunctionVisibility")
  public void testChangeFunctionVisibility() {
    runTest("compiler/testData/klib/partial-linkage/changeFunctionVisibility/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("changePropertyVisibility")
  public void testChangePropertyVisibility() {
    runTest("compiler/testData/klib/partial-linkage/changePropertyVisibility/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("classTransformations")
  public void testClassTransformations() {
    runTest("compiler/testData/klib/partial-linkage/classTransformations/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("externalDeclarations")
  public void testExternalDeclarations() {
    runTest("compiler/testData/klib/partial-linkage/externalDeclarations/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("externalDeclarationsKJS")
  public void testExternalDeclarationsKJS() {
    runTest("compiler/testData/klib/partial-linkage/externalDeclarationsKJS/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("functionTransformations")
  public void testFunctionTransformations() {
    runTest("compiler/testData/klib/partial-linkage/functionTransformations/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inheritanceIssues")
  public void testInheritanceIssues() {
    runTest("compiler/testData/klib/partial-linkage/inheritanceIssues/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("noNonImplementedCallableFalsePositives")
  public void testNoNonImplementedCallableFalsePositives() {
    runTest("compiler/testData/klib/partial-linkage/noNonImplementedCallableFalsePositives/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nonAbstractCallableBecomesAbstract")
  public void testNonAbstractCallableBecomesAbstract() {
    runTest("compiler/testData/klib/partial-linkage/nonAbstractCallableBecomesAbstract/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nonExhaustivenessOfWhenClause")
  public void testNonExhaustivenessOfWhenClause() {
    runTest("compiler/testData/klib/partial-linkage/nonExhaustivenessOfWhenClause/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("propertyTransformations")
  public void testPropertyTransformations() {
    runTest("compiler/testData/klib/partial-linkage/propertyTransformations/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("referencingUnusableDeclarations")
  public void testReferencingUnusableDeclarations() {
    runTest("compiler/testData/klib/partial-linkage/referencingUnusableDeclarations/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("removeAbstractCallableFromAbstractClassOrInterface")
  public void testRemoveAbstractCallableFromAbstractClassOrInterface() {
    runTest("compiler/testData/klib/partial-linkage/removeAbstractCallableFromAbstractClassOrInterface/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("removeCallable")
  public void testRemoveCallable() {
    runTest("compiler/testData/klib/partial-linkage/removeCallable/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("removeClass")
  public void testRemoveClass() {
    runTest("compiler/testData/klib/partial-linkage/removeClass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("removeEnumEntry")
  public void testRemoveEnumEntry() {
    runTest("compiler/testData/klib/partial-linkage/removeEnumEntry/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("removeSealedSubclass")
  public void testRemoveSealedSubclass() {
    runTest("compiler/testData/klib/partial-linkage/removeSealedSubclass/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("replaceCallableReturnType")
  public void testReplaceCallableReturnType() {
    runTest("compiler/testData/klib/partial-linkage/replaceCallableReturnType/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("severalInheritedImplementations")
  public void testSeveralInheritedImplementations() {
    runTest("compiler/testData/klib/partial-linkage/severalInheritedImplementations/");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typeAliasChanges")
  public void testTypeAliasChanges() {
    runTest("compiler/testData/klib/partial-linkage/typeAliasChanges/");
  }
}
