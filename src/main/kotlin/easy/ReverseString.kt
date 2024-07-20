package org.example.easy

/**
 * [Reverse String](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/)
 * @see easy.ReverseStringTest
 * */

interface ReverseString {
    fun reverseString(s: CharArray): Unit
}

/**
 * 1
 * duration: 223
 * memory: 51mb
 */
class ReverseStringWhileImpl : ReverseString {
    override fun reverseString(s: CharArray): Unit {
        var index = 0
        while (index < s.size / 2) {
            val tempValue = s[index]
            val complementIndex = s.size - 1 - index
            s[index] = s[complementIndex]
            s[complementIndex] = tempValue
            index++
        }
    }
}

/**
 * 2
 * duration: 282ms
 * memory: 44mb
 */
class ReverseStringKotlinReversedArrayImpl : ReverseString {
    override fun reverseString(s: CharArray): Unit {
        s.reverse()
    }
}