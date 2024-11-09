package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.ReplaceAllSpacesInStringInPlace
import org.example.crackingthecodinginterviews.Solution
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReplaceSpaceTest {

    private val solution: ReplaceAllSpacesInStringInPlace = Solution()

    @Test
    fun shouldReplaceASingleSpace() {
        val input = "I am  "
        val result = solution.replaceStrings(input)
        assertEquals("I%20am", result)
    }

    @Test
    fun shouldNotReplaceIfStringIsEmpty() {
        val input = ""
        val result = solution.replaceStrings(input)
        assertEquals("", result)
    }

    @Test
    fun shouldReplaceTwoSpaces() {
        val input = "I am a    "
        val result = solution.replaceStrings(input)
        assertEquals("I%20am%20a", result)
    }

    @Test
    fun shouldReplaceThreeSpaces() {
        val input = "I am a developer      "
        val result = solution.replaceStrings(input)
        assertEquals("I%20am%20a%20developer", result)
    }

    @Test
    fun shouldReplaceTwoContinuesSpaces() {
        val input = "I  am a developer        "
        val result = solution.replaceStrings(input)
        assertEquals("I%20%20am%20a%20developer", result)
    }
}