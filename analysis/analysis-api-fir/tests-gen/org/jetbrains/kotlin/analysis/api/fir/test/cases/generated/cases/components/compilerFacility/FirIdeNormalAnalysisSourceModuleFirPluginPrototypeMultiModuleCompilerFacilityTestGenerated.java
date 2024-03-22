/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.compilerFacility;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.compilerFacility.AbstractFirPluginPrototypeMultiModuleCompilerFacilityTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleFirPluginPrototypeMultiModuleCompilerFacilityTestGenerated extends AbstractFirPluginPrototypeMultiModuleCompilerFacilityTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInFirPluginPrototypeMultiModule() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("composableFunctionMultiModules.kt")
  public void testComposableFunctionMultiModules() {
    runTest("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule/composableFunctionMultiModules.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("composableFunctionMultiModules2.kt")
  public void testComposableFunctionMultiModules2() {
    runTest("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule/composableFunctionMultiModules2.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("composableInlineFunctionExpressionParameter.kt")
  public void testComposableInlineFunctionExpressionParameter() {
    runTest("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule/composableInlineFunctionExpressionParameter.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("functionParamInBinaryModule.kt")
  public void testFunctionParamInBinaryModule() {
    runTest("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule/functionParamInBinaryModule.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("functionParamInBinaryModule2.kt")
  public void testFunctionParamInBinaryModule2() {
    runTest("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule/functionParamInBinaryModule2.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("functionParamInBinaryModule3.kt")
  public void testFunctionParamInBinaryModule3() {
    runTest("analysis/analysis-api/testData/components/compilerFacility/firPluginPrototypeMultiModule/functionParamInBinaryModule3.kt");
  }
}
