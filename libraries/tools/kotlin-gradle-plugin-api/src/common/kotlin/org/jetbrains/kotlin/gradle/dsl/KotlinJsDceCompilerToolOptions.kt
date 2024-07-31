/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.dsl

/**
 * Options for the Kotlin JavaScript dead code elimination tool.
 */
@Deprecated(
    "The Kotlin/JS dead code elimination tool is obsolete",
    level = DeprecationLevel.ERROR,
)
interface KotlinJsDceCompilerToolOptions : KotlinCommonCompilerToolOptions {

    /**
     * Development mode: don't strip out any code, just copy dependencies.
     *
     * Default value: false
     */
    @get:org.gradle.api.tasks.Input
    val devMode: org.gradle.api.provider.Property<Boolean>
}
