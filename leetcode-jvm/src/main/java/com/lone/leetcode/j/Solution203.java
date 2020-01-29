package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 思路: 无
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                ListNode tmp = cur.next;
                cur.next = null;
                pre.next = tmp;
                cur = tmp;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
