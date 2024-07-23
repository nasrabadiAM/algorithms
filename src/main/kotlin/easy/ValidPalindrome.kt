package org.example.easy


/**
 * [Valid Palindrome](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/)
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * @see easy.ValidPalindromeTest
 * */

interface ValidPalindrome {
    fun isPalindrome(s: String): Boolean
}

/**
 * 1
 * duration: 770
 * memory: 41mb
 * beats: 6%
 * time: 50 min
 */
class ValidPalindromeImpl : ValidPalindrome {
    override fun isPalindrome(s: String): Boolean {
        val nakedString = s.filterNotAlphabetical()
        var currentIndex = 0
        while (currentIndex < nakedString.length) {
            val currentChar = nakedString[currentIndex]
            val oppositeIndex = nakedString.length - 1 - currentIndex
            if (oppositeIndex == -1) {
                return false
            }
            val oppositeChar = nakedString[oppositeIndex]
            if (oppositeIndex == currentIndex && oppositeChar == currentChar) return true
            if (currentChar.equals(oppositeChar, true).not()) {
                return false
            }
            currentIndex++
        }
        return true
    }
}

internal fun String.filterNotAlphabetical(): String {
    var nakedString = ""
    for (char in this) {
        val isAlphabetical =
            char.isInRange('z', 'a') ||
                    char.isInRange('Z', 'A') ||
                    char.isInRange('9', '0')
        if (isAlphabetical) {
            nakedString += char
        }
    }
    return nakedString
}

private fun Char.isInRange(upper: Char, lower: Char) = (this - upper <= 0 && this - lower >= 0)
