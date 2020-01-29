package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 思路: 就是捣腾链表..
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                ListNode tmp = node.next;
                node.next = tmp.next;
                tmp.next = null;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
