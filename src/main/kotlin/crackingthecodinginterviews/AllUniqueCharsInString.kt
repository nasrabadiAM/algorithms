package org.example.crackingthecodinginterviews

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
interface AllUniqueCharsInString {
    fun hasAllUniqueChars(input: String): Boolean
}

/**
 * Add all chars in a hash map which has a key of a char and the count of its repetition in the value.
 * so at the end each item of hash map which has value of one, is unique and if there were any item that its value
 * is more than one, the return value is false.
 *
 * time complexity: O(n)
 * implementation time: 20 min
 */
class SolutionHashMap : AllUniqueCharsInString {
    private val map: HashMap<Char, Int> = hashMapOf()
    override fun hasAllUniqueChars(input: String): Boolean {
        if (input.isEmpty()) return true
        for (char in input) {
            if (map.containsKey(char)) {
                map[char] = (map[char]!! + 1)
            } else {
                map[char] = 1
            }
        }
        var hasDuplicate = false
        map.forEach { (key, value) ->
            if (value > 1) hasDuplicate = true
        }
        return hasDuplicate.not()
    }
}

/**
 * Implement a solution without any data structure
 * Using StringBuilder to find out if all are unique.
 *
 * Time Complexity: O(n)
 * implementation time: 10 min
 */
class SolutionNoDataStructure : AllUniqueCharsInString {
    override fun hasAllUniqueChars(input: String): Boolean {
        val removed = StringBuilder()
        for (char in input) {
            if (removed.contains(char)) {
                return false
            } else {
                removed.append(char)
            }
        }
        return true
    }
}