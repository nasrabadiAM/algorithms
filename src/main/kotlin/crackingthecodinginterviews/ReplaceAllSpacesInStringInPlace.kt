package org.example.crackingthecodinginterviews

/**
 * Write a method to replace all spaces in a string with '%20'.
 * you may assume that the string has sufficient space at the end of the string
 * to hold the additional characters, and that you are given the "true" length of
 * the string. (Note: if you implement in java, please use a character array
 * so that you can perform this operation in place.)
 */
interface ReplaceAllSpacesInStringInPlace {
    fun replaceStrings(input: String): String
}

/**
 * as the initial array gives us the true length, so we don't need to add
 * extra space at the end of our array. so we can iterate form end to start
 * and move all characters to end and then add our additional chars to them.
 *
 * time complexity: O(n)
 * implementation time: 30 min
 */
class Solution() : ReplaceAllSpacesInStringInPlace {
    override fun replaceStrings(input: String): String {
        val inputArray = input.toCharArray()
        var latestIndex = inputArray.size - 1
        var shouldCountRealSpace = false
        var realSpaceCount = 0
        for (i in inputArray.size - 1 downTo 0) {
            if (inputArray[i] != ' ') {
                inputArray[latestIndex] = inputArray[i]
                latestIndex--
                shouldCountRealSpace = true
            } else if (inputArray[i] == ' ' && shouldCountRealSpace) {
                realSpaceCount += 1
            }
            if (realSpaceCount == 1) {
                realSpaceCount -= 1
                inputArray[latestIndex] = '0'
                inputArray[latestIndex - 1] = '2'
                inputArray[latestIndex - 2] = '%'
                latestIndex -= 3
            }
        }
        return String(inputArray)
    }
}