import org.example.crackingthecodinginterviews.AddTwoNumber
import org.example.crackingthecodinginterviews.AddTwoNumberImpl
import org.example.datastructure.LinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AddTwoNumberTest {

    private val solution: AddTwoNumber = AddTwoNumberImpl()

    @Test
    fun whenInputIsSingleDigitWithoutCarryShouldReturnSum() {
        val first = LinkedList(1)
        val second = LinkedList(2)
        val sum = solution.add(first, second)
        assertEquals(3, sum?.data)
    }

    @Test
    fun whenInputIsNullShouldReturnNull() {
        val sum = solution.add(null, null)
        assertNull(sum)
    }

    @Test
    fun whenInputIsSingleDigitWithCarry() {
        val first = LinkedList(9)
        val second = LinkedList(5)
        val sum = solution.add(first, second)
        assertEquals(4, sum?.data)
        assertEquals(1, sum?.next?.data)
    }

    @Test
    fun whenInputIsTwoDigitsWithOutCarry() {
        val first = LinkedList(3) // 43
        first.next = LinkedList(4)
        val second = LinkedList(5)  // 25
        second.next = LinkedList(2)

        val sum = solution.add(first, second) // 68
        assertEquals(8, sum?.data)
        assertEquals(6, sum?.next?.data)
    }

    @Test
    fun whenInputIsOneTwoDigitsAndASingleDigit() {
        val first = LinkedList(3) // 43
        first.next = LinkedList(4)
        val second = LinkedList(5)  // 5

        val sum = solution.add(first, second) // 48
        assertEquals(8, sum?.data)
        assertEquals(4, sum?.next?.data)
    }

    @Test
    fun whenInputIsOneTwoDigitsAndASingleDigitWithCarry() {
        val first = LinkedList(8) // 48
        first.next = LinkedList(4)
        val second = LinkedList(5)  // 5

        val sum = solution.add(first, second) // 53
        assertEquals(3, sum?.data)
        assertEquals(5, sum?.next?.data)
    }

    @Test
    fun whenInputIsOneTwoDigitsAndASingleDigitWithCarries() {
        val first = LinkedList(8) // 98
        first.next = LinkedList(9)
        val second = LinkedList(5)  // 5

        val sum = solution.add(first, second) // 103
        assertEquals(3, sum?.data)
        assertEquals(0, sum?.next?.data)
        assertEquals(1, sum?.next?.next?.data)
    }

    @Test
    fun whenInputIsTwoDoubleDigitWithCarry() {
        val first = LinkedList(8) // 98
        first.next = LinkedList(9)
        val second = LinkedList(4)  // 74
        second.next = LinkedList(7)

        val sum = solution.add(first, second) // 172
        assertEquals(2, sum?.data)
        assertEquals(7, sum?.next?.data)
        assertEquals(1, sum?.next?.next?.data)
    }

    @Test
    fun whenInputIsTwoTripleDigitWithCarry() {
        val first = LinkedList(5) // 985
        first.next = LinkedList(8)
        first.next?.next = LinkedList(9)
        val second = LinkedList(4)  // 704
        second.next = LinkedList(0)
        second.next?.next = LinkedList(7)

        val sum = solution.add(first, second) // 1689
        assertEquals(9, sum?.data)
        assertEquals(8, sum?.next?.data)
        assertEquals(6, sum?.next?.next?.data)
        assertEquals(1, sum?.next?.next?.next?.data)
    }

    @Test
    fun whenInputIsTwoZero() {
        val first = LinkedList(0) // 0
        val second = LinkedList(0)  // 0

        val sum = solution.add(first, second) // 0
        assertEquals(0, sum?.data)
        assertNull(sum?.next)
    }

    @Test
    fun whenInputsAreUnEqual() {
        val first = LinkedList(9) // 999
        first.next = LinkedList(9)
        first.next?.next = LinkedList(9)
        val second = LinkedList(1)  // 1

        val sum = solution.add(first, second) // 1000
        assertEquals(0, sum?.data)
        assertEquals(0, sum?.next?.data)
        assertEquals(0, sum?.next?.next?.data)
        assertEquals(1, sum?.next?.next?.next?.data)
    }

    @Test
    fun whenSecondInputHasMoreDigits() {
        val first = LinkedList(9)  // 9
        val second = LinkedList(7) // 147
        second.next = LinkedList(4)
        second.next?.next = LinkedList(1)

        val sum = solution.add(first, second) // 156
        assertEquals(6, sum?.data)
        assertEquals(5, sum?.next?.data)
        assertEquals(1, sum?.next?.next?.data)
    }

    @Test
    fun whenCarryPropagationHappens() {
        val first = LinkedList(5)  // 55
        first.next = LinkedList(5)

        val second = LinkedList(5) // 55
        second.next = LinkedList(5)

        val sum = solution.add(first, second) // 110
        assertEquals(0, sum?.data)
        assertEquals(1, sum?.next?.data)
        assertEquals(1, sum?.next?.next?.data)
    }
}