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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.expressionTypeProvider.AbstractHLExpressionTypeTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisScriptSourceModuleHLExpressionTypeTestGenerated extends AbstractHLExpressionTypeTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.ScriptSource,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @RepeatedTest(value = 3)
  public void testAllFilesPresentInExpressionType() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType"), Pattern.compile("^(.+)\\.kts$"), null, true);
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment")
  @TestDataPath("$PROJECT_ROOT")
  public class Assignment {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInAssignment() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment"), Pattern.compile("^(.+)\\.kts$"), null, true);
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference")
  @TestDataPath("$PROJECT_ROOT")
  public class NameReference {
    @RepeatedTest(value = 3)
    public void testAllFilesPresentInNameReference() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference"), Pattern.compile("^(.+)\\.kts$"), null, true);
    }
  }
}
