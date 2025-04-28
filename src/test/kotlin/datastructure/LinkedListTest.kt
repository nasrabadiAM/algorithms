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
    fun shouldRemoveNodeInTheMiddleOfTheList() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(3)

        assertEquals(firstNode, head)
        assertEquals(secondNode, head?.next)
        assertEquals(forthNode, secondNode.next)
        assertEquals(null, forthNode.next)
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

        val head = firstNode.removeNode(4)

        assertEquals(secondNode, head?.next)
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

        val head = firstNode.removeNode(1)

        assertEquals(thirdNode, head?.next)
        assertEquals(forthNode, thirdNode.next)
        assertEquals(null, forthNode.next)
    }

    @Test
    fun shouldRemoveSingleNodeInTheList() {
        val firstNode = LinkedList(1)

        val head = firstNode.removeNode(1)

        assertEquals(null, head)
        assertEquals(null, head?.next)
    }

    @Test
    fun shouldRemoveTwoNodeWhenThereIsTwoItemInTheList() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(3)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(3)

        assertEquals(firstNode, head)
        assertEquals(forthNode, head?.next)
        assertEquals(null, forthNode.next)
    }

    @Test
    fun shouldRemoveTwoNodeWhenThereIsTwoItemInTheEndOfTheList() {
        val forthNode = LinkedList(3)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(2)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(3)

        assertEquals(firstNode, head)
        assertEquals(secondNode, head?.next)
        assertEquals(null, secondNode.next)
    }

    @Test
    fun shouldRemoveTwoNodeWhenThereIsTwoItemInTheBeginningOfTheList() {
        val forthNode = LinkedList(4)
        val thirdNode = LinkedList(3)
        val secondNode = LinkedList(1)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(1)

        assertEquals(thirdNode, head)
        assertEquals(forthNode, head?.next)
        assertEquals(null, forthNode.next)
    }

    @Test
    fun shouldRemoveAllItemsWhenAllAreSame() {
        val forthNode = LinkedList(1)
        val thirdNode = LinkedList(1)
        val secondNode = LinkedList(1)
        val firstNode = LinkedList(1)
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = forthNode

        val head = firstNode.removeNode(1)

        assertEquals(null, head)
    }
}