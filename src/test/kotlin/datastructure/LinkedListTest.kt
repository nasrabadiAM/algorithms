package datastructure

import org.example.datastructure.LinkedList
import kotlin.test.Test
import kotlin.test.assertEquals

class LinkedListTest {

    @Test
    fun shouldLinkToNextItemInListWithSizeOfTwo() {
        val secondNode = LinkedList(1)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode

        assertEquals(secondNode, firstNode.next)
        assertEquals(secondNode.data, firstNode.next?.data)
    }

    @Test
    fun whenCallAppendToTailShouldAppendNodeToTailOfLinkedList() {
        val secondNode = LinkedList(2)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode

        val node = LinkedList(3)
        firstNode.appendToTail(node)

        assertEquals(secondNode, firstNode.next)
        assertEquals(secondNode.data, firstNode.next?.data)
        assertEquals(node, secondNode.next)
        assertEquals(node.next, null)
    }

    @Test
    fun whenCallAppendToTailShouldAppendNodeToTailOfLinkedListWithTwoLists() {
        val secondNode = LinkedList(2)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode

        val forthNode = LinkedList(4)
        val node = LinkedList(3)
        node.next = forthNode

        firstNode.appendToTail(node)

        assertEquals(secondNode, firstNode.next)
        assertEquals(secondNode.data, firstNode.next?.data)
        assertEquals(node, secondNode.next)
        assertEquals(node.next, forthNode)
        assertEquals(forthNode.next, null)
    }

    @Test
    fun shouldRemoveNodeInTheList() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(firstNode, 3)

        assertEquals(secondNode, head.next)
        assertEquals(forthNode, secondNode.next)
    }

    @Test
    fun shouldRemoveLastNodeInTheList() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(firstNode, 4)

        assertEquals(secondNode, head.next)
        assertEquals(thirdNode, secondNode.next)
        assertEquals(null, thirdNode.next)
    }

    @Test
    fun shouldRemoveFirstNodeInTheList() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(firstNode, 1)

        assertEquals(thirdNode, head.next)
        assertEquals(forthNode, thirdNode.next)
        assertEquals(null, forthNode.next)
    }

}