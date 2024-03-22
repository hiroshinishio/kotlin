/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.kapt4;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter")
@TestDataPath("$PROJECT_ROOT")
public class KotlinKapt4ContextTestGenerated extends AbstractKotlinKapt4ContextTest {
  @RepeatedTest(value = 3)
  @TestMetadata("abstractEnum.kt")
  public void testAbstractEnum() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/abstractEnum.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("abstractMethods.kt")
  public void testAbstractMethods() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/abstractMethods.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("aliasedImports.kt")
  public void testAliasedImports() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/aliasedImports.kt");
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInConverter() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationInAnnotationParameters.kt")
  public void testAnnotationInAnnotationParameters() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotationInAnnotationParameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationWithFqNames.kt")
  public void testAnnotationWithFqNames() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotationWithFqNames.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationWithVaragArguments.kt")
  public void testAnnotationWithVaragArguments() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotationWithVaragArguments.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotations.kt")
  public void testAnnotations() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotations2.kt")
  public void testAnnotations2() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotations2.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotations3.kt")
  public void testAnnotations3() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotations3.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationsWithConstants.kt")
  public void testAnnotationsWithConstants() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotationsWithConstants.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("annotationsWithTargets.kt")
  public void testAnnotationsWithTargets() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/annotationsWithTargets.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("anonymousDelegate.kt")
  public void testAnonymousDelegate() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/anonymousDelegate.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("anonymousInitializer.kt")
  public void testAnonymousInitializer() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/anonymousInitializer.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("anonymousObjectInEnumSuperConstructor.kt")
  public void testAnonymousObjectInEnumSuperConstructor() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/anonymousObjectInEnumSuperConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("comments.kt")
  public void testComments() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/comments.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("commentsRemoved.kt")
  public void testCommentsRemoved() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/commentsRemoved.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("cyrillicClassName.kt")
  public void testCyrillicClassName() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/cyrillicClassName.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("dataClass.kt")
  public void testDataClass() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/dataClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultImpls.kt")
  public void testDefaultImpls() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/defaultImpls.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultImplsWithTypeParameters.kt")
  public void testDefaultImplsWithTypeParameters() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/defaultImplsWithTypeParameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultPackage.kt")
  public void testDefaultPackage() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/defaultPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultPackageCorrectErrorTypes.kt")
  public void testDefaultPackageCorrectErrorTypes() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/defaultPackageCorrectErrorTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultParameterValueOff.kt")
  public void testDefaultParameterValueOff() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/defaultParameterValueOff.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("defaultParameterValueOn.kt")
  public void testDefaultParameterValueOn() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/defaultParameterValueOn.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegateCorrectErrorTypes.kt")
  public void testDelegateCorrectErrorTypes() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/delegateCorrectErrorTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegateToList.kt")
  public void testDelegateToList() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/delegateToList.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegatedProperties.kt")
  public void testDelegatedProperties() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/delegatedProperties.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegationAndCompanionObject.kt")
  public void testDelegationAndCompanionObject() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/delegationAndCompanionObject.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegationToAnonymousObject.kt")
  public void testDelegationToAnonymousObject() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/delegationToAnonymousObject.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("deprecated.kt")
  public void testDeprecated() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/deprecated.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enumConstructorCallWithErrorType.kt")
  public void testEnumConstructorCallWithErrorType() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/enumConstructorCallWithErrorType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enumImports.kt")
  public void testEnumImports() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/enumImports.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enumInCompanion.kt")
  public void testEnumInCompanion() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/enumInCompanion.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enumSecondaryConstructor.kt")
  public void testEnumSecondaryConstructor() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/enumSecondaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("enums.kt")
  public void testEnums() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/enums.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("errorExtensionReceiver.kt")
  public void testErrorExtensionReceiver() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/errorExtensionReceiver.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("errorLocationMapping.kt")
  public void testErrorLocationMapping() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/errorLocationMapping.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("errorSuperclass.kt")
  public void testErrorSuperclass() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/errorSuperclass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("errorSuperclassCorrectErrorTypes.kt")
  public void testErrorSuperclassCorrectErrorTypes() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/errorSuperclassCorrectErrorTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("fileFacadeJvmName.kt")
  public void testFileFacadeJvmName() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/fileFacadeJvmName.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("functions.kt")
  public void testFunctions() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/functions.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("genericParameters.kt")
  public void testGenericParameters() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/genericParameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("genericRawSignatures.kt")
  public void testGenericRawSignatures() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/genericRawSignatures.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("genericSimple.kt")
  public void testGenericSimple() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/genericSimple.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("ignoredMembers.kt")
  public void testIgnoredMembers() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/ignoredMembers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("implicitReturnTypes.kt")
  public void testImplicitReturnTypes() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/implicitReturnTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("importsForErrorTypes.kt")
  public void testImportsForErrorTypes() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/importsForErrorTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("importsKt22083.kt")
  public void testImportsKt22083() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/importsKt22083.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("importsWithUnresolvedAnnotations.kt")
  public void testImportsWithUnresolvedAnnotations() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/importsWithUnresolvedAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("incorrectDelegate.kt")
  public void testIncorrectDelegate() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/incorrectDelegate.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inheritanceSimple.kt")
  public void testInheritanceSimple() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/inheritanceSimple.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("inlineClasses.kt")
  public void testInlineClasses() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/inlineClasses.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("innerClassesWithTypeParameters.kt")
  public void testInnerClassesWithTypeParameters() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/innerClassesWithTypeParameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("interfaceImplementation.kt")
  public void testInterfaceImplementation() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/interfaceImplementation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("invalidFieldName.kt")
  public void testInvalidFieldName() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/invalidFieldName.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("javaKeywords.kt")
  public void testJavaKeywords() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/javaKeywords.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("javaKeywordsInPackageNames.kt")
  public void testJavaKeywordsInPackageNames() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/javaKeywordsInPackageNames.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("javadoc.kt")
  public void testJavadoc() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/javadoc.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmDefaultAll.kt")
  public void testJvmDefaultAll() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/jvmDefaultAll.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmDefaultAllCompatibility.kt")
  public void testJvmDefaultAllCompatibility() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/jvmDefaultAllCompatibility.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmOverloads.kt")
  public void testJvmOverloads() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/jvmOverloads.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmRecord.kt")
  public void testJvmRecord() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/jvmRecord.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmRepeatableAnnotation.kt")
  public void testJvmRepeatableAnnotation() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/jvmRepeatableAnnotation.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmStatic.kt")
  public void testJvmStatic() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/jvmStatic.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("jvmStaticFieldInParent.kt")
  public void testJvmStaticFieldInParent() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/jvmStaticFieldInParent.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt14996.kt")
  public void testKt14996() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt14996.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt14997.kt")
  public void testKt14997() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt14997.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt14998.kt")
  public void testKt14998() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt14998.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt15145.kt")
  public void testKt15145() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt15145.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt17567.kt")
  public void testKt17567() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt17567.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt18377.kt")
  public void testKt18377() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt18377.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt18682.kt")
  public void testKt18682() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt18682.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt19700.kt")
  public void testKt19700() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt19700.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt19750.kt")
  public void testKt19750() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt19750.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt24272.kt")
  public void testKt24272() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt24272.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt25071.kt")
  public void testKt25071() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt25071.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt27126.kt")
  public void testKt27126() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt27126.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt28306.kt")
  public void testKt28306() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt28306.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt32596.kt")
  public void testKt32596() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt32596.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt34569.kt")
  public void testKt34569() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt34569.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt43786.kt")
  public void testKt43786() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt43786.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt61729.kt")
  public void testKt61729() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt61729.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt65399.kt")
  public void testKt65399() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt65399.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("kt65453.kt")
  public void testKt65453() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/kt65453.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("lazyProperty.kt")
  public void testLazyProperty() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/lazyProperty.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("leadingDollars.kt")
  public void testLeadingDollars() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/leadingDollars.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("leadingDollars2.kt")
  public void testLeadingDollars2() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/leadingDollars2.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("mapEntry.kt")
  public void testMapEntry() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/mapEntry.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("maxErrorCount.kt")
  public void testMaxErrorCount() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/maxErrorCount.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("methodParameterNames.kt")
  public void testMethodParameterNames() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/methodParameterNames.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("methodPropertySignatureClash.kt")
  public void testMethodPropertySignatureClash() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/methodPropertySignatureClash.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("modifiers.kt")
  public void testModifiers() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/modifiers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multifileClass.kt")
  public void testMultifileClass() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/multifileClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multifileClassDefaultPackage.kt")
  public void testMultifileClassDefaultPackage() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/multifileClassDefaultPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multipleTypeConstraints.kt")
  public void testMultipleTypeConstraints() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/multipleTypeConstraints.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nestedClasses.kt")
  public void testNestedClasses() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/nestedClasses.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nestedClasses2.kt")
  public void testNestedClasses2() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/nestedClasses2.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nestedClassesNonRootPackage.kt")
  public void testNestedClassesNonRootPackage() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/nestedClassesNonRootPackage.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nonExistentClass.kt")
  public void testNonExistentClass() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/nonExistentClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nonExistentClassTypesConversion.kt")
  public void testNonExistentClassTypesConversion() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/nonExistentClassTypesConversion.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nonExistentClassWIthoutCorrection.kt")
  public void testNonExistentClassWIthoutCorrection() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/nonExistentClassWIthoutCorrection.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("primitiveTypes.kt")
  public void testPrimitiveTypes() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/primitiveTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("properties.kt")
  public void testProperties() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/properties.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("propertyAnnotations.kt")
  public void testPropertyAnnotations() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/propertyAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("recentlyNullable.kt")
  public void testRecentlyNullable() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/recentlyNullable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("repeatableAnnotations.kt")
  public void testRepeatableAnnotations() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/repeatableAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("secondaryConstructor.kt")
  public void testSecondaryConstructor() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/secondaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("severalPackageParts.kt")
  public void testSeveralPackageParts() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/severalPackageParts.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("starImports.kt")
  public void testStarImports() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/starImports.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("strangeIdentifiers.kt")
  public void testStrangeIdentifiers() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/strangeIdentifiers.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("strangeNames.kt")
  public void testStrangeNames() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/strangeNames.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("stripMetadata.kt")
  public void testStripMetadata() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/stripMetadata.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("superConstructorCall.kt")
  public void testSuperConstructorCall() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/superConstructorCall.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("suspendArgName.kt")
  public void testSuspendArgName() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/suspendArgName.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("suspendErrorTypes.kt")
  public void testSuspendErrorTypes() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/suspendErrorTypes.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("suspendFunctionSupertype.kt")
  public void testSuspendFunctionSupertype() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/suspendFunctionSupertype.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("suspendFunctionWithBigArity.kt")
  public void testSuspendFunctionWithBigArity() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/suspendFunctionWithBigArity.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("topLevel.kt")
  public void testTopLevel() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/topLevel.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typeAnnotations.kt")
  public void testTypeAnnotations() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/typeAnnotations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("unresolvedDelegateExpression.kt")
  public void testUnresolvedDelegateExpression() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/unresolvedDelegateExpression.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("unsafePropertyInitializers.kt")
  public void testUnsafePropertyInitializers() {
    runTest("plugins/kapt4/../kapt3/kapt3-compiler/testData/converter/unsafePropertyInitializers.kt");
  }
}
