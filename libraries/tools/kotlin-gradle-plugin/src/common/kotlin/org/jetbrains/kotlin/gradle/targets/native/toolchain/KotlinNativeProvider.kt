/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.targets.native.toolchain

import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.*
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.internal.cc.base.logger
import org.jetbrains.kotlin.gradle.internal.properties.NativeProperties
import org.jetbrains.kotlin.gradle.internal.properties.nativeProperties
import org.jetbrains.kotlin.gradle.plugin.KOTLIN_NATIVE_BUNDLE_CONFIGURATION_NAME
import org.jetbrains.kotlin.gradle.plugin.PropertiesProvider
import org.jetbrains.kotlin.gradle.plugin.PropertiesProvider.Companion.kotlinPropertiesProvider
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.useXcodeMessageStyle
import org.jetbrains.kotlin.gradle.targets.native.KonanPropertiesBuildService
import org.jetbrains.kotlin.gradle.utils.NativeCompilerDownloader
import org.jetbrains.kotlin.gradle.utils.property
import org.jetbrains.kotlin.konan.target.KonanTarget
import java.io.File

/**
 * This is a nested provider for all native tasks
 */
internal class KotlinNativeProvider(
    project: Project,
    konanTargets: Set<KonanTarget>,
    kotlinNativeBundleBuildService: Provider<KotlinNativeBundleBuildService>,
    enableDependenciesDownloading: Boolean = true,
) {
    constructor(
        project: Project,
        konanTarget: KonanTarget,
        kotlinNativeBundleBuildService: Provider<KotlinNativeBundleBuildService>,
    ) : this(project, setOf(konanTarget), kotlinNativeBundleBuildService)

    private val providerFactory = project.providers

    @get:Internal
    val konanDataDir: Provider<String?> = project.nativeProperties.konanDataDir.map {
        @Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
        it!!.absolutePath
    }

    @get:Internal
    val toolchainEnabled: Provider<Boolean> = project.nativeProperties.isToolchainEnabled

    @get:Internal
    val bundleDirectory: Provider<String> = project.nativeProperties.actualNativeHomeDirectory.map { it.absolutePath }

    @get:Internal
    val overriddenKonanHome: Provider<String> = project.nativeProperties.userProvidedNativeHome

    @get:Internal
    val reinstallBundle: Property<Boolean> = project.objects.property(project.kotlinPropertiesProvider.nativeReinstall)

    @get:Input
    internal val kotlinNativeBundleVersion: Provider<String> = project.providers.of(NativeVersionValueSource::class.java) {
        it.parameters.bundleDirectory.set(bundleDirectory)
        it.parameters.reinstallBundle.set(reinstallBundle)
        it.parameters.overriddenKonanHome.set(overriddenKonanHome)
        it.parameters.dependencyNameWithOsAndVersion.set(NativeCompilerDownloader.getDependencyNameWithOsAndVersion(project))
        it.parameters.kotlinNativeBundleBuildService.set(kotlinNativeBundleBuildService)
        it.parameters.toolchainEnabled.set(toolchainEnabled)
        it.parameters.objectFactory.set(project.objects)
        it.parameters.konanTargets.set(konanTargets)
        it.parameters.propertiesProvider.set(PropertiesProvider(project))
        it.parameters.kotlinPropertiesProvider.set(project.kotlinPropertiesProvider)
        it.parameters.useXcodeMessageStyle.set(project.useXcodeMessageStyle)
        it.parameters.nativeProperties.set(project.nativeProperties)
        it.parameters.kotlinNativeCompilerConfiguration.set(kotlinNativeCompilerConfiguration)
    }

    internal abstract class NativeVersionValueSource :
        ValueSource<String, NativeVersionValueSource.Params> {

        interface Params : ValueSourceParameters {
            val bundleDirectory: Property<String>
            val reinstallBundle: Property<Boolean>
            val overriddenKonanHome: Property<String>
            val dependencyNameWithOsAndVersion: Property<String>
            val kotlinNativeBundleBuildService: Property<KotlinNativeBundleBuildService>
            val toolchainEnabled: Property<Boolean>
            val objectFactory: Property<ObjectFactory>
            val konanTargets: ListProperty<KonanTarget>
            val propertiesProvider: Property<PropertiesProvider>//PropertiesProvider(project
            val kotlinPropertiesProvider: Property<PropertiesProvider>//project.kotlinPropertiesProvider
            val konanPropertiesService: Provider<KonanPropertiesBuildService>
            val useXcodeMessageStyle: Property<Boolean>
            val nativeProperties: Property<NativeProperties>
            val kotlinNativeCompilerConfiguration: Property<ConfigurableFileCollection>
        }

        override fun obtain(): String {
            val kotlinNativeVersion =
                if (parameters.overriddenKonanHome.isPresent)
                    parameters.overriddenKonanHome.get()
                else
                    parameters.dependencyNameWithOsAndVersion.get()
            if (parameters.toolchainEnabled.get()) {
                parameters.kotlinNativeBundleBuildService.get().prepareKotlinNativeBundle(
                    logger,
                    parameters.kotlinNativeCompilerConfiguration.get(),
                    kotlinNativeVersion,
                    File(parameters.bundleDirectory.get()),
                    parameters.reinstallBundle.get(),
                    parameters.konanTargets.get().toSet(),
                    parameters.overriddenKonanHome.get(),
                    parameters.objectFactory.get(),
                    parameters.propertiesProvider.get(),//PropertiesProvider(project)
                    parameters.kotlinPropertiesProvider.get(),//project.kotlinPropertiesProvider,
                    parameters.useXcodeMessageStyle,
                    parameters.nativeProperties.get(),
                )
            }
            return kotlinNativeVersion
        }
    }

    @get:Input
    val kotlinNativeDependencies: Provider<Set<String>> =
        kotlinNativeBundleVersion
            .zip(bundleDirectory) { _, bundleDir ->
                if (toolchainEnabled.get() && enableDependenciesDownloading) {
                    kotlinNativeBundleBuildService.get()
                        .downloadNativeDependencies(
                            File(bundleDir),
                            konanDataDir.orNull,
                            konanTargets,
                            project.logger
                        )
                } else {
                    emptySet()
                }
            }

    // Gradle tries to evaluate this val during configuration cache,
    // which lead to resolving configuration, even if k/n bundle is in konan home directory.
    @Transient
    private val kotlinNativeCompilerConfiguration: ConfigurableFileCollection = project.objects.fileCollection()
        .from(
            // without enabled there is no configuration with this name, so we should return empty provider to support configuration cache
            toolchainEnabled.flatMap { isEnabled ->
                if (isEnabled) {
                    project.configurations.named(
                        KOTLIN_NATIVE_BUNDLE_CONFIGURATION_NAME
                    )
                } else {
                    providerFactory.provider { null }
                }
            }
        )
}
