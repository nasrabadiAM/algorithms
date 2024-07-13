package org.example.easy

/**
 * [Valid Anagram](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/)
 * @see easy.ValidAnagramTest.kt
 * */

interface ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean
}

/**
 * duration: 575
 * memory: 37mb
 */
class ValidAnagramArrayImpl : ValidAnagram {
    override fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        if (s.isEmpty() && t.isEmpty()) return true
        var target = t.toMutableList()
        for (char in s) {
            val index = target.indexOf(char)
            if (index == -1) return false
            target.removeAt(index)
        }
        if (target.isEmpty()) return true
        return false
    }
}

/**
 * duration: 456
 * memory: 38.5mb
 */
class ValidAnagramStringBuilderImpl : ValidAnagram {
    override fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        if (s.isEmpty() && t.isEmpty()) return true
        val stringBuilder = StringBuilder(t)
        for (char in s) {
            val index = stringBuilder.indexOf(char)
            if (index == -1) return false
            stringBuilder.deleteAt(index)
        }
        if (stringBuilder.isEmpty()) return true
        return false
    }
}

/**
 * duration: 210
 * memory: 37.5mb
 */
class ValidAnagramHashMapImpl : ValidAnagram {
    override fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        if (s.isEmpty() && t.isEmpty()) return true
        val hashMap = HashMap<Char, Int>()
        for (char in s) {
            val currentValue = hashMap[char]
            if (currentValue != null) {
                hashMap[char] = currentValue + 1
            } else {
                hashMap[char] = 1
            }
        }
        for (char in t) {
            val currentValue = hashMap[char]
            if (currentValue != null) {
                if (currentValue == 1) {
                    hashMap.remove(char)
                } else {
                    hashMap[char] = currentValue - 1
                }
            } else {
                return false
            }
        }
        if (hashMap.isEmpty()) return true
        return false
    }
}

/**
 * best solution time: Using IntArray + unicode calculations
 *
 * best solution memory: Using IntArray + unicode calculations
 */