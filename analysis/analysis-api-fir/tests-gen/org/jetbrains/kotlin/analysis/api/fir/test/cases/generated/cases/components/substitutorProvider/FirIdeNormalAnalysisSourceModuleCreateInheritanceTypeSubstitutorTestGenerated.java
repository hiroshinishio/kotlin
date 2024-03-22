/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.substitutorProvider;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.substitutorProvider.AbstractCreateInheritanceTypeSubstitutorTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleCreateInheritanceTypeSubstitutorTestGenerated extends AbstractCreateInheritanceTypeSubstitutorTest {
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
  public void testAllFilesPresentInCreateInheritanceTypeSubstitutor() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("chain.kt")
  public void testChain() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/chain.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("cycle.kt")
  public void testCycle() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/cycle.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("diamond.kt")
  public void testDiamond() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/diamond.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("directComplexSubstitution.kt")
  public void testDirectComplexSubstitution() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/directComplexSubstitution.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("directType.kt")
  public void testDirectType() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/directType.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("directTypeParam.kt")
  public void testDirectTypeParam() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/directTypeParam.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("errorInUpperBound.kt")
  public void testErrorInUpperBound() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/errorInUpperBound.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("extraTypeArgument.kt")
  public void testExtraTypeArgument() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/extraTypeArgument.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("missingTypeArgument.kt")
  public void testMissingTypeArgument() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/missingTypeArgument.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multipleInheritance.kt")
  public void testMultipleInheritance() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/multipleInheritance.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("self.kt")
  public void testSelf() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/self.kt");
  }
}
