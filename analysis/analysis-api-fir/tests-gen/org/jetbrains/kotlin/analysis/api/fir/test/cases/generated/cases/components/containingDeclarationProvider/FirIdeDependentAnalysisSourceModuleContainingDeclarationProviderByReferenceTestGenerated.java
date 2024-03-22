/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.containingDeclarationProvider;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.containingDeclarationProvider.AbstractContainingDeclarationProviderByReferenceTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeDependentAnalysisSourceModuleContainingDeclarationProviderByReferenceTestGenerated extends AbstractContainingDeclarationProviderByReferenceTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Dependent,
        AnalysisApiMode.Ide
      )
    );
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInContainingDeclarationByReference() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("codeFragmentFromInside.kt")
  public void testCodeFragmentFromInside() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/codeFragmentFromInside.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("foreignValue.kt")
  public void testForeignValue() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/foreignValue.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("foreignValueScript.kt")
  public void testForeignValueScript() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/foreignValueScript.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("localFunction.kt")
  public void testLocalFunction() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/localFunction.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("localFunctionFromInside.kt")
  public void testLocalFunctionFromInside() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/localFunctionFromInside.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nestedClass.kt")
  public void testNestedClass() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/nestedClass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("nestedClassFromInside.kt")
  public void testNestedClassFromInside() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/nestedClassFromInside.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("propertyAccessor.kt")
  public void testPropertyAccessor() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/propertyAccessor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("propertyAccessorFromInside.kt")
  public void testPropertyAccessorFromInside() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/propertyAccessorFromInside.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("propertyField.kt")
  public void testPropertyField() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/propertyField.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simple.kt")
  public void testSimple() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/simple.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("topLevelFunctionFromInside.kt")
  public void testTopLevelFunctionFromInside() {
    runTest("analysis/analysis-api/testData/components/containingDeclarationProvider/containingDeclarationByReference/topLevelFunctionFromInside.kt");
  }
}
