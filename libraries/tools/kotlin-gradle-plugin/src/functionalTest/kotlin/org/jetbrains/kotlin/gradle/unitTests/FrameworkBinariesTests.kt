/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.unitTests

import org.gradle.api.artifacts.Configuration
import org.gradle.api.attributes.Attribute
import org.jetbrains.kotlin.gradle.util.buildProjectWithMPP
import org.jetbrains.kotlin.gradle.util.kotlin
import kotlin.test.Test
import kotlin.test.assertEquals

class FrameworkBinariesTests {

    @Test
    fun `framework output file - reflects link task output file`() {
        buildProjectWithMPP {
            kotlin {
                iosSimulatorArm64 {
                    binaries.framework {
                        assertEquals(
                            "test.framework",
                            linkTaskProvider.get().outputFile.get().name,
                        )
                        assertEquals(
                            "test.framework",
                            outputFile.name,
                        )

                        baseName = "foo"

                        assertEquals(
                            "foo.framework",
                            linkTaskProvider.get().outputFile.get().name,
                        )
                        assertEquals(
                            "foo.framework",
                            outputFile.name,
                        )
                    }
                }
            }
        }
    }

    @Test
    fun `consumable framework configurations - have correct outgoing framework artifact and attributes - when attributes are applied at target and framework level`() {
        val disambiguation1Attribute = Attribute.of("myDisambiguation1Attribute", String::class.java)
        val disambiguation2Attribute = Attribute.of("myDisambiguation2Attribute", String::class.java)

        val frameworkProducer = buildProjectWithMPP {
            kotlin {
                iosArm64 {
                    attributes.attribute(disambiguation1Attribute, "someValue")
                    binaries {
                        framework("main")
                        framework("custom") {
                            attributes.attribute(disambiguation2Attribute, "someValue2")
                        }
                    }
                }

                iosX64 {
                    binaries {
                        framework("main")
                    }
                }
            }
        }.evaluate()

        val frameworkTargets = Attribute.of(
            "org.jetbrains.kotlin.native.framework.targets",
            Set::class.java
        )
        val kotlinNativeBuildTypeAttribute = Attribute.of(
            "org.jetbrains.kotlin.native.build.type",
            String::class.java
        )

        fun Configuration.validateOutgoing(
            expectedBuildType: String,
            expectedFrameworkAttributes: Set<String>,
            expectedFrameworkName: String,
            expectedDisambiguation1Attribute: String?,
            expectedDisambiguation2Attribute: String?,
        ) {
            val framework = outgoing.artifacts.single()
            assertEquals(
                expectedFrameworkName,
                framework.file.name,
            )
            assertEquals(
                expectedFrameworkAttributes,
                outgoing.attributes.getAttribute(frameworkTargets)
            )
            assertEquals(
                expectedBuildType,
                outgoing.attributes.getAttribute(kotlinNativeBuildTypeAttribute)
            )
            assertEquals(
                expectedDisambiguation1Attribute,
                outgoing.attributes.getAttribute(disambiguation1Attribute),
            )
            assertEquals(
                expectedDisambiguation2Attribute,
                outgoing.attributes.getAttribute(disambiguation2Attribute),
            )
        }

        // Check that outgoing framework configurations per target are valid
        run {
            data class ThinFrameworkTestCase(
                val target: String,
                val targetAttribute: String,
                val expectedDisambiguation1Attribute: String?,
                val expectedDisambiguation2Attribute: String?,
            )

            val targets = listOf(
                ThinFrameworkTestCase(
                    "iosArm64", "ios_arm64",
                    expectedDisambiguation1Attribute = "someValue",
                    expectedDisambiguation2Attribute = null,
                ),
                ThinFrameworkTestCase(
                    "iosX64", "ios_x64",
                    expectedDisambiguation1Attribute = null,
                    expectedDisambiguation2Attribute = null,
                ),
            )
            val buildTypes = listOf("release", "debug")
            targets.forEach { testCase ->
                buildTypes.forEach { buildType ->
                    val targetFrameworkConfiguration = frameworkProducer.configurations.getByName("main${buildType.capitalize()}Framework${testCase.target.capitalize()}")
                    targetFrameworkConfiguration.validateOutgoing(
                        expectedBuildType = buildType.toUpperCase(),
                        expectedFrameworkAttributes = setOf(testCase.targetAttribute),
                        expectedFrameworkName = "main.framework",
                        expectedDisambiguation1Attribute = testCase.expectedDisambiguation1Attribute,
                        expectedDisambiguation2Attribute = testCase.expectedDisambiguation2Attribute,
                    )
                }
            }
        }

        // Check that outgoing universal framework configurations are valid
        run {
            val buildTypes = listOf("release", "debug")
            buildTypes.forEach { buildType ->
                val universalFrameworkConfiguration = frameworkProducer.configurations.getByName("main${buildType.capitalize()}FrameworkIosFat")
                universalFrameworkConfiguration.validateOutgoing(
                    expectedBuildType = buildType.toUpperCase(),
                    expectedFrameworkAttributes = setOf("ios_x64", "ios_arm64"),
                    expectedFrameworkName = "main.framework",
                    expectedDisambiguation1Attribute = null,
                    expectedDisambiguation2Attribute = null,
                )
            }
        }

        // Also check that outgoing custom framework configuration is valid
        run {
            val customFrameworkConfiguration = frameworkProducer.configurations.getByName("customReleaseFrameworkIosArm64")
            assertEquals(
                "someValue",
                customFrameworkConfiguration.outgoing.attributes.getAttribute(disambiguation1Attribute)
            )
            assertEquals(
                "someValue2",
                customFrameworkConfiguration.outgoing.attributes.getAttribute(disambiguation2Attribute)
            )
            customFrameworkConfiguration.validateOutgoing(
                expectedBuildType = "RELEASE",
                expectedFrameworkAttributes = setOf("ios_arm64"),
                expectedFrameworkName = "custom.framework",
                expectedDisambiguation1Attribute = "someValue",
                expectedDisambiguation2Attribute = "someValue2",
            )
        }
    }

}