/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.attributes.Attribute
import org.gradle.api.file.FileCollection
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.awaitMetadataTarget
import org.jetbrains.kotlin.gradle.dsl.metadataTarget
import org.jetbrains.kotlin.gradle.dsl.multiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.multiplatformExtensionOrNull
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginLifecycle.Stage.AfterEvaluateBuildscript
import org.jetbrains.kotlin.gradle.plugin.KotlinProjectSetupAction
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.await
import org.jetbrains.kotlin.gradle.plugin.launch
import org.jetbrains.kotlin.gradle.plugin.mpp.MetadataDependencyResolution.ChooseVisibleSourceSets.MetadataProvider.ProjectMetadataProvider
import org.jetbrains.kotlin.gradle.targets.metadata.awaitMetadataCompilationsCreated
import org.jetbrains.kotlin.gradle.targets.metadata.locateOrRegisterGenerateProjectStructureMetadataTask
import org.jetbrains.kotlin.gradle.utils.setAttribute

private typealias SourceSetName = String

internal val sourceSetsMetadataAttribute =
    Attribute.of("org.jetbrains.kotlin.kmp.internal.sourceSetsMetadata", Boolean::class.javaObjectType)

internal fun ProjectMetadataProvider(
    sourceSetMetadataOutputs: Map<SourceSetName, SourceSetMetadataOutputs>,
): ProjectMetadataProvider {
    return ProjectMetadataProviderImpl(sourceSetMetadataOutputs)
}

internal class SourceSetMetadataOutputs(
    val metadata: FileCollection?,
)

private class ProjectMetadataProviderImpl(
    private val sourceSetMetadataOutputs: Map<SourceSetName, SourceSetMetadataOutputs>,
) : ProjectMetadataProvider() {

    override fun getSourceSetCompiledMetadata(sourceSetName: String): FileCollection? {
        val metadataOutputs = sourceSetMetadataOutputs[sourceSetName] ?: return null
        return metadataOutputs.metadata
    }

}

internal suspend fun Project.collectSourceSetMetadataOutputs(): Map<SourceSetName, SourceSetMetadataOutputs> {
    /*
    Usually we can safely access the kotlin project extension inside a coroutine, as the Kotlin Gradle Plugin is
    the only entity that could launch coroutines (hence the extension being available).

    However, this code is crossing project boundaries here:
    There is _some_ Kotlin Gradle plugin that requests the 'ProjectData' being collected for
    *all* projects (breaking project isolation).

    Therefore, it might happen that the Kotlin Plugin was not even applied at this point, when this
    coroutine starts executing. We therefore await the wait for after the buildscript was evaluated to check
    if the multiplatformExtension is present.
     */
    AfterEvaluateBuildscript.await()
    val multiplatformExtension = multiplatformExtensionOrNull ?: return emptyMap()

    val sourceSetMetadata = multiplatformExtension.sourceSetsMetadataOutputs()

    return sourceSetMetadata.mapValues { (_, metadata) ->
        SourceSetMetadataOutputs(metadata = metadata)
    }.mapKeys { it.key.name }
}

internal val MetadataApiElementsSecondaryVariantsSetupAction = KotlinProjectSetupAction {
    project.launch {
        val multiplatformExtension = project.multiplatformExtension

        val metadataApiConfiguration =
            project.configurations.getByName(multiplatformExtension.awaitMetadataTarget().apiElementsConfigurationName)

        metadataApiConfiguration.addSecondaryOutgoingVariant(project)
    }
}

internal fun GenerateProjectStructureMetadata.addMetadataSourceSetsToOutput(project: Project) {
    val generateTask = this
    project.launch {
        val sourceSetOutputs =
            project.multiplatformExtension.kotlinMetadataCompilations()
                .map {
                    GenerateProjectStructureMetadata.SourceSetOutputs(
                        sourceSetName = it.defaultSourceSet.name,
                        metadataOutput = project.provider { it.output.classesDirs.singleFile }
                    )
                }
        generateTask.sourceSetOutputs.set(sourceSetOutputs)
    }
}

private fun Configuration.addSecondaryOutgoingVariant(project: Project) {

    val apiClassesVariant = outgoing.variants.maybeCreate("sourceSetsSecondaryVariant")

    apiClassesVariant.attributes.setAttribute(sourceSetsMetadataAttribute, true)

    apiClassesVariant.artifact(project.locateOrRegisterGenerateProjectStructureMetadataTask().map { it.sourceSetMetadataOutputsFile })

}

private suspend fun KotlinMultiplatformExtension.sourceSetsMetadataOutputs(): Map<KotlinSourceSet, FileCollection?> {
    return kotlinMetadataCompilations().associate { it.defaultSourceSet to it.output.classesDirs }
}

private suspend fun KotlinMultiplatformExtension.kotlinMetadataCompilations() = metadataTarget
    .awaitMetadataCompilationsCreated()
    // TODO: KT-62332/Stop-Creating-legacy-metadata-compilation-with-name-main
    .filter { if (it is KotlinCommonCompilation) it.isKlibCompilation else true }
