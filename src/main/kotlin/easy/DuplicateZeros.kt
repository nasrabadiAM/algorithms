package org.example.easy


/**
 * [1089. Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/description/?envType=problem-list-v2&envId=array)
 *
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 * */

interface DuplicateZeros {
    fun duplicate(arr: IntArray)
}

/**
 *
 * duration: 18ms
 * memory: 46MB
 * beats: 14%
 * time: 3h
 */
class DuplicateZerosImpl : DuplicateZeros {
    override fun duplicate(arr: IntArray) {
        if (arr.size <= 1) return
        var lastItem = arr.first()
        var shouldShift = false
        var index = 1
        while (index < arr.size) {
            val currentItem = arr[index]
            if (lastItem == 0) {
                arr[index] = 0
                shouldShift = true
            }
            if (shouldShift) {
                var last = currentItem
                val shiftStartIndex = index + 1
                for (shiftIndex in shiftStartIndex until arr.size) {
                    val currentValue = arr[shiftIndex]
                    arr[shiftIndex] = last
                    last = currentValue
                }
                shouldShift = false
                index++
            }

            index++
            lastItem = currentItem
        }
    }
}