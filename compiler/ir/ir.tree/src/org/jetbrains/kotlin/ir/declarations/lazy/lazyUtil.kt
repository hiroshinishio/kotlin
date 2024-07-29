/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations.lazy

import org.jetbrains.kotlin.ir.IrLock
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> lazyVar(lock: IrLock, initializer: () -> T): ReadWriteProperty<Any?, T> = SynchronizedLazyVar(lock, initializer)

open class SynchronizedLazyVar<T>(val lock: IrLock, initializer: () -> T) : ReadWriteProperty<Any?, T> {
    @Volatile
    private var isInitialized = false

    private var initializer: (() -> T)? = initializer

    @Volatile
    private var _value: Any? = null

    private val value: T
        get() {
            @Suppress("UNCHECKED_CAST")
            if (isInitialized) return _value as T
            synchronized(lock) {
                val value: T
                if (isInitialized) {
                    @Suppress("UNCHECKED_CAST")
                    value = _value as T
                } else {
                    value = initializer!!()
                    _value = value
                    isInitialized = true
                    initializer = null
                    valueChanged(null, value)
                }
                return value
            }
        }

    protected open fun valueChanged(old: T?, new: T) {}

    override fun toString(): String = if (isInitialized) value.toString() else "Lazy value not initialized yet."

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = value

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        synchronized(lock) {
            @Suppress("UNCHECKED_CAST")
            val old = this._value as T
            this._value = value
            isInitialized = true
            valueChanged(old, value)
        }
    }
}
