/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
package org.jetbrains.kotlin.name

import java.util.regex.Pattern

/**
 * Like [FqName] but allows '<' and '>' characters in name.
 */
class FqNameUnsafe {
    private val fqName: String

    // cache
    @Transient
    private var safe: FqName? = null

    @Transient
    private var parent: FqNameUnsafe? = null

    @Transient
    private var shortName: Name? = null

    internal constructor(fqName: String, safe: FqName) {
        this.fqName = fqName
        this.safe = safe
    }

    constructor(fqName: String) {
        this.fqName = fqName
    }

    private constructor(fqName: String, parent: FqNameUnsafe, shortName: Name) {
        this.fqName = fqName
        this.parent = parent
        this.shortName = shortName
    }

    private fun compute() {
        val lastDot = fqName.lastIndexOf('.')
        if (lastDot >= 0) {
            shortName = Name.guessByFirstCharacter(fqName.substring(lastDot + 1))
            parent = FqNameUnsafe(fqName.substring(0, lastDot))
        } else {
            shortName = Name.guessByFirstCharacter(fqName)
            parent = FqName.ROOT.toUnsafe()
        }
    }

    fun asString(): String {
        return fqName
    }

    fun isSafe(): Boolean {
        return safe != null || asString().indexOf('<') < 0
    }

    fun toSafe(): FqName {
        safe?.let {
            return it
        }

        safe = FqName(this)
        return safe!!
    }

    val isRoot: Boolean
        get() = fqName.isEmpty()

    fun parent(): FqNameUnsafe {
        parent?.let {
            return it
        }

        check(!isRoot) { "root" }

        compute()

        return parent!!
    }

    fun child(name: Name): FqNameUnsafe {
        val childFqName = if (isRoot) {
            name.asString()
        } else {
            fqName + "." + name.asString()
        }
        return FqNameUnsafe(childFqName, this, name)
    }

    fun shortName(): Name {
        shortName?.let {
            return it
        }

        check(!isRoot) { "root" }

        compute()

        return shortName!!
    }

    fun shortNameOrSpecial(): Name {
        return if (isRoot) {
            ROOT_NAME
        } else {
            shortName()
        }
    }

    fun pathSegments(): List<Name> {
        return if (isRoot) emptyList() else SPLIT_BY_DOTS.split(fqName).map(STRING_TO_NAME)
    }

    fun startsWith(segment: Name): Boolean {
        if (isRoot) return false

        val firstDot = fqName.indexOf('.')
        val fqNameFirstSegmentLength = if (firstDot == -1) fqName.length else firstDot
        val segmentAsString = segment.asString()
        return fqNameFirstSegmentLength == segmentAsString.length &&
                fqName.regionMatches(0, segmentAsString, 0, fqNameFirstSegmentLength)
    }

    fun startsWith(other: FqNameUnsafe): Boolean {
        if (isRoot) return false

        val thisLength = fqName.length
        val otherLength = other.fqName.length
        if (thisLength < otherLength) return false

        return (thisLength == otherLength || fqName[otherLength] == '.') &&
                fqName.regionMatches(0, other.fqName, 0, otherLength)
    }

    override fun toString(): String {
        return if (isRoot) ROOT_NAME.asString() else fqName
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is FqNameUnsafe) return false

        if (fqName != o.fqName) return false

        return true
    }

    override fun hashCode(): Int {
        return fqName.hashCode()
    }

    companion object {
        private val ROOT_NAME = Name.special("<root>")
        private val SPLIT_BY_DOTS: Pattern = Pattern.compile("\\.")

        private val STRING_TO_NAME: Function1<String, Name> = { name: String? ->
            Name.guessByFirstCharacter(
                name!!
            )
        }

        fun isValid(qualifiedName: String?): Boolean {
            // TODO: There's a valid name with escape char ``
            return qualifiedName != null && qualifiedName.indexOf('/') < 0 && qualifiedName.indexOf('*') < 0
        }

        fun topLevel(shortName: Name): FqNameUnsafe {
            return FqNameUnsafe(shortName.asString(), FqName.ROOT.toUnsafe(), shortName)
        }
    }
}
