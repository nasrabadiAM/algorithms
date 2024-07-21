package easy

import org.example.easy.ReverseInteger
import org.example.easy.ReverseIntegerRecursionImpl
import org.example.easy.ReverseIntegerStackImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReverseIntegerTest {
    private val reverseInteger: ReverseInteger = ReverseIntegerStackImpl()
    // private val reverseInteger: ReverseInteger = ReverseIntegerRecursionImpl()

    @Test
    fun shouldReturnZeroWhenInputIsZero() {
        val result = reverseInteger.reverse(0)
        assertEquals(0, result)
    }

    @Test
    fun shouldReturnExactNumWhenInputLengthIsOne() {
        val result = reverseInteger.reverse(1)
        assertEquals(1, result)
    }

    @Test
    fun shouldReturnReverseNumWhenInputLengthIsTwo() {
        val result = reverseInteger.reverse(12)
        assertEquals(21, result)
    }

    @Test
    fun shouldReturnReverseNumWhenInputLengthIsThree() {
        val result = reverseInteger.reverse(123)
        assertEquals(321, result)
    }

    @Test
    fun shouldReturnReverseNumWhenInputLengthIsFour() {
        val result = reverseInteger.reverse(1234)
        assertEquals(4321, result)
    }

    @Test
    fun shouldReturn21WhenInputIs120() {
        val result = reverseInteger.reverse(120)
        assertEquals(21, result)
    }

    @Test
    fun shouldReturnNegativeNumWhenInputIsNegative() {
        val result = reverseInteger.reverse(-124)
        assertEquals(-421, result)
    }

    @Test
    fun shouldReturnZeroWhenReverseIsBiggerThan32BitNum() {
        val result = reverseInteger.reverse(-1963847412)
        assertEquals(0, result)
    }

    @Test
    fun shouldReturnZeroWhenReverseIsBiggerThan32BitNum1() {
        val result = reverseInteger.reverse(2147483647)
        assertEquals(0, result)
    }
}