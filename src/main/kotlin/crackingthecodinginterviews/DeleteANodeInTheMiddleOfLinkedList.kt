package org.example.crackingthecodinginterviews

import org.example.datastructure.LinkedList

/**
 * 2.3 Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 *
 * EXAMPLE:
 * Input: the node c from the linked list a->b->c->d->e
 * Output: nothing is returned, but the new linked list looks like a->b->d->e
 */
interface DeleteANodeInTheMiddleOfLinkedList {
    fun delete(node: LinkedList<Int>)
}

/**
 * time complexity: O(n)
 * implementation time: 1hr
 */
class DeleteANodeInTheMiddleOfLinkedListImpl : DeleteANodeInTheMiddleOfLinkedList {
    override fun delete(node: LinkedList<Int>) {
        var currentNode: LinkedList<Int>? = node
        while (currentNode?.next != null) {
            currentNode.data = currentNode.next!!.data
            if (currentNode.next?.next == null) {
                currentNode.next = null
            }
            currentNode = currentNode.next
        }
    }
}