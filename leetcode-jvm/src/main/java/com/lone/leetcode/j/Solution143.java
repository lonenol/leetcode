package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 思路:
 * 后半部的链表翻转,然后在一个一个交叉
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode post = reverse(slow.next);
        ListNode pre = head;
        slow.next = null;
        while (post != null) {
            ListNode preTmp = pre.next;
            pre.next = post;
            ListNode postTmp  = post.next;
            post.next = preTmp;
            pre = preTmp;
            post = postTmp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head, next = head.next, pre = null;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            cur.next = pre;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode listNode = ListNode.createList(new int[] {1, 2, 3, 4,5});
        solution143.reorderList(listNode);
        System.out.println(listNode);

    }
}
