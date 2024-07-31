/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp.apple.swiftexport.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.artifacts.component.ModuleComponentIdentifier
import org.gradle.api.artifacts.result.ResolvedComponentResult
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.FileSystemOperations
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.api.provider.SetProperty
import org.gradle.api.tasks.*
import org.gradle.work.DisableCachingByDefault
import org.gradle.workers.WorkerExecutor
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.swiftexport.SwiftExportedModuleVersionMetadata
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.swiftexport.internal.SwiftExportTaskParameters
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.swiftexport.internal.SwiftExportAction
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.swiftexport.internal.SwiftExportedModule
import org.jetbrains.kotlin.gradle.targets.native.toolchain.KotlinNativeProvider
import org.jetbrains.kotlin.gradle.utils.LazyResolvedConfiguration
import org.jetbrains.kotlin.gradle.utils.dashSeparatedToUpperCamelCase
import org.jetbrains.kotlin.gradle.utils.getFile
import org.jetbrains.kotlin.konan.target.Distribution
import java.io.File
import javax.inject.Inject

@DisableCachingByDefault(because = "Swift Export is experimental, so no caching for now")
internal abstract class SwiftExportTask @Inject constructor(
    private val workerExecutor: WorkerExecutor,
    private val fileSystem: FileSystemOperations,
) : DefaultTask() {

    internal abstract class ModuleInput {
        @get:Input
        abstract val moduleName: Property<String>

        @get:Input
        @get:Optional
        abstract val flattenPackage: Property<String>

        @get:InputFiles
        @get:PathSensitive(PathSensitivity.RELATIVE)
        abstract val artifact: RegularFileProperty
    }

    @get:Internal
    abstract val configuration: Property<LazyResolvedConfiguration>

    @get:Nested
    abstract val mainModuleInput: ModuleInput

    @get:Nested
    abstract val exportedModules: SetProperty<SwiftExportedModuleVersionMetadata>

    @get:Nested
    abstract val kotlinNativeProvider: Property<KotlinNativeProvider>

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val swiftExportClasspath: ConfigurableFileCollection

    @get:Nested
    abstract val parameters: SwiftExportTaskParameters

    @TaskAction
    fun run() {
        cleanup()

        val swiftExportQueue = workerExecutor.classLoaderIsolation { workerSpec ->
            workerSpec.classpath.from(swiftExportClasspath)
        }

        swiftExportQueue.submit(SwiftExportAction::class.java) { workParameters ->
            workParameters.bridgeModuleName.set(parameters.bridgeModuleName)
            workParameters.outputPath.set(parameters.outputPath)
            workParameters.stableDeclarationsOrder.set(parameters.stableDeclarationsOrder)
            workParameters.swiftModules.set(swiftExportedModules())
            workParameters.swiftModulesFile.set(parameters.swiftModulesFile)

            workParameters.konanDistribution.set(
                kotlinNativeProvider.flatMap {
                    it.bundleDirectory
                }.map {
                    Distribution(it.asFile.canonicalPath)
                }
            )
        }
    }

    private fun cleanup() {
        try {
            fileSystem.delete {
                it.delete(parameters.outputPath)
            }
        } catch (e: Exception) {
            logger.warn("Can't delete Swift Export output folder", e)
        }
    }

    internal fun swiftExportedModules(): Provider<List<SwiftExportedModule>> {
        return configuration.map { configuration ->
            configuration.swiftExportedModules(exportedModules.get())
        }.map { modules ->
            modules.toMutableList().apply {
                add(
                    SwiftExportedModuleImp(
                        mainModuleInput.moduleName.get(),
                        mainModuleInput.flattenPackage.orNull,
                        mainModuleInput.artifact.getFile()
                    )
                )
            }
        }
    }
}

private val File.isCinteropKlib get() = extension == "klib" && nameWithoutExtension.contains("cinterop-interop")

internal fun Collection<File>.filterNotCinteropKlibs(): List<File> = filterNot(File::isCinteropKlib)

private fun LazyResolvedConfiguration.swiftExportedModules(exportedModules: Set<SwiftExportedModuleVersionMetadata>): List<SwiftExportedModule> {
    return allResolvedDependencies.asSequence().filterNot { dependencyResult ->
        dependencyResult.resolvedVariant.owner.let { id -> id is ModuleComponentIdentifier && id.module == "kotlin-stdlib" }
    }.map { it.selected }.map { component ->
        val dependencyArtifacts = getArtifacts(component)
            .map { it.file }
            .filterNotCinteropKlibs()

        if (dependencyArtifacts.isEmpty() || dependencyArtifacts.size > 1) {
            throw AssertionError(
                "Component $component ${
                    if (dependencyArtifacts.isEmpty())
                        "doesn't have suitable artifacts"
                    else
                        "has too many artifacts: $dependencyArtifacts"
                }"
            )
        }

        Pair(component, dependencyArtifacts.single())
    }.distinctBy { (_, artifact) ->
        artifact
    }.map { (component, artifact) ->
        findAndCreateSwiftExportedModule(exportedModules, component, artifact)
    }.toList()
}

private fun findAndCreateSwiftExportedModule(
    exportedModules: Set<SwiftExportedModuleVersionMetadata>,
    resolvedComponent: ResolvedComponentResult,
    artifact: File,
): SwiftExportedModule {
    val resolvedModule = resolvedComponent.moduleVersion
        ?: throw AssertionError("Missing module version for component: $resolvedComponent")

    val module = exportedModules.single {
        resolvedModule.name == it.moduleVersion.name &&
                resolvedModule.group == it.moduleVersion.group &&
                resolvedModule.version == it.moduleVersion.version
    }

    return SwiftExportedModuleImp(
        module.moduleName.orElse(dashSeparatedToUpperCamelCase(module.moduleVersion.name)).get(),
        module.flattenPackage.orNull,
        artifact
    )
}

private data class SwiftExportedModuleImp(
    override val moduleName: String,
    override val flattenPackage: String?,
    override val artifact: File,
) : SwiftExportedModule