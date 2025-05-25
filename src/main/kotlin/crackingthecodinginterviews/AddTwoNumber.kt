package org.example.crackingthecodinginterviews

import org.example.datastructure.LinkedList


/**
 * 2.5 You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order,
 * such that the 1's digit is at the head of the list. write a function that
 * adds the two numbers and returns the sum as a linked list.
 * Input: (7->1->6) + (7->1->6) that is 617 + 295
 * Output: (2->1->9). That is 912.
 */
interface AddTwoNumber {
    fun add(first: LinkedList<Int>?, second: LinkedList<Int>?): LinkedList<Int>?
}

/**
 * time complexity: O(Max(M,N))
 * implementation time: 1hr
 */
class AddTwoNumberImpl : AddTwoNumber {

    override fun add(
        first: LinkedList<Int>?,
        second: LinkedList<Int>?
    ): LinkedList<Int>? {
        var currentFirst = first
        var currentSecond = second
        var result: LinkedList<Int>? = null
        var resultCurrent: LinkedList<Int>? = null
        var carry = 0
        while (currentSecond != null || currentFirst != null || carry != 0) {
            val sum = (currentFirst?.data ?: 0) + (currentSecond?.data ?: 0) + carry
            carry = sum / 10
            val sumValue = sum % 10
            if (result == null) {
                result = LinkedList(sumValue)
                resultCurrent = result
            } else {
                resultCurrent!!.next = LinkedList(sumValue)
                resultCurrent = resultCurrent.next
            }
            currentFirst = currentFirst?.next
            currentSecond = currentSecond?.next

        }
        return result
    }
}