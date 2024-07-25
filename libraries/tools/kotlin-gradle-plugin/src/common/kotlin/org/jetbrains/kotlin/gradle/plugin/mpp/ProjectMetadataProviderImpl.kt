/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.component.ComponentIdentifier
import org.gradle.api.artifacts.type.ArtifactTypeDefinition
import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.LibraryElements
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.FileCollection
import org.gradle.api.model.ObjectFactory
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginLifecycle.Stage.AfterEvaluateBuildscript
import org.jetbrains.kotlin.gradle.plugin.KotlinProjectSetupAction
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.await
import org.jetbrains.kotlin.gradle.plugin.launch
import org.jetbrains.kotlin.gradle.plugin.mpp.MetadataDependencyResolution.ChooseVisibleSourceSets.MetadataProvider.ProjectMetadataProvider
import org.jetbrains.kotlin.gradle.plugin.sources.disambiguateName
import org.jetbrains.kotlin.gradle.targets.metadata.awaitMetadataCompilationsCreated
import org.jetbrains.kotlin.gradle.utils.LenientFuture
import org.jetbrains.kotlin.gradle.utils.named
import org.jetbrains.kotlin.gradle.utils.setAttribute
import org.jetbrains.kotlin.gradle.utils.whenEvaluated

private typealias SourceSetName = String

private val sourceSetTypeAttribute = Attribute.of("org.jetbrains.kotlin.internal.kmp.sourceSetType", String::class.javaObjectType)

internal fun ProjectMetadataProvider(
    sourceSetMetadataOutputs: LenientFuture<Map<String, SourceSetMetadataOutputs>>?,
    moduleId: ComponentIdentifier,
    resolvableMetadataConfiguration: Configuration,
    kmpProjectIsolationEnabled: Boolean,
    objectFactory: ObjectFactory,
): ProjectMetadataProvider {
    return ProjectMetadataProviderImpl(
        sourceSetMetadataOutputs,
        moduleId,
        resolvableMetadataConfiguration,
        kmpProjectIsolationEnabled,
        objectFactory
    )
}

internal class SourceSetMetadataOutputs(
    val metadata: FileCollection?,
)

private class ProjectMetadataProviderImpl(
    private val sourceSetMetadataOutputs: LenientFuture<Map<String, SourceSetMetadataOutputs>>?,
    private val moduleId: ComponentIdentifier,
    private val resolvableMetadataConfiguration: Configuration,
    private val kmpProjectIsolationEnabled: Boolean,
    private val objectFactory: ObjectFactory,
) : ProjectMetadataProvider() {

    override fun getSourceSetCompiledMetadata(sourceSetName: String): FileCollection? {

        if (kmpProjectIsolationEnabled) {
            val artifactPreview = resolvableMetadataConfiguration.incoming.artifactView { artifactView ->
                artifactView.componentFilter { componentId -> componentId == moduleId }
                artifactView.isLenient = true
                artifactView.attributes.setAttribute(
                    LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE,
                    objectFactory.named(LibraryElements.CLASSES_AND_RESOURCES)
                )
                artifactView.attributes.setAttribute(sourceSetTypeAttribute, sourceSetName)
            }
            val artifacts = artifactPreview.artifacts
            val artifactFiles = artifacts.artifactFiles
            return artifactFiles
        } else {
            val sourceSetMetadataOutputs = sourceSetMetadataOutputs?.getOrThrow() ?: error("Unexpected project path '${moduleId}'")
            val metadataOutputs = sourceSetMetadataOutputs[sourceSetName] ?: return null
            return metadataOutputs.metadata
        }
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
        val sourceSetsMetadataOutputsMap = multiplatformExtension.sourceSetsMetadataOutputs()
        val metadataApiConfiguration =
            project.configurations.getByName(multiplatformExtension.awaitMetadataTarget().apiElementsConfigurationName)
        for (metadataOutputBySourceSet in sourceSetsMetadataOutputsMap) {
            metadataApiConfiguration.addSecondaryOutgoingVariant(project, metadataOutputBySourceSet.key, metadataOutputBySourceSet.value)
        }
    }
}

private fun Configuration.addSecondaryOutgoingVariant(
    project: Project,
    kotlinSourceSet: KotlinSourceSet,
    sourceSetClassesDir: ConfigurableFileCollection,
) {
    val apiClassesVariant = outgoing.variants.maybeCreate(kotlinSourceSet.disambiguateName("secondaryVariant"))
    apiClassesVariant.attributes.setAttribute(
        LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE,
        project.objects.named(LibraryElements.CLASSES_AND_RESOURCES)
    )
    apiClassesVariant.attributes.setAttribute(sourceSetTypeAttribute, kotlinSourceSet.name)
    project.whenEvaluated {
        apiClassesVariant.artifact(project.provider { sourceSetClassesDir.singleFile }) {
            it.type = ArtifactTypeDefinition.DIRECTORY_TYPE
            it.builtBy(sourceSetClassesDir.buildDependencies)
        }
    }
}

private suspend fun KotlinMultiplatformExtension.sourceSetsMetadataOutputs(): Map<KotlinSourceSet, ConfigurableFileCollection> {
    return metadataTarget
        .awaitMetadataCompilationsCreated()
        // TODO: KT-62332/Stop-Creating-legacy-metadata-compilation-with-name-main
        .filter { if (it is KotlinCommonCompilation) it.isKlibCompilation else true }
        .associate { it.defaultSourceSet to it.output.classesDirs }
}