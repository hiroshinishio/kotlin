/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.testbase

import org.gradle.api.Project
import kotlin.io.path.appendText
import kotlin.io.path.readText

interface BuildGradleKtsInjection {
    fun inject(project: Project)
}

private const val marker = "// MARKER: BuildGradleKtsInjections Enabled"

fun TestProject.enableBuildGradleKtsInjectionsIfNecessary() {
    val injectionClasses = System.getProperty("buildGradleKtsInjectionsClasspath")
        ?: error("Missing required system property 'buildGradleKtsInjectionsClasspath'")

    if (buildGradleKts.readText().contains(marker)) return

    buildGradleKts.modify {
        it.insertBlockToBuildScriptAfterPluginsAndImports("""
            $marker
            buildscript {
                val files = project.files("$injectionClasses")
                dependencies {
                    classpath(files)
                }
            }            
        """.trimIndent())
    }
}

fun invokeBuildGradleKtsInjection(project: Project, fqn: String) {
    val cl = object {}.javaClass.classLoader
    val injectionClass = cl.loadClass(fqn)
    val injection = injectionClass.getDeclaredConstructor().newInstance() as BuildGradleKtsInjection
    injection.inject(project)
}

@DslMarker
annotation class BuildGradleKtsInjectionScope

@BuildGradleKtsInjectionScope
class BuildGradleKtsInjectionContext(
    val project: Project
) {
    val kotlinMultiplatform = project.extensions.getByName("kotlin") as org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
}

inline fun TestProject.buildGradleKtsInjection(crossinline code: BuildGradleKtsInjectionContext.() -> Unit) {
    enableBuildGradleKtsInjectionsIfNecessary()

    // it is important to create an anonymous object here, so that we can invoke this via reflection in buildscripts
    // because regular lambdas get executed through ivokedynamic logic. i.e. classes created on fly.
    val injection = object : BuildGradleKtsInjection {
        override fun inject(project: Project) {
            val scope = BuildGradleKtsInjectionContext(project)
            scope.code()
        }
    }
    // check that injection has expected lambda "shape". i.e. no captured variables
    val clazz = injection.javaClass
    val primaryConstructor = clazz.declaredConstructors.singleOrNull()
        ?: error("$clazz has multiple constructors. Check the way how buildGradleKts {} is invoked. It should not capture any variables.")
    if (primaryConstructor.parameterCount != 0) error("$clazz can't have any parameters. Please check that buildGradleKts{} uses only Gradle's Project object")
    val escapedFqn = injection.javaClass.name.replace("$", "\\\$")
    buildGradleKts.appendText("\norg.jetbrains.kotlin.gradle.testbase.invokeBuildGradleKtsInjection(project, \"$escapedFqn\")\n")
}