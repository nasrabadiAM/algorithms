package org.example.crackingthecodinginterviews


/**
 *
 * 1.8 Assume you have a method isSubstring which checks if one word is a substring of another,
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring(e.g: "waterbottle" is a rotation of
 * "erbottlewat")
 *
 * */
interface IsSubStingRotation {
    fun isSubstring(s1: String, s2: String): Boolean
}

/**
 *
 * time complexity: O(n)
 * memory complexity: O(1)
 * implementation time: 45 min
 */
class IsSubstringRotationHashMapImpl : IsSubStingRotation {
    override fun isSubstring(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false
        if (s1 == s2) return true
        val chars = hashMapOf<Char, Int>()
        for (char in s1) {
            val value = chars.get(char)
            if (value == null) {
                chars.put(char, 1)
            } else {
                chars.put(char, value + 1)
            }
        }
        for (char in s2) {
            val value = chars.get(char)
            if (value == null) {
                return false
            } else {
                chars.put(char, value - 1)
            }
        }

        for (map in chars) {
            if (map.value > 0) {
                return false
            }
        }
        return true
    }
}