package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.AllUniqueCharsInString
import org.example.crackingthecodinginterviews.SolutionNoDataStructure
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AllUniqueCharInStringTest1 {

    private val solution: AllUniqueCharsInString = SolutionNoDataStructure()

    @Test
    fun shouldReturnTrueWhenStringIsEmpty() {
        val input = ""
        assertTrue(solution.hasAllUniqueChars(input))
    }

    @Test
    fun shouldReturnFalseWhenTwoCharAreSame(){
        val input = "aa"
        assertFalse(solution.hasAllUniqueChars(input))
    }

    @Test
    fun shouldReturnTrueWhenTwoUniqueCharInString(){
        val input = "ab"
        assertTrue(solution.hasAllUniqueChars(input))
    }

    @Test
    fun shouldReturnFalseWhenThirdCharIsSameAsFirst(){
        val input = "aba"
        assertFalse(solution.hasAllUniqueChars(input))
    }

    @Test
    fun shouldReturnFalseWhenFirstAndLastCharsAreSame(){
        val input = "abhjklpoiuytqwra"
        assertFalse(solution.hasAllUniqueChars(input))
    }

    @Test
    fun shouldReturnTrueWhenThereIsNoDuplicate(){
        val input = "abcdefghijklmnopqrstuvwxyz"
        assertTrue(solution.hasAllUniqueChars(input))
    }

    @Test
    fun shouldReturnFalseWhenThereIsTwoSameEmoji(){
        val input = "\uD83D\uDC6B\uD83D\uDC6B"
        assertFalse(solution.hasAllUniqueChars(input),"input=$input")
    }

    @Test
    fun shouldReturnFalseWhenThereIsSomeDifferentEmojisThatHasDuplicateChars(){
        val input = "\uD83D\uDC6B\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC67\uD83D\uDC68\u200D\uD83D\uDC68\u200D\uD83D\uDC66"
        assertFalse(solution.hasAllUniqueChars(input),"input=$input")
    }
}