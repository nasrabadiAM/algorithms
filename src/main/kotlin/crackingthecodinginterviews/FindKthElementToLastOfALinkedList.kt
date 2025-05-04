package org.example.crackingthecodinginterviews

import org.example.datastructure.LinkedList

/**
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
 */
interface FindKthElementToLastOfALinkedList {
    fun find(head: LinkedList<Int>, kthElement: Int): LinkedList<Int>?
}

/**
 * time complexity: O(n)
 * implementation time: 1hr
 */
class FindKthElementToLastOfALinkedListImpl : FindKthElementToLastOfALinkedList {
    override fun find(
        head: LinkedList<Int>,
        kthElement: Int,
    ): LinkedList<Int>? {
        var currentNode: LinkedList<Int>? = head
        var kthElementItem: LinkedList<Int>? = null
        var distance = 0
        while (currentNode != null) {
            if (distance + 1 == kthElement) {
                if (kthElementItem == null) {
                    kthElementItem = head
                } else {
                    kthElementItem = kthElementItem.next
                }
            } else {
                distance += 1
            }
            currentNode = currentNode.next
        }
        return kthElementItem
    }
}