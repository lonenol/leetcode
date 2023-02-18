package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 思路:感觉是把奇数节点向前移动就行
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, fast = cur.next;
        while (fast != null && fast.next != null) {
            ListNode next = fast.next;
            fast.next = next.next;
            ListNode tmp = cur.next;
            cur.next = next;
            next.next = tmp;
            cur = next;
            fast = fast.next;
        }
        return head;
    }
}
