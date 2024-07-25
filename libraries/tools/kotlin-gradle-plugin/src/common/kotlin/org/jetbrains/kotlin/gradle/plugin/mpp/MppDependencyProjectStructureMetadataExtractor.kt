/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import org.gradle.api.artifacts.component.ComponentIdentifier
import java.io.File
import java.io.InputStream
import java.util.zip.ZipFile
import javax.xml.parsers.DocumentBuilderFactory

sealed class MppDependencyProjectStructureMetadataExtractor {
    abstract fun getProjectStructureMetadata(): KotlinProjectStructureMetadata?

    companion object Factory
}

internal abstract class AbstractProjectMppDependencyProjectStructureMetadataExtractor(
    val moduleId: ComponentIdentifier,
) : MppDependencyProjectStructureMetadataExtractor()

@Deprecated(
    message = "This class is not compatible with gradle project Isolation",
    replaceWith = ReplaceWith("ProjectMppDependencyProjectStructureMetadataExtractor")
)
internal class ProjectMppDependencyProjectStructureMetadataExtractorDeprecated(
    moduleId: ComponentIdentifier,
    private val projectStructureMetadataProvider: () -> KotlinProjectStructureMetadata?,
) : AbstractProjectMppDependencyProjectStructureMetadataExtractor(moduleId = moduleId) {

    override fun getProjectStructureMetadata(): KotlinProjectStructureMetadata? = projectStructureMetadataProvider()
}

internal class ProjectMppDependencyProjectStructureMetadataExtractor(
    moduleId: ComponentIdentifier,
    private val projectStructureMetadataFile: File?,
) : AbstractProjectMppDependencyProjectStructureMetadataExtractor(moduleId) {

    override fun getProjectStructureMetadata(): KotlinProjectStructureMetadata? {
        return projectStructureMetadataFile?.let {
            parseKotlinSourceSetMetadataFromJson(projectStructureMetadataFile.readText())
        }
    }
}

internal open class JarMppDependencyProjectStructureMetadataExtractor(
    val primaryArtifactFile: File,
) : MppDependencyProjectStructureMetadataExtractor() {

    private fun parseJsonProjectStructureMetadata(input: InputStream) =
        parseKotlinSourceSetMetadataFromJson(input.reader().readText())

    private fun parseXmlProjectStructureMetadata(input: InputStream) =
        parseKotlinSourceSetMetadataFromXml(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input))

    override fun getProjectStructureMetadata(): KotlinProjectStructureMetadata? {
        return ZipFile(primaryArtifactFile).use { zip ->
            val (metadata, parseFunction) =
                zip.getEntry("META-INF/$MULTIPLATFORM_PROJECT_METADATA_JSON_FILE_NAME")?.to(::parseJsonProjectStructureMetadata)
                    ?: zip.getEntry("META-INF/$MULTIPLATFORM_PROJECT_METADATA_FILE_NAME")?.to(::parseXmlProjectStructureMetadata)
                    ?: return null

            zip.getInputStream(metadata).use(parseFunction)
        }
    }
}

internal class IncludedBuildMppDependencyProjectStructureMetadataExtractor(
    primaryArtifact: File,
    private val projectStructureMetadataProvider: () -> KotlinProjectStructureMetadata?,
    private val projectStructureMetadataFile: File? = null,
) : JarMppDependencyProjectStructureMetadataExtractor(primaryArtifact) {
    override fun getProjectStructureMetadata(): KotlinProjectStructureMetadata? =
        projectStructureMetadataFile?.let {
            parseKotlinSourceSetMetadataFromJson(projectStructureMetadataFile.readText())
        } ?: projectStructureMetadataProvider()
}
