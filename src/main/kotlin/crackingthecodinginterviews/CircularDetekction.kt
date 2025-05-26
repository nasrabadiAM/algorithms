package org.example.crackingthecodinginterviews

import org.example.datastructure.LinkedList


/**
 * 2.6 Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 * Definition: Circular linked-list: A (corrupt) linked list in which
 * a node's next pointer points to an earlier node, so as to make a loop
 * in the linked list.
 * EXAMPLE:
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 */
interface DetectCirculation {
    fun isCircular(head: LinkedList<Int>?): Int?
}

/**
 * time complexity: n^2
 * implementation time: 30 min
 * this implementation has a known defect which can't detekt linked-list with duplicate values.
 */
class CircularDetectionImpl : DetectCirculation {

    override fun isCircular(head: LinkedList<Int>?): Int? {
        var currentNode = head
        val visited = mutableSetOf<LinkedList<Int>>()
        while (currentNode != null) {
            if (visited.contains(currentNode)) {
                return currentNode.data
            }
            visited.add(currentNode)
            currentNode = currentNode.next
        }
        return null
    }
}

/**
 * Floyd's Cycle/Fast-Slow Pointer Algorithm
 * time complexity: O(n)
 * space complexity: O(1)
 * implementation time: 30 min
 */
class CircularDetectionFloydImpl : DetectCirculation {

    override fun isCircular(head: LinkedList<Int>?): Int? {
        var fast = head
        var slow = head
        while (fast != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (fast == slow) {
                break
            }
        }
        if (fast == null) return null
        fast = head
        while (fast != slow) {
            fast = fast?.next
            slow = slow?.next
        }
        return slow?.data
    }
}