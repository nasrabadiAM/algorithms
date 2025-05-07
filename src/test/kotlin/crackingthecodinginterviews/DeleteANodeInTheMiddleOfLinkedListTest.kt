package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.DeleteANodeInTheMiddleOfLinkedList
import org.example.crackingthecodinginterviews.DeleteANodeInTheMiddleOfLinkedListImpl
import org.example.datastructure.LinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class DeleteANodeInTheMiddleOfLinkedListTest {

    private val solution: DeleteANodeInTheMiddleOfLinkedList = DeleteANodeInTheMiddleOfLinkedListImpl()

    @Test
    fun shouldDoNothingWhenPassedNodeIsASingleNode() {
        val firstNode = LinkedList(1)
        solution.delete(firstNode)
        assertNull(firstNode.next)
        assertEquals(1, firstNode.data)
    }

    @Test
    fun shouldDoNothingWhenPassedNodeIsTheLastNode() {
        val firstNode = LinkedList(1)
        val secondNode = LinkedList(2)
        firstNode.next = secondNode

        solution.delete(secondNode)

        assertEquals(firstNode.next, secondNode)
        assertEquals(firstNode.next?.data, secondNode.data)
        assertNull(secondNode.next)
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

        solution.delete(thirdNode)

        assertEquals(head, head)
        assertEquals(head.next, secondNode)
        assertEquals(4, thirdNode.data)
        assertNull(thirdNode.next)
    }

    @Test
    fun shouldRemoveFirstNodeWhenFirstNodePassed() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        solution.delete(head)

        assertEquals(2, head.data)
        assertEquals(3, secondNode.data)
        assertEquals(4, thirdNode.data)
        assertNull(thirdNode.next)
    }

    @Test
    fun shouldRemoveMiddleNodeWhenMiddleNodePassed() {
        val fifthNode = LinkedList(5)
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val head = LinkedList(1)
        head.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode
        forthNode.next = fifthNode

        solution.delete(thirdNode)

        assertEquals(1, head.data)
        assertEquals(2, secondNode.data)
        assertEquals(4, thirdNode.data)
        assertEquals(5, forthNode.data)
        assertNull(forthNode.next)
    }
}