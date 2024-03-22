/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.symbols;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.symbols.AbstractSymbolByJavaPsiTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/symbols/symbolByJavaPsi")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleSymbolByJavaPsiTestGenerated extends AbstractSymbolByJavaPsiTest {
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
  public void testAllFilesPresentInSymbolByJavaPsi() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/symbols/symbolByJavaPsi"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @RepeatedTest(value = 3)
  @TestMetadata("javaField.kt")
  public void testJavaField() {
    runTest("analysis/analysis-api/testData/symbols/symbolByJavaPsi/javaField.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("javaFieldFromSuperclass.kt")
  public void testJavaFieldFromSuperclass() {
    runTest("analysis/analysis-api/testData/symbols/symbolByJavaPsi/javaFieldFromSuperclass.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("javaStaticField.kt")
  public void testJavaStaticField() {
    runTest("analysis/analysis-api/testData/symbols/symbolByJavaPsi/javaStaticField.kt");
  }

  @RepeatedTest(value = 3)
  @TestMetadata("javaStaticFieldFromSuperclass.kt")
  public void testJavaStaticFieldFromSuperclass() {
    runTest("analysis/analysis-api/testData/symbols/symbolByJavaPsi/javaStaticFieldFromSuperclass.kt");
  }
}
