package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.IsSubStingRotation
import org.example.crackingthecodinginterviews.IsSubstringRotationHashMapImpl
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsSubStringRotationTest {

    private val solution: IsSubStingRotation = IsSubstringRotationHashMapImpl()

    @Test
    fun shouldReturnTrueWhenTwoStringAreEmpty() {
        val s1 = ""
        val s2 = ""
        val result = solution.isSubstring(s1, s2)
        assertTrue(result, "string $s1 and $s2 are not rotation of each other")
    }

    @Test
    fun shouldReturnFalseWhenTwoStringDoesNotHaveSameLength() {
        val s1 = "aac"
        val s2 = "aa"
        val result = solution.isSubstring(s1, s2)
        assertFalse(result, "string $s1 and $s2 has not the same length")
    }

    @Test
    fun shouldReturnTrueWhenTwoStringAreEqual() {
        val s1 = "aac"
        val s2 = "aac"
        val result = solution.isSubstring(s1, s2)
        assertTrue(result, "string $s1 and $s2 are not rotation of each other")
    }

    @Test
    fun shouldReturnTrueWhenTwoStringAreRotationOfEachOtherWithTheLengthOfTwo() {
        val s1 = "ab"
        val s2 = "ba"
        val result = solution.isSubstring(s1, s2)
        assertTrue(result, "string $s1 and $s2 are not rotation of each other")
    }

    @Test
    fun shouldReturnTrueWhenTwoStringAreRotationOfEachOtherWithTheLengthOfThree() {
        val s1 = "abc"
        val s2 = "bca"
        val result = solution.isSubstring(s1, s2)
        assertTrue(result, "string $s1 and $s2 are not rotation of each other")
    }

    @Test
    fun shouldReturnTrueWhenTwoStringAreRotationOfEachOtherWithTheLengthOfFourAndRepeatedChars() {
        val s1 = "aabc"
        val s2 = "baca"
        val result = solution.isSubstring(s1, s2)
        assertTrue(result, "string $s1 and $s2 are not rotation of each other")
    }

    @Test
    fun shouldReturnTrueWhenTwoStringAreRotationOfEachOtherWithTheLengthOfFour() {
        val s1 = "aabc"
        val s2 = "baca"
        val result = solution.isSubstring(s1, s2)
        assertTrue(result, "string $s1 and $s2 are not rotation of each other")
    }

    @Test
    fun shouldReturnFalseWhenTwoStringAreNotRotationOfEachOtherWithTheLengthOfTwo() {
        val s1 = "ab"
        val s2 = "bd"
        val result = solution.isSubstring(s1, s2)
        assertFalse(result)
    }

    @Test
    fun shouldReturnFalseWhenTwoStringAreNotRotationOfEachOtherWithTheLengthOfFour() {
        val s1 = "abcd"
        val s2 = "bdcq"
        val result = solution.isSubstring(s1, s2)
        assertFalse(result)
    }

    @Test
    fun shouldReturnTrueWhenTwoStringAreRotationOfEachOtherWithSpace() {
        val s1 = "ab rg"
        val s2 = "gab r"
        val result = solution.isSubstring(s1, s2)
        assertTrue(result)
    }
}