/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.file.ProjectLayout
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.*
import org.gradle.work.DisableCachingByDefault
import java.io.File
import javax.inject.Inject

@DisableCachingByDefault
abstract class GenerateProjectStructureMetadata : DefaultTask() {

    @get:Inject
    abstract internal val projectLayout: ProjectLayout

    @get:Internal
    internal lateinit var lazyKotlinProjectStructureMetadata: Lazy<KotlinProjectStructureMetadata>

    @get:Nested
    internal val kotlinProjectStructureMetadata: KotlinProjectStructureMetadata
        get() = lazyKotlinProjectStructureMetadata.value

    @get:OutputFile
    val resultFile: File
        get() = projectLayout.buildDirectory.file(
            "kotlinProjectStructureMetadata/$MULTIPLATFORM_PROJECT_METADATA_JSON_FILE_NAME"
        ).get().asFile

    @get:OutputFile
    internal val sourceSetMetadataOutputsFile: File
        get() = projectLayout.buildDirectory.file(
            "internal/$SOURCE_SET_METADATA"
        ).get().asFile


    internal data class SourceSetOutputs(
        @get:Input
        val sourceSetName: String,
        @get:Input
        @get:Optional
        val metadataOutput: Provider<File>
    )

    @get:Nested
    internal abstract val sourceSetOutputs: ListProperty<SourceSetOutputs>

    @TaskAction
    fun generateMetadataXml() {
        resultFile.parentFile.mkdirs()
        val resultString = kotlinProjectStructureMetadata.toJson()
        resultFile.writeText(resultString)

        val sourceSetMetadataOutputsFileContent = sourceSetOutputs.get().joinToString("\n") {
            "${it.sourceSetName} => ${it.metadataOutput.get().absolutePath}"
        }
        sourceSetMetadataOutputsFile.writeText(sourceSetMetadataOutputsFileContent)
    }
}

internal const val SOURCE_SET_METADATA = "sourceSetMetadata.txt"
internal const val MULTIPLATFORM_PROJECT_METADATA_FILE_NAME = "kotlin-project-structure-metadata.xml"
internal const val MULTIPLATFORM_PROJECT_METADATA_JSON_FILE_NAME = "kotlin-project-structure-metadata.json"
internal const val EMPTY_PROJECT_STRUCTURE_METADATA_FILE_NAME = "empty-kotlin-project-structure-metadata"
