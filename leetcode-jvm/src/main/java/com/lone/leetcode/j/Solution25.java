package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 普通的链表处理，注意边界值。
 */
public class Solution25 {
   public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode res = head;
        ListNode node = findKth(pre, k);
        if (node != null) {
            res = node;
        }
        while (node != null) {
            reverse(pre, node);
            pre = head;
            head = head.next;
            node = findKth(pre, k);
        }
        return res;
    }

    private void reverse(ListNode dump, ListNode tail) {
       ListNode head =dump.next;
       ListNode next = head.next;
        while (head != tail) {
            head.next = tail.next;
            tail.next = head;
            head = next;
            next = head.next;
        }
        dump.next = tail;
    }

    private ListNode findKth(ListNode node, int k) {
        while (k-- > 0 && node != null) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        Solution25 solution25 = new Solution25();
        solution25.reverseKGroup(head, 2);
    }
}
