/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations

@RequiresOptIn("Index a of parameter is supposed to be automatically tracked, and only few selected places should modify it", level = RequiresOptIn.Level.ERROR)
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class DelicateIrParameterIndexSetter