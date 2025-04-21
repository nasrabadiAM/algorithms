package easy

import org.example.easy.DuplicateZeros
import org.example.easy.DuplicateZerosImpl
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DuplicateZerosTest {

    private val duplicateZeros: DuplicateZeros = DuplicateZerosImpl()

    @Test
    fun whenInputIsEmptyShouldDoNothing() {
        val actual = intArrayOf()
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputIsOneNonZeroShouldDoNothing() {
        val actual = intArrayOf(2)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(2)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputIsOneZeroShouldDoNothing() {
        val actual = intArrayOf(0)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(0)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsTwoWithZeroInFirstIndexShouldDuplicateItAndShift() {
        val actual = intArrayOf(0, 1)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(0, 0)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsTwoWithNonZeroShouldDoNothing() {
        val actual = intArrayOf(2, 1)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(2, 1)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsTwoWithZeroInLastIndexShouldDoNothing() {
        val actual = intArrayOf(2, 0)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(2, 0)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsThreeWithZeroInFirstIndexShouldDuplicateZeroAndShift() {
        val actual = intArrayOf(0, 1, 2)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(0, 0, 1)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsThreeWithZeroInSecondIndexShouldDuplicateZeroAndShift() {
        val actual = intArrayOf(1, 0, 2)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(1, 0, 0)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsThreeWithZeroInThirdIndexShouldDoNothing() {
        val actual = intArrayOf(1, 2, 0)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(1, 2, 0)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsFourWithZeroInSecondIndexShouldDDuplicateAndShift() {
        val actual = intArrayOf(1, 0, 3, 4)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(1, 0, 0, 3)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsFiveWithZeroInThirdIndexShouldDDuplicateAndShift() {
        val actual = intArrayOf(1, 2, 0, 4, 5)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(1, 2, 0, 0, 4)
        assertArrayEquals(expected, actual)
    }

    /** run of this test
     * val actual = intArrayOf(0, 2, 3, 4, 5), lastItem=0, index=1, currentItem(arr[1])=2,
     * 1val actual = intArrayOf(0, 0, 3, 4, 5), lastItem=0, index=1, currentItem(arr[1])=2,
     * 1val actual = intArrayOf(0, 0, 3, 4, 5), lastItem=0, index=1, currentItem(arr[1])=2,last=2,shiftStartIndex=2, shiftIndex=2, currentValue(arr[2])=3, shouldShift=true
     * 2val actual = intArrayOf(0, 0, 3, 4, 5), lastItem=0, index=1, currentItem(arr[1])=2,last=2,shiftStartIndex=2, shiftIndex=2, currentValue(arr[2])=3, shouldShift=true
     * 2val actual = intArrayOf(0, 0, 2, 4, 5), lastItem=0, index=1, currentItem(arr[1])=2,last=3,shiftStartIndex=2, shiftIndex=2, currentValue(arr[2])=3, shouldShift=true
     * 2val actual = intArrayOf(0, 0, 2, 4, 5), lastItem=0, index=1, currentItem(arr[1])=2,last=3,shiftStartIndex=2, shiftIndex=3, currentValue(arr[3])=4, shouldShift=true
     * 2val actual = intArrayOf(0, 0, 2, 3, 5), lastItem=0, index=1, currentItem(arr[1])=2,last=4,shiftStartIndex=2, shiftIndex=3, currentValue(arr[3])=4, shouldShift=true
     * 2val actual = intArrayOf(0, 0, 2, 3, 5), lastItem=0, index=1, currentItem(arr[1])=2,last=4,shiftStartIndex=2, shiftIndex=4, currentValue(arr[4])=5, shouldShift=true
     * 2val actual = intArrayOf(0, 0, 2, 3, 5), lastItem=0, index=1, currentItem(arr[1])=2,last=4,shiftStartIndex=2, shiftIndex=4, currentValue(arr[4])=5, shouldShift=true
     * 2val actual = intArrayOf(0, 0, 2, 3, 4), lastItem=2, index=1, currentItem(arr[1])=2,last=5,shiftStartIndex=2, shiftIndex=4, currentValue(arr[4])=5, shouldShift=false
     * 1val actual = intArrayOf(0, 0, 2, 3, 4), lastItem=2, index=2, currentItem(arr[2])=2,last=5,shiftStartIndex=2, shiftIndex=4, currentValue(arr[4])=5, shouldShift=false
     * 1val actual = intArrayOf(0, 0, 2, 3, 4), lastItem=2, index=3, currentItem(arr[3])=2,last=5,shiftStartIndex=2, shiftIndex=4, currentValue(arr[4])=5, shouldShift=false
     * 1val actual = intArrayOf(0, 0, 2, 3, 4), lastItem=2, index=4, currentItem(arr[3])=2,last=5,shiftStartIndex=2, shiftIndex=4, currentValue(arr[4])=5, shouldShift=false
     *
     */
    @Test
    fun whenInputLengthIsFiveWithZeroInFirstIndexShouldDDuplicateAndShift() {
        val actual = intArrayOf(0, 2, 3, 4, 5)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(0, 0, 2, 3, 4)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun whenInputLengthIsFiveWithZeroInFirstAndThirdIndexShouldDDuplicateAndShift() {
        val actual = intArrayOf(0, 2, 0, 4, 5)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(0, 0, 2, 0, 0)
        assertArrayEquals(expected, actual)
    }

    /**
     * val actual = intArrayOf(0, 0, 1, 4, 5), lastItem=0, index=1, currentItem(arr[1])=0,
     * val actual = intArrayOf(0, 0, 1, 4, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true
     * val actual = intArrayOf(0, 0, 1, 4, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=0, startShiftIndex=2, shiftIndex=2, currentValue(arr[2])=1
     * val actual = intArrayOf(0, 0, 1, 4, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=0, startShiftIndex=2, shiftIndex=2, currentValue(arr[2])=1
     * val actual = intArrayOf(0, 0, 0, 4, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=1, startShiftIndex=2, shiftIndex=2, currentValue(arr[2])=1
     * val actual = intArrayOf(0, 0, 0, 4, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=1, startShiftIndex=2, shiftIndex=2, currentValue(arr[2])=1
     * val actual = intArrayOf(0, 0, 0, 4, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=1, startShiftIndex=2, shiftIndex=3, currentValue(arr[3])=4
     * val actual = intArrayOf(0, 0, 0, 1, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=4, startShiftIndex=2, shiftIndex=3, currentValue(arr[3])=4
     * val actual = intArrayOf(0, 0, 0, 1, 5), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=4, startShiftIndex=2, shiftIndex=4, currentValue(arr[4])=5
     * val actual = intArrayOf(0, 0, 0, 1, 4), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=4, startShiftIndex=2, shiftIndex=4, currentValue(arr[4])=5
     * val actual = intArrayOf(0, 0, 0, 1, 4), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=true, last=5, startShiftIndex=2, shiftIndex=4, currentValue(arr[4])=5
     * val actual = intArrayOf(0, 0, 0, 1, 4), lastItem=0, index=1, currentItem(arr[1])=0, shouldShift=false, last=5, startShiftIndex=2, shiftIndex=4, currentValue(arr[4])=5
     * val actual = intArrayOf(0, 0, 0, 1, 4), lastItem=0, index=3, currentItem(arr[2])=0, shouldShift=true, last=5, startShiftIndex=2, shiftIndex=4, currentValue(arr[4])=5
     * val actual = intArrayOf(0, 0, 0, 1, 4), lastItem=0, index=3, currentItem(arr[2])=0, shouldShift=true, last=0, startShiftIndex=3, shiftIndex=3, currentValue(arr[3])=1
     * val actual = intArrayOf(0, 0, 0, 0, 4), lastItem=0, index=3, currentItem(arr[2])=0, shouldShift=true, last=1, startShiftIndex=3, shiftIndex=3, currentValue(arr[3])=1
     * val actual = intArrayOf(0, 0, 0, 0, 4), lastItem=0, index=3, currentItem(arr[2])=0, shouldShift=true, last=1, startShiftIndex=3, shiftIndex=4, currentValue(arr[4])=4
     * val actual = intArrayOf(0, 0, 0, 0, 1), lastItem=0, index=3, currentItem(arr[2])=0, shouldShift=true, last=4, startShiftIndex=3, shiftIndex=4, currentValue(arr[4])=4
     * val actual = intArrayOf(0, 0, 0, 0, 1), lastItem=0, index=4, currentItem(arr[3])=0, shouldShift=false , last=4, startShiftIndex=3, shiftIndex=4, currentValue(arr[4])=4
     *
     */
    @Test
    fun whenInputLengthIsFiveAndMostItemsAreZeroShouldDDuplicateAndShift() {
        val actual = intArrayOf(0, 0, 1, 4, 5)
        duplicateZeros.duplicate(actual)
        val expected = intArrayOf(0, 0, 0, 0, 1)
        assertArrayEquals(expected, actual)
    }
}