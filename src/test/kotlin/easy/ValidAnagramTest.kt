package easy

import org.example.easy.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidAnagramTest {
    private val validAnagram: ValidAnagram = ValidAnagramHashMapImpl()
    // private val validAnagram: ValidAnagram = ValidAnagramIntArrayImpl()
    // private val validAnagram: ValidAnagram = ValidAnagramStringBuilderImpl()
    // private val validAnagram: ValidAnagram = ValidAnagramArrayImpl()

    @Test
    fun whenTwoDifferentLengthShouldReturnFalse() {
        val result = validAnagram.isAnagram("sdf", "d")
        assertFalse(result)
    }

    @Test
    fun whenTwoEmptyWordShouldReturnTrue() {
        val result = validAnagram.isAnagram("", "")
        assertTrue(result)
    }

    @Test
    fun whenTwoLetterWordIsAnagramShouldReturnTrue() {
        val result = validAnagram.isAnagram("hi", "ih")
        assertTrue(result)
    }

    @Test
    fun whenTwoLetterWordIsNotAnagramShouldReturnTrue() {
        val result = validAnagram.isAnagram("hi", "if")
        assertFalse(result)
    }

    @Test
    fun whenThreeLetterWordIsNotAnagramShouldReturnTrue() {
        val result = validAnagram.isAnagram("min", "man")
        assertFalse(result)
    }

    @Test
    fun whenThreeLetterWordIsAnagramShouldReturnTrue() {
        val result = validAnagram.isAnagram("min", "nim")
        assertTrue(result)
    }

    @Test
    fun whenSevenLetterWordIsAnagramShouldReturnTrue() {
        val result = validAnagram.isAnagram("mindset", "setmind")
        assertTrue(result)
    }

    @Test
    fun whenSevenLetterWordIsNotAnagramShouldReturnFalse() {
        val result = validAnagram.isAnagram("mindset", "setminm")
        assertFalse(result)
    }
}