/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp.internal

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type

internal object MetadataJsonSerialisationTool {
    private val gson: Gson by lazy {
        GsonBuilder()
            .registerTypeHierarchyAdapter(File::class.java, FileAdapter)
            .setPrettyPrinting()
            .create()
    }

    internal fun toJson(metadataOutputsBySourceSet: Map<String, File>): String = gson.toJson(metadataOutputsBySourceSet)

    internal fun fromJson(jsonString: String): Map<String, File?> {
        val listType = object : TypeToken<Map<String, File?>>() {}.type
        return gson.fromJson(jsonString, listType)
    }

    private object FileAdapter : JsonSerializer<File>, JsonDeserializer<File> {
        override fun serialize(src: File, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
            return JsonPrimitive(src.absolutePath)
        }

        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): File? {
            return json?.asString?.let { absolutePath -> File(absolutePath) }
        }
    }
}

