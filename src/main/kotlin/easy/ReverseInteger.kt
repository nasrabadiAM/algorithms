package org.example.easy

import kotlin.math.abs
import kotlin.math.pow


/**
 * [Reverse Integer](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/)
 * @see easy.ReverseIntegerTest
 * */

interface ReverseInteger {
    fun reverse(x: Int): Int
}

/**
 * copied form leetcode
 * I failed finish this.
 * best solution.
 */
class ReverseIntegerWhileImpl : ReverseInteger {
    override fun reverse(x: Int): Int {
        var rev = 0
        var num = abs(x)
        val sign = if (x < 0) -1 else 1

        while (num != 0) {
            val digit = num % 10

            if (rev > (Int.MAX_VALUE - digit) / 10)
                return 0

            rev = rev * 10 + digit
            num /= 10
        }

        return rev * sign
    }
}

/**
 * 1
 * failed
 */
class ReverseIntegerRecursionImpl : ReverseInteger {
    override fun reverse(x: Int): Int {
        if (x / 10 == 0) return x
        val remainedNum = x / 10
        val remaining = x % 10
        val count = 0 // should be changed over recursions but not possible
        return reverse(remainedNum) + reverse(remaining) * 10.0.pow(count).toInt()
    }
}

/**
 * 2
 * duration: 157
 * memory: 34mb
 */
class ReverseIntegerStackImpl : ReverseInteger {
    override fun reverse(x: Int): Int {
        val numQueue = mutableListOf<Int>()
        var num = x
        while (num != 0) {
            val remained = num % 10
            numQueue.add(remained)
            num /= 10
        }
        var result = 0L
        numQueue.forEach {
            result = result * 10 + it
        }
        if (result > Int.MAX_VALUE || result < Int.MIN_VALUE) {
            return 0
        }
        return result.toInt()
    }
}