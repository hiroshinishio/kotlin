/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.native

import org.gradle.api.logging.LogLevel
import org.gradle.util.GradleVersion
import org.jetbrains.kotlin.gradle.dsl.NativeCacheKind
import org.jetbrains.kotlin.gradle.testbase.*
import org.junit.jupiter.api.condition.OS
import org.junit.jupiter.api.DisplayName
import kotlin.io.path.appendText
import kotlin.io.path.writeText
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@OsCondition(
    // Disabled on Windows for now.
    supportedOn = [OS.LINUX, OS.MAC],
    enabledOnCI = [OS.LINUX, OS.MAC]
)
@DisplayName("Tests for K/N incremental compilation")
@NativeGradlePluginTests
class NativeIncrementalCompilationIT : KGPBaseTest() {

    override val defaultBuildOptions = super.defaultBuildOptions.copy(
        nativeOptions = BuildOptions.NativeOptions(
            cacheKind = NativeCacheKind.STATIC,
            incremental = true
        )
    )

    @DisplayName("Smoke test")
    @GradleTest
    fun checkIncrementalCacheIsCreated(gradleVersion: GradleVersion) {
        nativeProject("native-incremental-simple", gradleVersion) {
            build("linkDebugExecutableHost") {
                assertDirectoryExists(
                    getFileCache("native-incremental-simple", "src/hostMain/kotlin/main.kt", "")
                )
            }
        }
    }

    @DisplayName("IC works after compilation error (test 1)")
    @GradleTest
    fun compilationError1(gradleVersion: GradleVersion) {
        nativeProject("native-incremental-multifile", gradleVersion) {
            var mainKtCacheModified = 0L
            var fooKtCacheModified = 0L
            val mainKtCache = getFileCache("native-incremental-multifile", "src/hostMain/kotlin/main.kt", "")
            val fooKtCache = getFileCache("native-incremental-multifile", "src/hostMain/kotlin/foo.kt", "")
            build("linkDebugExecutableHost") {
                assertDirectoryExists(mainKtCache)
                assertDirectoryExists(fooKtCache)
                mainKtCacheModified = mainKtCache.toFile().lastModified()
                fooKtCacheModified = fooKtCache.toFile().lastModified()
            }

            val fooKt = kotlinSourcesDir("hostMain").resolve("foo.kt")
            fooKt.writeText("fun foo(): Int = \"zzz\"")

            buildAndFail("linkDebugExecutableHost") {
                assertTasksFailed(":compileKotlinHost")
            }

            fooKt.writeText("fun foo(): Int = 42")

            build("linkDebugExecutableHost") {
                assertDirectoryExists(mainKtCache)
                assertDirectoryExists(fooKtCache)
                assertEquals(mainKtCacheModified, mainKtCache.toFile().lastModified())
                assertEquals(fooKtCacheModified, fooKtCache.toFile().lastModified())
            }
        }
    }

    @DisplayName("IC works after compilation error (test 2)")
    @GradleTest
    fun compilationError2(gradleVersion: GradleVersion) {
        nativeProject("native-incremental-multifile", gradleVersion) {
            var mainKtCacheModified = 0L
            var fooKtCacheModified = 0L
            val mainKtCache = getFileCache("native-incremental-multifile", "src/hostMain/kotlin/main.kt", "")
            val fooKtCache = getFileCache("native-incremental-multifile", "src/hostMain/kotlin/foo.kt", "")
            build("linkDebugExecutableHost") {
                assertDirectoryExists(mainKtCache)
                assertDirectoryExists(fooKtCache)
                mainKtCacheModified = mainKtCache.toFile().lastModified()
                fooKtCacheModified = fooKtCache.toFile().lastModified()
            }

            val fooKt = kotlinSourcesDir("hostMain").resolve("foo.kt")
            fooKt.writeText("fun foo(): Int = \"zzz\"")

            buildAndFail("linkDebugExecutableHost") {
                assertTasksFailed(":compileKotlinHost")
            }

            fooKt.writeText("fun foo(): String = \"zzz\"")

            build("linkDebugExecutableHost") {
                assertDirectoryExists(mainKtCache)
                assertDirectoryExists(fooKtCache)
                assertNotEquals(mainKtCacheModified, mainKtCache.toFile().lastModified())
                assertNotEquals(fooKtCacheModified, fooKtCache.toFile().lastModified())
            }
        }
    }

    @DisplayName("Check dependencies on project level")
    @GradleTest
    fun inProjectDependencies(gradleVersion: GradleVersion) {
        nativeProject("native-incremental-multi-project", gradleVersion, configureSubProjects = true) {
            var fooKtCacheModified = 0L
            var barKtCacheModified = 0L
            var mainKtCacheModified = 0L
            val fooKtCache = getFileCache("program", "MultiProject:library", "library/src/hostMain/kotlin/foo.kt", "")
            val barKtCache = getFileCache("program", "MultiProject:program", "program/src/hostMain/kotlin/bar.kt", "")
            val mainKtCache = getFileCache("program", "MultiProject:program", "program/src/hostMain/kotlin/main.kt", "")
            build("linkDebugExecutableHost") {
                assertDirectoryExists(fooKtCache)
                assertDirectoryExists(barKtCache)
                assertDirectoryExists(mainKtCache)
                fooKtCacheModified = fooKtCache.toFile().lastModified()
                barKtCacheModified = barKtCache.toFile().lastModified()
                mainKtCacheModified = mainKtCache.toFile().lastModified()
            }

            val fooKt = projectPath.resolve("library/src/hostMain/kotlin").resolve("foo.kt")
            fooKt.writeText("fun foo(): Int = 41")

            build("linkDebugExecutableHost") {
                assertDirectoryExists(fooKtCache)
                assertDirectoryExists(barKtCache)
                assertDirectoryExists(mainKtCache)
                assertNotEquals(fooKtCacheModified, fooKtCache.toFile().lastModified())
                assertEquals(barKtCacheModified, barKtCache.toFile().lastModified())
                assertNotEquals(mainKtCacheModified, mainKtCache.toFile().lastModified())
            }
        }
    }

    @DisplayName("Check parallel link tasks execution")
    @GradleTest
    @GradleTestVersions(minVersion = TestVersions.Gradle.G_7_4, maxVersion = TestVersions.Gradle.G_7_4)
    fun parallelLink(gradleVersion: GradleVersion) {
        nativeProject(
            "native-incremental-multi-project-with-tests",
            gradleVersion,
            configureSubProjects = true,
            buildOptions = defaultBuildOptions.copy(configurationCache = true, logLevel = LogLevel.DEBUG)
        ) {
            var fooKtCacheModified = 0L
            var barKtCacheModified = 0L
            var mainKtCacheModified = 0L
            val fooKtCache = getFileCache("program", "MultiProjectWithTests:library", "library/src/hostMain/kotlin/foo.kt", "")
            val barKtCache = getFileCache("program", "MultiProjectWithTests:program", "program/src/hostMain/kotlin/bar.kt", "")
            val mainKtCache = getFileCache("program", "MultiProjectWithTests:program", "program/src/hostMain/kotlin/main.kt", "")

// // TODO(Dmitrii Krasnov): need at leas TestVersions.Gradle.G_8_0 to make it parallel
//            val synchronisationBlock =
//                """
//
//                abstract class CountDownService : BuildService<BuildServiceParameters.None> {
//                    val countDownLatch = CountDownLatch(2)
//                }
//
//                val serviceProvider = gradle.sharedServices.registerIfAbsent("countDownLatchService", CountDownService::class.java) {
//
//                }
//
//                tasks.named("linkDebugExecutableHost").configure {
//                    val serviceProvider = gradle.sharedServices.registerIfAbsent("countDownLatchService", CountDownService::class.java) {
//
//                    }
//                    doFirst {
//
//                        serviceProvider.get().countDownLatch.countDown()
//                        serviceProvider.get().countDownLatch.await()
//                    }
//                }
//                tasks.named("linkDebugTestHost").configure {
//                    val serviceProvider = gradle.sharedServices.registerIfAbsent("countDownLatchService", CountDownService::class.java) {
//
//                    }
//                    doFirst {
//
//                        serviceProvider.get().countDownLatch.countDown()
//                        serviceProvider.get().countDownLatch.await()
//                    }
//                }
//                """.trimIndent()
            // we are adding synchronisation before compileKotlinLinux execution in each subproject for making
            // at least the execution of these tasks parallel
//            subProject("program").buildGradleKts.appendText(synchronisationBlock)

            build(
                "linkDebugExecutableHost", "program:linkDebugTestHost",
            ) {
                assertDirectoryExists(fooKtCache)
                assertDirectoryExists(barKtCache)
                assertDirectoryExists(mainKtCache)
                fooKtCacheModified = fooKtCache.toFile().lastModified()
                barKtCacheModified = barKtCache.toFile().lastModified()
                mainKtCacheModified = mainKtCache.toFile().lastModified()
            }

            repeat(100) {
                val fooKt = projectPath.resolve("library/src/hostMain/kotlin").resolve("foo.kt")
                fooKt.writeText("fun foo(): Int = $it")
                println("I FAILED ON $it")
                build(
                    "linkDebugExecutableHost", "program:linkDebugTestHost",
//                    forceOutput = true
                ) {
                    assertDirectoryExists(fooKtCache)
                    assertDirectoryExists(barKtCache)
                    assertDirectoryExists(mainKtCache)
                    assertNotEquals(fooKtCacheModified, fooKtCache.toFile().lastModified())
                    assertEquals(barKtCacheModified, barKtCache.toFile().lastModified())
                    assertNotEquals(mainKtCacheModified, mainKtCache.toFile().lastModified())
                }
            }
        }

    }
}