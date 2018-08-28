package com.lone.leetcode.j;

/**
 * /** * * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class SolutionAddTwoSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode first = l1,second = l2, current = head;
        int extra = 0;
        while (first != null || second != null) {
            int sums = (first == null ? 0 : first.val) + (second == null ? 0 : second.val) + extra;
            current.next = new ListNode(sums % 10);
            extra = sums / 10;
            current = current.next;
            first = first == null ? null : first.next;
            second = second == null ? null : second.next;
        }
        if (extra > 0) {
            current.next = new ListNode(extra);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}
