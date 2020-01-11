package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * 思路：
 * 1. 用set 去重
 * 2. 快慢指针
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow == null || fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }
}
