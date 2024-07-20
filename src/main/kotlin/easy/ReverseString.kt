package org.example.easy

import java.util.*

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

/**
 * 3
 * duration: 222ms
 * memory: 42mb
 */
class ReverseStringKotlinStackImpl : ReverseString {
    override fun reverseString(s: CharArray): Unit {
        val stack = Stack<Char>()
        s.forEach {
            stack.push(it)
        }
        s.forEachIndexed { index, _ ->
            val item = stack.pop()
            s[index] = item
        }
    }
}