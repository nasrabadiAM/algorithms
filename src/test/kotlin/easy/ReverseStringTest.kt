package easy

import org.example.easy.ReverseStringKotlinReversedArrayImpl
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ReverseStringTest {

    private val reverseString = ReverseStringKotlinReversedArrayImpl()
    // private val reverseString = ReverseStringWhileImpl()

    @Test
    fun shouldReturnArrayWhenSizeIsOne() {
        val inputArray = charArrayOf('a')
        reverseString.reverseString(inputArray)
        assertContentEquals(charArrayOf('a'), inputArray)
    }

    @Test
    fun shouldReturnReverseArrayWhenSizeIsTwo() {
        val inputArray = charArrayOf('a', 'b')
        reverseString.reverseString(inputArray)
        assertContentEquals(charArrayOf('b', 'a'), inputArray)
    }

    @Test
    fun shouldReturnReverseWhenArraySizeIsThree() {
        val inputArray = charArrayOf('a', 'b', 'c')
        reverseString.reverseString(inputArray)
        assertContentEquals(charArrayOf('c', 'b', 'a'), inputArray)
    }

    @Test
    fun shouldReturnReverseWhenArraySizeIsFour() {
        val inputArray = charArrayOf('a', 'b', 'c', 'd')
        reverseString.reverseString(inputArray)
        assertContentEquals(charArrayOf('d', 'c', 'b', 'a'), inputArray)
    }
}