package easy

import org.example.easy.ValidPalindromeImpl
import org.example.easy.filterNotAlphabetical
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ValidPalindromeTest {

    private val validPalindrome = ValidPalindromeImpl()

    @Test
    fun whenInputIsEmptyStringShouldReturnTrue() {
        val actual = validPalindrome.isPalindrome(" ")
        assertTrue(actual)
    }

    @Test
    fun whenInputIsPalindromeStringShouldReturnTrue() {
        val actual = validPalindrome.isPalindrome("aba")
        assertTrue(actual)
    }

    @Test
    fun whenInputIsFourPalindromeStringShouldReturnTrue() {
        val actual = validPalindrome.isPalindrome("abba")
        assertTrue(actual)
    }

    @Test
    fun whenInputIsFourPalindromeWithNonAlphabeticalStringShouldReturnTrue() {
        val actual = validPalindrome.isPalindrome("a b.b,///a`")
        assertTrue(actual)
    }

    @Test
    fun whenInputIsLikeThisShouldReturnTrue() {
        val actual = validPalindrome.isPalindrome("A man, a plan, a canal: Panama")
        assertTrue(actual)
    }

    @Test
    fun whenInputIsNotPalindromeWithNonAlphabeticalStringShouldReturnFalse() {
        val actual = validPalindrome.isPalindrome("`a.ad//bg-")
        assertFalse(actual)
    }

    @Test
    fun shouldRemoveNonAlphabeticalChars() {
        val input = "`/,.sd[]}fe1232`"
        val actual = input.filterNotAlphabetical()
        assertEquals("sdfe1232", actual)
    }

    @Test
    fun shouldNotRemoveNonAlphabeticalCharsWhenNoOneInIt() {
        val input = "sdfe1232"
        val actual = input.filterNotAlphabetical()
        assertEquals("sdfe1232", actual)
    }
    @Test
    fun shouldRemoveSpaceCharsWhenThereIsSpace() {
        val input = " s d `/fe1][2 32 "
        val actual = input.filterNotAlphabetical()
        assertEquals("sdfe1232", actual)
    }
}