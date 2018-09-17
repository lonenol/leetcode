package com.lone.leetcode.k

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
class Solution2 {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result =  ListNode(-1)
        var first = l1
        var second = l2
        var current = result
        var extra = 0
        while (first != null || second != null) {
            var sums = (first?.`val`?:0) +(second?.`val`?:0) + extra
            current.next = ListNode(sums % 10)
            extra = sums /10
            first = first?.next
            second = second?.next
            current = current.next!!
        }
        if (extra > 0) {
            current.next = ListNode(extra)
        }
        return result.next
    }


}

fun main(args: Array<String>) {
    val solutionTwoSum = Solution2()

    var result = solutionTwoSum.addTwoNumbers(create(0), create(9, 1, 6))
    while (result != null) {
        println(result.`val`)
        result = result.next
    }


}

fun create(vararg value: Int): ListNode {
    var first = ListNode(0)
    var result = first
    value.forEach {
        result.next = ListNode(it)
        result = result.next!!
    }
    return first.next!!
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}