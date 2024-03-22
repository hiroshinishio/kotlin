/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.expressionTypeProvider;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.expressionTypeProvider.AbstractDeclarationReturnTypeTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleDeclarationReturnTypeTestGenerated extends AbstractDeclarationReturnTypeTest {
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
  public void testAllFilesPresentInDeclarationReturnType() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("declarationInPrimaryConstructor.kt")
  public void testDeclarationInPrimaryConstructor() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/declarationInPrimaryConstructor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("delegateProperties.kt")
  public void testDelegateProperties() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/delegateProperties.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("functionWithoutParameterList.kt")
  public void testFunctionWithoutParameterList() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/functionWithoutParameterList.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("funtionType.kt")
  public void testFuntionType() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/funtionType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("localDeclarations.kt")
  public void testLocalDeclarations() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/localDeclarations.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("overriddenMember.kt")
  public void testOverriddenMember() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/overriddenMember.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("platformType.kt")
  public void testPlatformType() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/platformType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("propertyAccessor.kt")
  public void testPropertyAccessor() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/propertyAccessor.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("simpleDeclaration.kt")
  public void testSimpleDeclaration() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/simpleDeclaration.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("typeParameters.kt")
  public void testTypeParameters() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/typeParameters.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("varargParam.kt")
  public void testVarargParam() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/declarationReturnType/varargParam.kt");
  }
}
