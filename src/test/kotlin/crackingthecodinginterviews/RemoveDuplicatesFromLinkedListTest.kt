package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.RemoveDuplicatesFromLinkedList
import org.example.crackingthecodinginterviews.RemoveDuplicatesFromLinkedListImpl
import org.example.datastructure.LinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RemoveDuplicatesFromLinkedListTest {

    private val solution: RemoveDuplicatesFromLinkedList = RemoveDuplicatesFromLinkedListImpl()

    @Test
    fun shouldDoNothingWhenListSizeIs1() {
        val head = LinkedList(1)
        solution.removeDuplicates(head)
        assertEquals(1, head.data)
        assertEquals(null, head.next)
    }

    @Test
    fun shouldRemoveDuplicateWhenSizeIs2() {
        val head = LinkedList(1)
        val secondNode = LinkedList(1)
        head.next = secondNode
        solution.removeDuplicates(head)
        assertEquals(1, head.data)
        assertEquals(null, head.next)
    }

    @Test
    fun shouldNotRemoveAnyWhenSizeIs2AndThereIsNoDuplicate() {
        val head = LinkedList(1)
        val secondNode = LinkedList(2)
        head.next = secondNode
        solution.removeDuplicates(head)
        assertEquals(1, head.data)
        assertEquals(2, head.next?.data)
        assertEquals(null, head.next?.next)
    }

    @Test
    fun shouldNotRemoveAnyWhenSizeIs4AndThereIsNoDuplicate() {
        val head = LinkedList(1)
        val secondNode = LinkedList(2)
        val thirdNode = LinkedList(3)
        val forthNode = LinkedList(4)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        solution.removeDuplicates(head)

        assertEquals(1, head.data)
        assertEquals(2, head.next?.data)
        assertEquals(3, head.next?.next?.data)
        assertEquals(4, head.next?.next?.next?.data)
        assertEquals(null, head.next?.next?.next?.next)
    }

    @Test
    fun shouldRemoveDuplicatesWhenSizeIs4AndThereIsThreeDuplicate() {
        val head = LinkedList(1)
        val secondNode = LinkedList(2)
        val thirdNode = LinkedList(1)
        val forthNode = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        solution.removeDuplicates(head)

        assertEquals(1, head.data)
        assertEquals(2, head.next?.data)
        assertEquals(null, head.next?.next)
    }

    @Test
    fun shouldRemoveDuplicatesWhenSizeIs5AndAllAreTheSame() {
        val head = LinkedList(1)
        val secondNode = LinkedList(1)
        val thirdNode = LinkedList(1)
        val forthNode = LinkedList(1)
        val fifthNode = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode
        forthNode.next = fifthNode

        solution.removeDuplicates(head)

        assertEquals(1, head.data)
        assertEquals(null, head.next?.data)
        assertEquals(null, head.next)
    }

    @Test
    fun shouldRemoveDuplicatesWhenSizeIs5AndThereIsTwoDuplicates() {
        val head = LinkedList(1)
        val secondNode = LinkedList(2)
        val thirdNode = LinkedList(3)
        val forthNode = LinkedList(4)
        val fifthNode = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode
        forthNode.next = fifthNode

        solution.removeDuplicates(head)

        assertEquals(1, head.data)
        assertEquals(2, head.next?.data)
        assertEquals(3, head.next?.next?.data)
        assertEquals(4, head.next?.next?.next?.data)
        assertEquals(null, head.next?.next?.next?.next)
    }
}