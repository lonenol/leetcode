package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, next = head;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return pre;
    }

    public ListNode _reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
