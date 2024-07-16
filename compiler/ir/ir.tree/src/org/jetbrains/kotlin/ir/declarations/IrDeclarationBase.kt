/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations

import org.jetbrains.kotlin.ir.IrElementBase

/**
 * Unlike other [IrElement]s, this class is only an implementation detail, introduced
 * for convenience and performance.
 * As such, it is not autogenerated, but needs to be kept in sync with the entry in
 * tree generator: [org.jetbrains.kotlin.ir.generator.IrTree.declarationBase]
 */
abstract class IrDeclarationBase : IrElementBase(), IrDeclaration
