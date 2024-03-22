/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fe10.test.cases.generated.cases.components.smartCastProvider;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.smartCastProvider.AbstractHLSmartCastInfoTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo")
@TestDataPath("$PROJECT_ROOT")
public class Fe10IdeNormalAnalysisSourceModuleHLSmartCastInfoTestGenerated extends AbstractHLSmartCastInfoTest {
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
  public void testAllFilesPresentInSmartCastInfo() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("bothImplicitReceiversSmartCast.kt")
  public void testBothImplicitReceiversSmartCast() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/bothImplicitReceiversSmartCast.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multiSmartcastAsReceiver_stable.kt")
  public void testMultiSmartcastAsReceiver_stable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/multiSmartcastAsReceiver_stable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multiSmartcastAsReceiver_unstable.kt")
  public void testMultiSmartcastAsReceiver_unstable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/multiSmartcastAsReceiver_unstable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multiSmartcast_stable.kt")
  public void testMultiSmartcast_stable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/multiSmartcast_stable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("multiSmartcast_unstable.kt")
  public void testMultiSmartcast_unstable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/multiSmartcast_unstable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("smartcastAsReceiver_stable.kt")
  public void testSmartcastAsReceiver_stable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/smartcastAsReceiver_stable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("smartcastAsReceiver_unstable.kt")
  public void testSmartcastAsReceiver_unstable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/smartcastAsReceiver_unstable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("smartcast_stable.kt")
  public void testSmartcast_stable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/smartcast_stable.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("smartcast_unstable.kt")
  public void testSmartcast_unstable() {
    runTest("analysis/analysis-api/testData/components/smartCastProvider/smartCastInfo/smartcast_unstable.kt");
  }
}
