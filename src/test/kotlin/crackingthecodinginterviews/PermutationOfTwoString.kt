package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.CharArraySolution
import org.example.crackingthecodinginterviews.HashMapSolution
import org.example.crackingthecodinginterviews.PermutationOfTwoString
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PermutationOfTwoStringTest {

    private val solution: PermutationOfTwoString = HashMapSolution()
    private val solutionArray: PermutationOfTwoString = CharArraySolution()

    @Test
    fun shouldReturnFalseIfTwoStringAreNotSameSize() {
        val first = "abc"
        val second = "abcd"
        solution.assertFalse(first, second)
        solutionArray.assertFalse(first, second)
    }

    @Test
    fun shouldReturnTrueIfTwoStringAreEmpty() {
        val first = ""
        val second = ""
        solution.assertTrue(first, second)
        solutionArray.assertTrue(first, second)
    }

    @Test
    fun shouldReturnTrueIfTwoStringArePermute() {
        val first = "abc"
        val second = "cba"
        solution.assertTrue(first, second)
        solutionArray.assertTrue(first, second)
    }

    @Test
    fun shouldReturnTrueIfTwoStringArePermuteAndHaveRepetitiveChars() {
        val first = "abccc"
        val second = "cbcca"
        solution.assertTrue(first, second)
        solutionArray.assertTrue(first, second)
    }

    @Test
    fun shouldReturnTrueIfOneRepetitiveCharIsMissing() {
        val first = "abcc"
        val second = "bcca"
        solution.assertTrue(first, second)
        solutionArray.assertTrue(first, second)
    }

    @Test
    fun shouldReturnFalseIfOneCharIsMissing() {
        val first = "abccd"
        val second = "bccax"
        solution.assertFalse(first, second)
        solutionArray.assertFalse(first, second)
    }

    @Test
    fun shouldReturnFalseIfOneCharIsNotSame() {
        val first = "a"
        val second = "b"
        solution.assertFalse(first, second)
        solutionArray.assertFalse(first, second)
    }

    @Test
    fun shouldReturnTrueIfTwoSameString() {
        val first = "Hello"
        val second = "Hello"
        solution.assertTrue(first, second)
        solutionArray.assertTrue(first, second)
    }

    @Test
    fun shouldReturnFalseIfTwoSameStringAreSameButCaseSensitive() {
        val first = "hello"
        val second = "Hello"
        solution.assertFalse(first, second)
        solutionArray.assertFalse(first, second)
    }

    @Test
    fun shouldReturnFalseIfTwoSameStringWithDifferentWhiteSpaces() {
        val first = "hello      "
        val second = "Hello"
        solution.assertFalse(first, second)
        solutionArray.assertFalse(first, second)
    }

    @Test
    fun shouldReturnFalseIfSecondStringHasADifferentChar() {
        val first = "IHello"
        val second = "Hellon"
        solution.assertFalse(first, second)
        solutionArray.assertFalse(first, second)
    }


    private fun PermutationOfTwoString.assertFalse(first: String, second: String) {
        val result = this.isPermutation(first, second)
        assertFalse(result, "<$first> is not permutation of <$second>, but you expect it is.")
    }

    private fun PermutationOfTwoString.assertTrue(first: String, second: String) {
        val result = this.isPermutation(first, second)
        assertTrue(result, "<$first> is permutation of <$second>, but you expect not.")
    }
}