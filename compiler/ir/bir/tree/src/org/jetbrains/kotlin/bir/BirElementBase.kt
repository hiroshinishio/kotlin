/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.bir

import org.jetbrains.kotlin.bir.lazy.BirLazyElementBase
import org.jetbrains.kotlin.bir.symbols.BirSymbol
import org.jetbrains.kotlin.bir.symbols.ownerIfBound
import org.jetbrains.kotlin.bir.util.BirImplementationDetail
import org.jetbrains.kotlin.bir.util.ForwardReferenceRecorder
import org.jetbrains.kotlin.bir.util.SmallFixedPointFraction
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or

@Suppress("EqualsOrHashCode")
@OptIn(BirImplementationDetail::class)
abstract class BirElementBase : BirElementParent(), BirElement {
    /**
     * Database reference may be stale.
     * To actualize it for all elements in a database, call [BirDatabase.realizeTreeMovements]
     */
    internal var _containingDatabase: BirDatabase? = null
    internal var _parent: BirElementParent? = null

    @Suppress("LeakingThis") // Implementations are always autogenerated and safe
    internal val elementClassId = getElementClassInternal().id.toUByte()
    private var flags: Byte = 0

    internal var indexSlot: UByte = 0u
    internal var lastReturnedInQueryOfIndexSlot: UByte = 0u

    // Contains both back references and dependent elements
    protected var relatedElements: Any? = null // null | BirElementBase | Array<BirElementBase?>
        private set
    private var relatedElementsFullness = SmallFixedPointFraction.ZERO

    // Array of form [key, value, key, value, ...]
    private var dynamicProperties: Array<Any?>? = null


    internal val elementClass
        get() = BirMetadata.allElementsById.getOrNull(elementClassId.toInt())

    override val parent: BirElementBase?
        get() = _parent as? BirElementBase

    final override fun getContainingDatabase(): BirDatabase? {
        // perf: it should be possible to realize movements only for this element
        _containingDatabase?.realizeTreeMovements()
        return _containingDatabase
    }


    internal fun hasFlag(flag: Byte): Boolean =
        (flags and flag).toInt() != 0

    internal fun setFlag(flag: Byte, value: Boolean) {
        flags = if (value) flags or flag else flags and flag.inv()
    }

    internal var containingListId: Int
        get() = flags.toInt() shr (8 - CONTAINING_LIST_ID_BITS)
        set(value) {
            flags = (flags and (-1 ushr (32 - 8 + CONTAINING_LIST_ID_BITS)).toByte()) or (value shl (8 - CONTAINING_LIST_ID_BITS)).toByte()
        }


    fun isAncestorOf(other: BirElementBase): Boolean {
        if (getContainingDatabase() !== other.getContainingDatabase()) {
            return false
        }

        var n = other
        while (true) {
            n = n.parent ?: break
            if (n === this) return true
        }

        return false
    }

    internal fun moveElementToNewParent(newParent: BirElementParent, newDatabase: BirDatabase?) {
        val oldParent = _parent
        if (oldParent != null) {
            if (oldParent === newParent) {
                // This may happen in the case of lazy BIR, where a parent of an element may be set
                // before it is attached to that parent.
                assert(this is BirLazyElementBase)
                return
            }

            require(this is BirImplElementBase) { "Lazy BIR elements cannot be moved" }

            replacedWithInternal(null)
            setParentWithInvalidation(newParent)
            if (oldParent is BirImplElementBase) {
                oldParent.invalidate()
            }

            newDatabase?.elementMoved(this, oldParent)
        } else {
            // Lazy elements have permanent parent, reflecting
            // the one in Fir2Ir class.
            if (this is BirImplElementBase) {
                setParentWithInvalidation(newParent)
            }
            newDatabase?.elementAttached(this)
        }
    }


    internal open fun getChildrenListById(id: Int): BirChildElementList<*> {
        throwChildrenListWithIdNotFound(id)
    }

    protected fun throwChildrenListWithIdNotFound(id: Int): Nothing {
        throw IllegalStateException("The element $this does not have a children list with id $id")
    }

    internal fun getContainingList(): BirChildElementList<*>? {
        val containingListId = containingListId
        return if (containingListId == 0) null
        else parent?.getChildrenListById(containingListId)
    }

    protected fun throwLateinitPropertyUninitialized(propertyName: String): Nothing {
        throw UninitializedPropertyAccessException("lateinit property $propertyName has not been initialized")
    }


    internal open fun <T> getDynamicProperty(token: BirDynamicPropertyAccessToken<*, T>): T? {
        token.requireValid()
        recordPropertyRead()

        val arrayMap = dynamicProperties ?: return null
        val keyIndex = findDynamicPropertyIndex(arrayMap, token.key, false)
        if (keyIndex < 0) {
            return null
        } else {
            @Suppress("UNCHECKED_CAST")
            return arrayMap[keyIndex + 1] as T
        }
    }

    internal fun <T> setDynamicProperty(token: BirDynamicPropertyAccessToken<*, T>, value: T?): T? {
        token.requireValid()

        val arrayMap = dynamicProperties
        val changed: Boolean
        var previousValue: T? = null
        if (arrayMap == null) {
            if (value == null) {
                // optimization: next read will return null if the array is null, so no need to initialize it
                changed = false
            } else {
                initializeDynamicProperties(token, value)
                changed = true
            }
        } else {
            val foundIndex = findDynamicPropertyIndex(arrayMap, token.key, true)
            if (foundIndex >= 0) {
                if (value == null) {
                    removeDynamicPropertyAt(arrayMap, foundIndex)
                    changed = true
                } else {
                    val valueIndex = foundIndex + 1
                    @Suppress("UNCHECKED_CAST")
                    previousValue = arrayMap[valueIndex] as T?
                    arrayMap[valueIndex] = value
                    changed = previousValue != value
                }
            } else {
                val entryIndex = -(foundIndex + 1)
                changed = addDynamicProperty(arrayMap, entryIndex, token.key, value)
            }
        }

        if (changed) {
            invalidate()
        }

        return previousValue
    }

    internal fun <T> getOrPutDynamicProperty(token: BirDynamicPropertyAccessToken<*, T>, compute: () -> T): T {
        token.requireValid()

        val arrayMap = dynamicProperties
        val foundIndex = if (arrayMap != null)
            findDynamicPropertyIndex(arrayMap, token.key, true)
        else -1

        if (foundIndex >= 0) {
            @Suppress("UNCHECKED_CAST")
            return arrayMap!![foundIndex + 1] as T
        } else {
            val newValue = compute()

            if (arrayMap == null) {
                initializeDynamicProperties(token, newValue)
            } else {
                val entryIndex = -(foundIndex + 1)
                addDynamicProperty(arrayMap, entryIndex, token.key, newValue)
            }

            invalidate()
            return newValue
        }
    }

    private fun <T> initializeDynamicProperties(firstToken: BirDynamicPropertyAccessToken<*, T>, firstValue: T?) {
        val initialSlots = 1
        val arrayMap = arrayOfNulls<Any?>(initialSlots * 2)
        arrayMap[0] = firstToken.key
        arrayMap[1] = firstValue
        this.dynamicProperties = arrayMap
    }

    private fun <T> addDynamicProperty(arrayMap: Array<Any?>, index: Int, key: BirDynamicPropertyKey<*, T>, value: T?): Boolean {
        if (value == null) {
            return false
        }

        var arrayMap = arrayMap
        if (arrayMap.size <= index) {
            val newSlots = 2
            arrayMap = arrayMap.copyOf(arrayMap.size + newSlots * 2)
            this.dynamicProperties = arrayMap
        }

        arrayMap[index] = key
        arrayMap[index + 1] = value
        return true
    }

    private fun findDynamicPropertyIndex(arrayMap: Array<Any?>, propertyKey: BirDynamicPropertyKey<*, *>, pruneOutdated: Boolean): Int {
        var i = 0
        while (i < arrayMap.size) {
            val key = arrayMap[i]
            if (key == null) {
                return -i - 1
            }
            if (key === propertyKey) {
                return i
            }

            if (pruneOutdated && key is PhaseLocalBirDynamicProperty<*, *> && !key.isValid) {
                removeDynamicPropertyAt(arrayMap, i)
            } else {
                i += 2
            }
        }
        return -i - 1
    }

    private fun removeDynamicPropertyAt(arrayMap: Array<Any?>, keyIndex: Int) {
        val lastKeyIndex = arrayMap.size - 2
        if (lastKeyIndex > keyIndex) {
            arrayMap[keyIndex] = arrayMap[lastKeyIndex]
            arrayMap[keyIndex + 1] = arrayMap[lastKeyIndex + 1]
        }
        arrayMap[lastKeyIndex] = null
        arrayMap[lastKeyIndex + 1] = null
    }

    private fun BirDynamicPropertyAccessToken<*, *>.requireValid() {
        if (this is PhaseLocalBirDynamicProperty<*, *>) {
            require(isValid) { "The property token can only be used within the phase $validInPhase" }
        }
    }

    // todo: fine-grained control of which data to copy
    internal fun copyDynamicProperties(from: BirElementBase) {
        invalidate()
        dynamicProperties = from.dynamicProperties?.copyOf()
    }


    internal fun recordPropertyRead() {
        val database = _containingDatabase ?: return
        val classifiedElement = database.elementCurrentlyBeingClassified ?: return
        if (classifiedElement !== this) {
            registerDependentElement(classifiedElement)
        }
    }

    private fun registerDependentElement(dependentElement: BirElementBase) {
        addRelatedElement(dependentElement, false)
    }

    internal fun invalidate() {
        _containingDatabase?.invalidateElement(this)
    }

    internal fun indexInvalidatedDependentElements() {
        val database = _containingDatabase ?: return

        val array: Array<BirElementBase?>
        var storageIsArray = false
        when (val elementsOrSingle = relatedElements) {
            null -> return
            is BirElementBase -> array = arrayOf(elementsOrSingle)
            else -> {
                @Suppress("UNCHECKED_CAST")
                array = elementsOrSingle as Array<BirElementBase?>
                storageIsArray = true
            }
        }

        for (i in array.indices) {
            val element = array[i] ?: break

            if (!element.hasFlag(FLAG_HAS_BEEN_REGISTERED_AS_DEPENDENT_ELEMENT)) {
                // This element is certainly not a back reference, so is safe to delete.
                removeRelatedElement(i)
            }

            database.indexElement(element, true)
        }
    }


    internal fun registerBackReference(backReference: BirElementBase) {
        addRelatedElement(backReference, true)
    }

    internal fun <R : BirElement> getBackReferences(key: BirElementBackReferencesKey<*, R>): List<BirElementBase> {
        _containingDatabase?.flushInvalidatedElementBuffer()
        require(_containingDatabase != null) { "Element must be attached to some BirDatabase" }

        val array = when (val elementsOrSingle = relatedElements) {
            null -> return emptyList<BirElementBase>()
            is BirElementBase -> arrayOf(elementsOrSingle)
            else -> {
                @Suppress("UNCHECKED_CAST")
                elementsOrSingle as Array<BirElementBase?>
            }
        }

        val results = ArrayList<BirElementBase>(array.size)
        for (i in array.indices) {
            val backRef = array[i] ?: break

            var isValidBackRef = false
            if (backRef.hasFlag(FLAG_HAS_BEEN_REGISTERED_AS_BACK_REFERENCE)) {
                val forwardReferenceRecorder = ForwardReferenceRecorder()
                with(forwardReferenceRecorder) {
                    key.recorder.recordBackReferences(backRef)
                }

                val recordedRef = forwardReferenceRecorder.recordedRef
                forwardReferenceRecorder.reset()

                if (recordedRef === this) {
                    backRef._containingDatabase?.realizeTreeMovements()
                    if (backRef._containingDatabase != null) {
                        isValidBackRef = true
                    }
                }
            }

            if (isValidBackRef) {
                results += backRef
            }
        }

        return results
    }


    private fun addRelatedElement(relatedElement: BirElementBase, isBackReference: Boolean) {
        val hasBeenRegisteredFlag =
            if (isBackReference) FLAG_HAS_BEEN_REGISTERED_AS_BACK_REFERENCE
            else FLAG_HAS_BEEN_REGISTERED_AS_DEPENDENT_ELEMENT

        var elementsOrSingle = relatedElements
        when (elementsOrSingle) {
            null -> {
                relatedElements = relatedElement
                relatedElementsFullness = SmallFixedPointFraction.ZERO
            }
            is BirElementBase -> {
                if (elementsOrSingle !== relatedElement) {
                    // 2 elements in array is a very common case.
                    val elements = arrayOfNulls<BirElementBase>(2)
                    elements[0] = elementsOrSingle
                    elements[1] = relatedElement
                    relatedElements = elements

                    val newSize = 2
                    relatedElementsFullness = SmallFixedPointFraction(newSize, elements.size)
                }
            }
            else -> {
                @Suppress("UNCHECKED_CAST")
                elementsOrSingle as Array<BirElementBase?>

                var alreadyRegistered = false
                var currentCount = 0
                if (relatedElement.hasFlag(FLAG_HAS_BEEN_REGISTERED_AS_BACK_REFERENCE or FLAG_HAS_BEEN_REGISTERED_AS_DEPENDENT_ELEMENT)) {
                    while (currentCount < elementsOrSingle.size) {
                        val element = elementsOrSingle[currentCount]
                        if (element == null) {
                            break
                        } else if (element === relatedElement) {
                            alreadyRegistered = true
                            break
                        }
                        currentCount++
                    }
                } else {
                    // Optimization: this element certainly isn't in the array. Just find a free spot.
                    currentCount = findRelatedElementsArrayCount(elementsOrSingle)
                }

                if (!alreadyRegistered) {
                    if (currentCount == elementsOrSingle.size) {
                        // This formula gives a nice progression: 2, 3, 4, 6, 9, 13...
                        val newArraySize = elementsOrSingle.size * 3 / 2

                        elementsOrSingle = elementsOrSingle.copyOf(newArraySize)
                        relatedElements = elementsOrSingle
                    }
                    elementsOrSingle[currentCount] = relatedElement

                    currentCount++
                    relatedElementsFullness = SmallFixedPointFraction(currentCount, elementsOrSingle.size)
                }
            }
        }

        relatedElement.setFlag(hasBeenRegisteredFlag, true)
    }

    private fun removeRelatedElement(index: Int) {
        val relatedElements = relatedElements
        if (relatedElements is Array<*>) {
            @Suppress("UNCHECKED_CAST")
            val array = relatedElements as Array<BirElementBase?>
            val count = findRelatedElementsArrayCount(array)
            require(index < count)

            val lastIndex = count - 1
            if (index != lastIndex) {
                array[index] = array[lastIndex]
            }
            array[lastIndex] = null

            relatedElementsFullness = SmallFixedPointFraction(lastIndex, array.size)
        } else {
            require(index == 0)
            require(relatedElements != null)
            this.relatedElements = null
        }
    }

    private fun findRelatedElementsArrayCount(array: Array<BirElementBase?>): Int {
        val minSize = relatedElementsFullness * array.size
        if (minSize == array.size) {
            return minSize
        }

        for (i in minSize..<array.size) {
            if (array[i] == null) {
                return i
            }
        }
        error("Should not reach here")
    }


    final override fun equals(other: Any?): Boolean {
        return other === this ||
                (other is BirSymbol && other.ownerIfBound === this)
    }

    companion object {
        internal const val FLAG_INVALIDATED: Byte = (1 shl 0).toByte()
        internal const val FLAG_IS_IN_MOVED_ELEMENTS_BUFFER: Byte = (1 shl 1).toByte()
        internal const val FLAG_HAS_BEEN_REGISTERED_AS_BACK_REFERENCE: Byte = (1 shl 2).toByte()
        internal const val FLAG_HAS_BEEN_REGISTERED_AS_DEPENDENT_ELEMENT: Byte = (1 shl 3).toByte()

        private const val CONTAINING_LIST_ID_BITS = 3
        internal const val MAX_CONTAINING_LIST_ID = (1 shl CONTAINING_LIST_ID_BITS) - 1
    }
}