package org.example.easy


/**
 * [First Unique Character in a string](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/)
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * @see easy.ReverseIntegerTest
 *
 * */

interface FirstUniqCharacterInString {
    fun firstUniqChar(s: String): Int
}

/**
 * failed
 */
class FirstUniqCharacterInStringLoopImpl : FirstUniqCharacterInString {
    override fun firstUniqChar(s: String): Int {
        val skippedChars = mutableSetOf<Char>()
        var resultIndex = -1
        if (s.length == 1) return 0
        outerLoop@ for (index in s.indices) {
            for (innerIndex in index + 1 until s.length) {
                if (s[index] == s[innerIndex]) {
                    skippedChars.add(s[index])
                    continue@outerLoop
                }
            }
            resultIndex = if (skippedChars.contains(s[index])) -1 else index
        }
        return resultIndex
    }
}

/**
 * failed, just idea
 */
class FirstUniqCharacterInStringHashMapImpl : FirstUniqCharacterInString {
    override fun firstUniqChar(s: String): Int {
        val skippedChars = mutableSetOf<Char>()
        var resultIndex = -1

        return resultIndex
    }
}

