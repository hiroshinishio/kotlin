/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.types;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.standalone.fir.test.configurators.AnalysisApiFirStandaloneModeTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.types.AbstractTypeByDeclarationReturnTypeTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/types/byDeclarationReturnType")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisSourceModuleTypeByDeclarationReturnTypeTestGenerated extends AbstractTypeByDeclarationReturnTypeTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirStandaloneModeTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Standalone
      )
    );
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInByDeclarationReturnType() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/types/byDeclarationReturnType"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("anonymousFunction.kt")
  public void testAnonymousFunction() {
    runTest("analysis/analysis-api/testData/types/byDeclarationReturnType/anonymousFunction.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("localClassType.kt")
  public void testLocalClassType() {
    runTest("analysis/analysis-api/testData/types/byDeclarationReturnType/localClassType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("localClassWithTypeArgumentsType.kt")
  public void testLocalClassWithTypeArgumentsType() {
    runTest("analysis/analysis-api/testData/types/byDeclarationReturnType/localClassWithTypeArgumentsType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("localNestedClassType.kt")
  public void testLocalNestedClassType() {
    runTest("analysis/analysis-api/testData/types/byDeclarationReturnType/localNestedClassType.kt");
  }
}
