package org.example.crackingthecodinginterviews

/**
 * Given two strings, write a method to decide if one is a permutation
 * of the other.
 */
interface PermutationOfTwoString {
    fun isPermutation(first: String, second: String): Boolean
}

/**
 * I use a hash-map to track each char and its count and then,
 * iterate over the second string and verify if they are permute or not.
 *
 * time complexity: O(n)
 * implementation time: 20 min
 */
class HashMapSolution : PermutationOfTwoString {

    override fun isPermutation(first: String, second: String): Boolean {
        if (first.length != second.length) return false
        val map = hashMapOf<Char, Int>()
        for (char in first) {
            if (map[char] != null) {
                map[char] = map[char]!! + 1
            } else {
                map[char] = 1
            }
        }
        for (char in second) {
            if (map[char] == null) {
                return false
            } else {
                map[char] = map[char]!! - 1
                if (map[char] == 0) map.remove(char)
            }
        }
        return map.isEmpty()
    }
}