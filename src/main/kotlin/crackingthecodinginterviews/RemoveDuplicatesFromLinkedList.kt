package org.example.crackingthecodinginterviews

import org.example.datastructure.LinkedList

/**
 * write code to remove duplicates from an unsorted list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 */
interface RemoveDuplicatesFromLinkedList {

    fun removeDuplicates(head: LinkedList<Int>)
}

/**
 *
 * time complexity: O(n^2)
 * implementation time: 1hr
 */
class RemoveDuplicatesFromLinkedListImpl : RemoveDuplicatesFromLinkedList {
    override fun removeDuplicates(head: LinkedList<Int>) {
        var currentNode: LinkedList<Int>? = head
        while (currentNode?.next != null) {
            val newHead = currentNode.next?.removeNode(currentNode.data)
            currentNode.next = newHead
            currentNode = newHead
        }
    }
}