package org.example.crackingthecodinginterviews

import org.example.datastructure.LinkedList


/**
 * 2.4 Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than
 * or equal to x.
 */
interface PartitionLinkedListAroundAValue {
    fun partition(head: LinkedList<Int>?, split: Int): LinkedList<Int>?
}

/**
 * time complexity:
 * implementation time:
 */
class PartitionLinkedListAroundAValueImpl : PartitionLinkedListAroundAValue {

    override fun partition(head: LinkedList<Int>?, split: Int): LinkedList<Int>? {
        var newHead: LinkedList<Int>? = head
        var current = head
        var end: LinkedList<Int>? = null
        var previousNode: LinkedList<Int>? = null
        while (current != null) { // (3)-2-4, current=3, newHead=3
            if (current.next == null) {
                break
            }
            if (current.data > split) {
                if (end == null) {
                    var currentNode = current
                    while (currentNode != null) {
                        if (currentNode.next == null) {
                            end = currentNode
                        }
                        currentNode = currentNode.next
                    }
                } // 4-3-2, current=4, end=2
                // move to last: move it to the end of the list

                if (previousNode == null) {
                    newHead = current.next // (3)-2-4, current=3, newHead=2 // 4-3-2, current=4, end=2, newHead=3
                } else {
                    previousNode.next = current.next
                }
                val newEnd = current
                newEnd.next = null
                end!!.next = newEnd
                end = newEnd
                current = current.next
                continue
            } else {
                // move it to the first of the list
            }
            previousNode = current
            current = current.next
        }
        return newHead
    }
}