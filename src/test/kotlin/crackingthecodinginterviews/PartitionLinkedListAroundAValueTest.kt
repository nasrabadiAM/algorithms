package crackingthecodinginterviews

import org.example.crackingthecodinginterviews.PartitionLinkedListAroundAValue
import org.example.crackingthecodinginterviews.PartitionLinkedListAroundAValueImpl
import org.example.datastructure.LinkedList
import org.junit.jupiter.api.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class PartitionLinkedListAroundAValueTest {

    private val solution: PartitionLinkedListAroundAValue = PartitionLinkedListAroundAValueImpl()

    @Test
    fun shouldDoNothingWhenPassedNodeIsANullList() {
        val result = solution.partition(null, 1)
        assertNull(result)
    }

    @Test
    fun shouldDoNothingWhenPassedNodeIsASingleNode() {
        val head = LinkedList(1)
        val result = solution.partition(head, 1)
        assertEquals(head, result)
    }

    @Test
    fun shouldDoNothingWhenListWithSizeTwoIsOrdered() {
        val firstNode = LinkedList(1)
        val secondNode = LinkedList(3)
        firstNode.next = secondNode

        val result = solution.partition(firstNode, 2)

        assertNotNull(result)
        assertEquals(1, result.data)
        assertEquals(3, result.next?.data)
    }

    @Ignore
    @Test
    fun shouldOrderListWhenListWithSizeTwoIsNotOrdered() {
        val firstNode = LinkedList(3)
        val secondNode = LinkedList(1)
        firstNode.next = secondNode

        val result = solution.partition(firstNode, 2)

        assertNotNull(result)
        assertEquals(1, result.data)
        assertEquals(3, result.next?.data)
    }

    @Test
    fun shouldOrderListWhenListWithSizeThreeIsNotOrdered() {
        val firstNode = LinkedList(4)
        val secondNode = LinkedList(3)
        val thirdNode = LinkedList(2)
        firstNode.next = secondNode
        secondNode.next = thirdNode

        val result = solution.partition(firstNode, 2)

        assertNotNull(result)
        assertEquals(2, result.data)
        assertEquals(4, result.next?.data)
        assertEquals(3, result.next?.next?.data)
    }

}