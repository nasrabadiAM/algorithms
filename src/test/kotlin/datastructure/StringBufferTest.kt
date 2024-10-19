package datastructure

import org.example.datastructure.StringBuffer
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringBufferTest {

    private val stringBuffer = StringBuffer()

    @Test
    fun shouldReturnStringValueWhenUseToString() {
        val input = "Hello"

        stringBuffer.append(input)

        assertEquals(input, stringBuffer.toString())
    }

    @Test
    fun shouldReturnEmptyStringWhenNothingAppends() {
        assertEquals("", stringBuffer.toString())
    }

    @Test
    fun shouldReturnStringValueOfTwoStringsWhenShorterThanInitialValue() {
        val input1 = "Hello"
        val input2 = "!"

        stringBuffer.append(input1)
        stringBuffer.append(input2)

        assertEquals(input1 + input2, stringBuffer.toString())
    }

    @Test
    fun shouldReturnStringValueOfTwoStringsWhenLongerThanInitialValue() {
        val input1 = "Hello"
        val input2 = "Body!"

        stringBuffer.append(input1)
        stringBuffer.append(input2)

        assertEquals(input1 + input2, stringBuffer.toString())
    }

    @Test
    fun shouldHoldOldValuesWhenExpandArray() {
        val input1 = "HelloBod"

        stringBuffer.append(input1)
        stringBuffer.expandArray()

        assertEquals(input1, stringBuffer.toString())
    }

    @Test
    fun shouldExpandArrayMoreThatRatioWhenThereIsALongerString() {
        stringBuffer.expandArray(20)

        assertEquals(32, stringBuffer.size)
    }

    @Test
    fun shouldExpandArrayMoreThatRatioWhenThereIsAShortString() {
        stringBuffer.expandArray(2)

        assertEquals(16, stringBuffer.size)
    }

    @Test
    fun shouldExpandArrayMoreThatRatioWhenThereIsTwoLongString() {
        stringBuffer.expandArray(40) // 64
        assertEquals(64, stringBuffer.size)

        stringBuffer.expandArray(90) //128
        assertEquals(128, stringBuffer.size)
    }

    @Test
    fun shouldReturnStringValueOfTwoStringsWhenAddMultipleMediumValues() {
        val input1 = "HelloBody! "
        val input2 = "How are you?"
        val input3 = "I'm doing well. "
        val input4 = "and you?"

        stringBuffer.append(input1)
        stringBuffer.append(input2)
        stringBuffer.append(input3)
        stringBuffer.append(input4)

        assertEquals(
            expected = input1 + input2 + input3 + input4,
            actual = stringBuffer.toString()
        )
    }

    @Test
    fun shouldReturnEmojisWhenAddEmojis() {
        val input1 =
            "\uD83D\uDE00A̛͚̖▶\uFE0F\uD83C\uDDF9\uD83C\uDDE9\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC67"
        val input2 =
            "\uD83D\uDC6B\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC67\uD83D\uDC68\u200D\uD83D\uDC68\u200D\uD83D\uDC66"

        stringBuffer.append(input1)
        stringBuffer.append(input2)

        assertEquals(input1 + input2, stringBuffer.toString())
    }

    @Test
    fun shouldReturnSpecialCharWhenUsingSpecialChars() {
        val input1 = "Hi \n Dude!"
        val input2 = "we \t love \t you!"

        stringBuffer.append(input1)
        stringBuffer.append(input2)

        assertEquals(input1 + input2, stringBuffer.toString())
    }
}