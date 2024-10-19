package org.example.datastructure

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