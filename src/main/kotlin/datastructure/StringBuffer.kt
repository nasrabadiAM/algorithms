package org.example.datastructure

/**
 * This is a simple implementation of [java.lang.StringBuffer],
 * but it is not thread-safe.
 *
 * The other difference between my implementation and [java.lang.StringBuffer] is that
 * [java.lang.StringBuffer] uses [java.lang.AbstractStringBuilder] class which uses byte[] as the underlying
 * data type.
 *
 * The difference between [java.lang.StringBuffer] and [java.lang.StringBuilder] is that [java.lang.StringBuffer] is
 * thread-safe, so it is slower that [java.lang.StringBuilder].
 */
class StringBuffer {

    var size = 8
        private set
    private var lastUsedIndex = 0
    private var expandRatio = 2
    private var array = CharArray(size)

    fun append(string: String) {
        if (array.size - lastUsedIndex < string.length) {
            expandArray(string.length)
        }
        for (index in string.indices) {
            array[lastUsedIndex + index] = string[index]
        }
        lastUsedIndex += string.length
    }

    fun expandArray(minExpandSize: Int = 0) {
        do {
            size *= expandRatio
        } while (minExpandSize > size)
        val newArray = CharArray(size)
        for (index in array.indices) {
            newArray[index] = array[index]
        }
        array = newArray
    }


    override fun toString(): String {
        return String(chars = array, offset = 0, lastUsedIndex)
    }
}