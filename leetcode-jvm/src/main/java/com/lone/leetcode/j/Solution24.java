package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 思路： 需要处理三个指针
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = head.next;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            if (pre != null) {
                pre.next = next;
            }
            pre =cur;
            cur = cur.next;
        }
        return ret;
    }
}
