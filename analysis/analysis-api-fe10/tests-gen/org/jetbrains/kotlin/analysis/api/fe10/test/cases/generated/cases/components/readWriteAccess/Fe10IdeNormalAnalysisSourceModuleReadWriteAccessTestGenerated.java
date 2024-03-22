/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fe10.test.cases.generated.cases.components.readWriteAccess;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fe10.test.configurator.AnalysisApiFe10TestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.readWriteAccess.AbstractReadWriteAccessTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess")
@TestDataPath("$PROJECT_ROOT")
public class Fe10IdeNormalAnalysisSourceModuleReadWriteAccessTestGenerated extends AbstractReadWriteAccessTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFe10TestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fe10,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInReadWriteAccess() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("assignment.kt")
  public void testAssignment() {
    runTest("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess/assignment.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("assignmentPlusEq.kt")
  public void testAssignmentPlusEq() {
    runTest("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess/assignmentPlusEq.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("namedArguments.kt")
  public void testNamedArguments() {
    runTest("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess/namedArguments.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("readReference.kt")
  public void testReadReference() {
    runTest("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess/readReference.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("readReferenceInParenthesis.kt")
  public void testReadReferenceInParenthesis() {
    runTest("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess/readReferenceInParenthesis.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("unary.kt")
  public void testUnary() {
    runTest("analysis/analysis-api/testData/components/expressionInfoProvider/readWriteAccess/unary.kt");
  }
}
