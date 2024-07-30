/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import com.google.gson.GsonBuilder
import org.gradle.api.DefaultTask
import org.gradle.api.file.ProjectLayout
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.*
import org.gradle.work.DisableCachingByDefault
import java.io.File
import javax.inject.Inject

internal const val SOURCE_SET_METADATA = "source-sets-metadata.json"
internal const val MULTIPLATFORM_PROJECT_METADATA_FILE_NAME = "kotlin-project-structure-metadata.xml"
internal const val MULTIPLATFORM_PROJECT_METADATA_JSON_FILE_NAME = "kotlin-project-structure-metadata.json"
internal const val EMPTY_PROJECT_STRUCTURE_METADATA_FILE_NAME = "empty-kotlin-project-structure-metadata"

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
    internal val sourceSetMetadataOutputsFile: Provider<RegularFile> = projectLayout.buildDirectory.file(
        "internal/kmp/$SOURCE_SET_METADATA"
    )


    @get:Nested
    internal abstract val sourceSetOutputs: ListProperty<SourceSetOutputs>

    @TaskAction
    fun generateMetadataXml() {
        resultFile.parentFile.mkdirs()

        val resultString = kotlinProjectStructureMetadata.toJson()
        resultFile.writeText(resultString)

        sourceSetMetadataOutputsFile.get().asFile.writeText(metadataOutputsBySourceSet.toJson())
    }

    internal data class SourceSetOutputs(
        @get:Input
        val sourceSetName: String,
        @get:Input
        @get:Optional
        val metadataOutput: Provider<File>,
    )

    private val metadataOutputsBySourceSet
        get() = sourceSetOutputs.get()
            .associate { it.sourceSetName to it.metadataOutput.get().absolutePath }

    private fun Map<String, String>.toJson(): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(this@toJson)
    }
}




