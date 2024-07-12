package easy

import org.example.easy.ValidAnagram
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidAnagramTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun isAnagram() {
        val validAnagram = ValidAnagram()
        val expected = validAnagram.isAnagram("", "")
        assertEquals(expected, true)
    }
}