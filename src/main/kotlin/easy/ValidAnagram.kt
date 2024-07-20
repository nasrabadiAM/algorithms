package org.example.easy

/**
 * [Valid Anagram](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/)
 * @see easy.ValidAnagramTest
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
            if (t.contains(char).not())
                if (currentValue != null) {
                    hashMap[char] = currentValue + 1
                } else {
                    hashMap[char] = 1
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
 *
 * copied from leetcode
 */

class ValidAnagramIntArrayImpl : ValidAnagram {
    override fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length)
            return false
        val arr1 = IntArray(26)
        val arr2 = IntArray(26)
        for (i in 0..s.length - 1) {
            arr1[s[i] - 'a']++
            arr2[t[i] - 'a']++
        }
        if (!arr1.contentEquals(arr2))
            return false
        return true
    }
}