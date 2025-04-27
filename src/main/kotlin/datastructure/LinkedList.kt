package org.example.datastructure

data class LinkedList<T>(val data: T) {
    var next: LinkedList<T>? = null

    fun appendToTail(node: LinkedList<T>) {
        var currentNode = this
        while (currentNode.next != null) {
            currentNode = currentNode.next!!
        }
        currentNode.next = node
    }

    fun removeNode(head: LinkedList<T>, data: Int): LinkedList<T> {
        // remove the node passed here from the linked list
        var currentNode: LinkedList<T>? = this
        var previousNode: LinkedList<T>? = null
        while (currentNode != null) {
            if (currentNode.data == data) {
                if (previousNode == null) { // this is first node
                    return currentNode.next!!
                } else {
                    previousNode.next = currentNode.next
                }
            }
            previousNode = currentNode
            currentNode = currentNode.next
        }
        return head
    }
}