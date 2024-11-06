package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.HashMapSolution
import org.example.crackingthecodinginterviews.PermutationOfTwoString
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PermutationOfTwoStringTest {

    private val solution: PermutationOfTwoString = HashMapSolution()

    @Test
    fun shouldReturnFalseIfTwoStringAreNotSameSize() {
        val first = "abc"
        val second = "abcd"
        val result = solution.isPermutation(first, second)
        assertFalse(result, "<$first> is not permutation of <$second>")
    }

    @Test
    fun shouldReturnTrueIfTwoStringAreEmpty() {
        val first = ""
        val second = ""
        val result = solution.isPermutation(first, second)
        assertTrue(result, "two empty strings are permute.")
    }

    @Test
    fun shouldReturnTrueIfTwoStringArePermute() {
        val first = "abc"
        val second = "cba"
        val result = solution.isPermutation(first, second)
        assertTrue(result, "$first is not permutation of $second")
    }

    @Test
    fun shouldReturnTrueIfTwoStringArePermuteAndHaveRepetitiveChars() {
        val first = "abccc"
        val second = "cbcca"
        val result = solution.isPermutation(first, second)
        assertTrue(result, "$first is not permutation of $second")
    }

    @Test
    fun shouldReturnTrueIfOneRepetitiveCharIsMissing() {
        val first = "abcc"
        val second = "bcca"
        val result = solution.isPermutation(first, second)
        assertTrue(result, "$first is not permutation of $second")
    }

    @Test
    fun shouldReturnFalseIfOneCharIsMissing() {
        val first = "abccd"
        val second = "bccax"
        val result = solution.isPermutation(first, second)
        assertFalse(result, "$first is permutation of $second")
    }

    @Test
    fun shouldReturnFalseIfOneCharIsNotSame() {
        val first = "a"
        val second = "b"
        val result = solution.isPermutation(first, second)
        assertFalse(result, "$first is permutation of $second")
    }

    @Test
    fun shouldReturnTrueIfTwoSameString() {
        val first = "Hello"
        val second = "Hello"
        val result = solution.isPermutation(first, second)
        assertTrue(result, "$first is not permutation of $second")
    }

    @Test
    fun shouldReturnFalseIfTwoSameStringAreSameButCaseSensitive() {
        val first = "hello"
        val second = "Hello"
        val result = solution.isPermutation(first, second)
        assertFalse(result, "$first is permutation of $second")
    }
}