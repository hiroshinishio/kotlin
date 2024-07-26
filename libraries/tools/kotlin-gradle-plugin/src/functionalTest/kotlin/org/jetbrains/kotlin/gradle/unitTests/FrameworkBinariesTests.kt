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
    fun `consumable framework configurations - have correct outgoing framework artifact and attributes`() {
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
            expectedAttributes: Set<String>,
            expectedBuildType: String,
            expectedFrameworkName: String,
        ) {
            val framework = outgoing.artifacts.single()
            assertEquals(
                expectedFrameworkName,
                framework.file.name,
            )
            assertEquals(
                expectedAttributes,
                outgoing.attributes.getAttribute(frameworkTargets)
            )
            assertEquals(
                expectedBuildType,
                outgoing.attributes.getAttribute(kotlinNativeBuildTypeAttribute)
            )
        }

        run {
            val targets = listOf("iosArm64" to "ios_arm64", "iosX64" to "ios_x64")
            val buildTypes = listOf("release", "debug")
            targets.forEach { (name, target) ->
                buildTypes.forEach { buildType ->
                    val targetFrameworkConfiguration = frameworkProducer.configurations.getByName("main${buildType.capitalize()}Framework${name.capitalize()}")
                    targetFrameworkConfiguration.validateOutgoing(setOf(target), buildType.toUpperCase(), "main.framework")
                }
            }
        }

        run {
            val buildTypes = listOf("release", "debug")
            buildTypes.forEach { buildType ->
                val universalFrameworkConfiguration = frameworkProducer.configurations.getByName("main${buildType.capitalize()}FrameworkIosFat")
                universalFrameworkConfiguration.validateOutgoing(setOf("ios_x64", "ios_arm64"), buildType.toUpperCase(), "main.framework")
            }
        }

        run {
            val customFrameworkConfiguration = frameworkProducer.configurations.getByName("customReleaseFrameworkIosArm64")
            val attr1Value = customFrameworkConfiguration.attributes.getAttribute(disambiguation1Attribute)
            if (attr1Value != "someValue") {
                throw IllegalStateException("${disambiguation1Attribute.name} has incorrect value. Expected: \"someValue\", actual: \"$attr1Value\"")
            }
            val attr2Value = customFrameworkConfiguration.attributes.getAttribute(disambiguation2Attribute)
            if (attr2Value != "someValue2") {
                throw IllegalStateException("${disambiguation2Attribute.name} has incorrect value. Expected: \"someValue2\", actual: \"$attr2Value\"")
            }
            customFrameworkConfiguration.validateOutgoing(setOf("ios_arm64"), "RELEASE", "custom.framework")
        }
    }

}