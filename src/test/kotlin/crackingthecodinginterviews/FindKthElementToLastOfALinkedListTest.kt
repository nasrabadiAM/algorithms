package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.FindKthElementToLastOfALinkedList
import org.example.crackingthecodinginterviews.FindKthElementToLastOfALinkedListImpl
import org.example.datastructure.LinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class FindKthElementToLastOfALinkedListTest {

    private val solution: FindKthElementToLastOfALinkedList = FindKthElementToLastOfALinkedListImpl()

    @Test
    fun shouldReturnFirstElementIfItsSizeIs1AndWeWantFirstElement() {
        val firstNode = LinkedList(1)
        val kthElement = solution.find(firstNode, 1)
        assertEquals(firstNode, kthElement)
    }

    @Test
    fun shouldReturnNullIfItsSizeIs1AndWeWantSecondElement() {
        val firstNode = LinkedList(1)
        val kthElement = solution.find(firstNode, 2)
        assertNull(kthElement)
    }

    @Test
    fun shouldReturnNullIfWeWantNegativeElement() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val kthElement = solution.find(head, -1)
        assertNull(kthElement)
    }

    @Test
    fun shouldReturnElementInTheListWhenKthElementIsInTheMiddle() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val kthElement = solution.find(head, 3)
        assertEquals(secondNode, kthElement)
    }

    @Test
    fun shouldReturnElementWhenWeWantFirstElementFromTheEnd() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val kthElement = solution.find(head, 1)
        assertEquals(forthNode, kthElement)
    }

    @Test
    fun shouldReturnElementWhenWeWantLastElementFromTheEnd() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val kthElement = solution.find(head, 4)
        assertEquals(head, kthElement)
    }
}