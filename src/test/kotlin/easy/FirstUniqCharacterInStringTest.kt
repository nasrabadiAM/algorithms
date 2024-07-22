package easy

import org.example.easy.FirstUniqCharacterInString
import org.example.easy.FirstUniqCharacterInStringLoopImpl
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class FirstUniqCharacterInStringTest {

    private val firstUniqChar: FirstUniqCharacterInString = FirstUniqCharacterInStringLoopImpl()
    // private val firstUniqChar: FirstUniqCharacterInString = FirstUniqCharacterInStringHashMapImpl()

    @Test
    fun whenThereIsOneCharShouldReturnFirstIndex() {
        val result = firstUniqChar.firstUniqChar("a")
        assertEquals(0, result)
    }

    @Test
    fun whenThereIsTwoRepeatingCharShouldReturnMinusOne() {
        val result = firstUniqChar.firstUniqChar("aa")
        assertEquals(-1, result)
    }

    @Test
    fun whenThereIsThreeRepeatingCharShouldReturnMinusOne() {
        val result = firstUniqChar.firstUniqChar("aaa")
        assertEquals(-1, result)
    }

    @Test
    fun whenThereIsTwoNonRepeatingCharShouldReturnFirstIndex() {
        val result = firstUniqChar.firstUniqChar("ab")
        assertEquals(0, result)
    }

    @Test
    fun whenThereIsThreeNonRepeatingCharShouldReturnFirstIndex() {
        val result = firstUniqChar.firstUniqChar("abc")
        assertEquals(0, result)
    }

    @Test
    fun whenTheLastCharIsNonRepeatingShouldReturnLastIndex() {
        val result = firstUniqChar.firstUniqChar("aabbccddeef")
        assertEquals(10, result)
    }

    @Test
    fun whenTheFirstCharIsNonRepeatingShouldReturnFirstIndex() {
        val result = firstUniqChar.firstUniqChar("faabbccddee")
        assertEquals(0, result)
    }

}