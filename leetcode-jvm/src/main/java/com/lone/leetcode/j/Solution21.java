package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * @author ljl133110
 * @date 2018-12-15
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode ret = head;
        ListNode left = l1;
        ListNode right = l2;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        while (left != null) {
            head.next = left;
            left = left.next;
            head = head.next;
        }
        while (right != null) {
            head.next = right;
            right = right.next;
            head = head.next;
        }
        return ret.next;
    }
}
