package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.SolutionLoop
import org.example.crackingthecodinginterviews.StringCompression
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringCompressionTest {

    private val solution: StringCompression = SolutionLoop()

    @Test
    fun shouldReturnCompressedWhenOneCharRepeatedTwice() {
        val input = "aa"
        val result = solution.compress(input)
        assertEquals("a2", result)
    }

    @Test
    fun shouldReturnCompressedWhenTwoCharRepeatedTwice() {
        val input = "aabb"
        val result = solution.compress(input)
        assertEquals("a2b2", result)
    }

    @Test
    fun shouldReturnCompressedWhenOneCharRepeatedFourTimesAtTheEnd() {
        val input = "abbbb"
        val result = solution.compress(input)
        assertEquals("a1b4", result)
    }

    @Test
    fun shouldReturnOriginalWhenOneCharRepeatedTwiceAtTheEnd() {
        val input = "abb"
        val result = solution.compress(input)
        assertEquals("abb", result)
    }

    @Test
    fun shouldReturnOriginalStringWhenCompressedStringIsNotValid() {
        val input = "abcd"
        val result = solution.compress(input)
        assertEquals("abcd", result)
    }

    @Test
    fun shouldReturnCompressedStringWhenCompressedStringHasSixRepeatedCharInMiddle() {
        val input = "abccccccd"
        val result = solution.compress(input)
        assertEquals("a1b1c6d1", result)
    }

    @Test
    fun shouldReturnOriginalStringWhenInputIsEmpty() {
        val input = ""
        val result = solution.compress(input)
        assertEquals("", result)
    }
}