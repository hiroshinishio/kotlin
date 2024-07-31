/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.api

enum class DiagnosticCheckerFilter(val runCommonCheckers: Boolean, val runExtraCheckers: Boolean) {
    ONLY_COMMON_CHECKERS(runCommonCheckers = true, runExtraCheckers = false),
    ONLY_EXTRA_CHECKERS(runCommonCheckers = false, runExtraCheckers = true),
    EXTENDED_AND_COMMON_CHECKERS(runCommonCheckers = true, runExtraCheckers = true),
}