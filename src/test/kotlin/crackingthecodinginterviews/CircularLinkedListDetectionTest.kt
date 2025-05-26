package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.CircularDetectionFloydImpl
import org.example.crackingthecodinginterviews.CircularDetectionImpl
import org.example.crackingthecodinginterviews.DetectCirculation
import org.example.datastructure.LinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CircularLinkedListDetectionTest {

    private val solution2: DetectCirculation = CircularDetectionImpl()
    private val solution: DetectCirculation = CircularDetectionFloydImpl()

    @Test
    fun shouldReturnNullWhenThereIsAListWithSize1() {
        val head = LinkedList(1)
        val result = solution.isCircular(head)
        assertNull(result)
    }

    @Test
    fun shouldReturnNullWhenThereIsANonCircularListWithSize4() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val result = solution.isCircular(head)

        assertNull(result)
    }

    @Test
    fun shouldReturnHeadWhenThereIsACircularListWithSize4() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode
        forthNode.next = head

        val result = solution.isCircular(head)

        assertEquals(head.data, result)
    }

    @Test
    fun shouldReturnSecondNodeWhenThereIsACircularListWithSize4() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode
        forthNode.next = secondNode

        val result = solution.isCircular(head)

        assertEquals(secondNode.data, result)
    }

    @Test
    fun shouldReturnForthNodeWhenThereIsACircularListWithSize4() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode
        forthNode.next = forthNode

        val result = solution.isCircular(head)

        assertEquals(forthNode.data, result)
    }

    @Test
    fun shouldReturnHeadNodeWhenThereIsACircularListWithDuplicateValuesAndSize4() {
        val forthNode = LinkedList(2)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode
        forthNode.next = head

        val result = solution.isCircular(head)

        assertEquals(head.data, result)
    }

    @Test
    fun shouldReturnHeadNodeWhenThereIsACircularListWithSize1() {
        val head = LinkedList(1)
        head.next = head

        val result = solution.isCircular(head)

        assertEquals(head.data, result)
    }

    @Test
    fun shouldReturnNullWhenInputIsNull() {
        val result = solution.isCircular(null)

        assertNull(result)
    }

    @Test
    fun shouldReturnNullWhenThereIsAListWithDuplicateValues() {
        val forthNode = LinkedList(2)
        val thirdNode = LinkedList(2)
        val secondNode = LinkedList(2)
        val head = LinkedList(2)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val result = solution.isCircular(head)

        assertNull(result)
    }
}