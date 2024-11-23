package org.example.crackingthecodinginterviews

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * for example the string aabcccccaaa would become a2b1c5a3. if the compressed string would not become smaller
 * than the original string, your method should return the original string.
 */
interface StringCompression {
    fun compress(input: String): String
}

/**
 *
 * time complexity: O(n)
 * implementation time: 30 min
 *
 * Note: the other solution is to use StringBuffer and count compression at
 * the beginning.
 */
class SolutionLoop : StringCompression {
    override fun compress(input: String): String {
        val list = ArrayList<Char>()
        var currentChar = input.firstOrNull()
        var currentCount: Int = 0
        for (index in input.indices) {
            val char = input[index]
            if (char == currentChar) {
                currentCount++
            } else {
                list.add(requireNotNull(currentChar))
                list.add(currentCount.digitToChar())
                currentCount = 1
                currentChar = input[index]
            }
        }

        if (currentChar != null) {
            list.add(currentChar)
            list.add(currentCount.digitToChar())
        }
        return if (list.size > input.length) input else String(list.toCharArray())
    }
}