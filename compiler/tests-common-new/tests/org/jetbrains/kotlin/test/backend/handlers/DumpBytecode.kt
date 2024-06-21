/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.backend.handlers

import org.jetbrains.kotlin.test.model.BinaryArtifacts
import org.jetbrains.kotlin.test.model.TestModule
import org.jetbrains.kotlin.test.services.TestServices
import org.jetbrains.kotlin.test.utils.withExtension

class DumpBytecode(testServices: TestServices) : JvmBinaryArtifactHandler(testServices) {
    override fun processModule(module: TestModule, info: BinaryArtifacts.Jvm) {
        val original = module.files.first().originalFile
        val dumpFile = original.withExtension(".bytecode")
        if (!dumpFile.exists()) {
            dumpFile.createNewFile()
        }
        dumpFile.writeText(info.classFileFactory.createText())
    }

    override fun processAfterAllModules(someAssertionWasFailed: Boolean) {}
}