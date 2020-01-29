package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 思路:就是反转..要注意第 m 个链表的 next 要设置成 第 n 个的 next. 第 n 个的 next 要设置成第 m 个的 pre
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        int idx = 1;
        ListNode cur = head,prev = null;
        while (idx <= m - 1) {
            prev = cur;
            cur = cur.next;
            idx++;
        }
        ListNode con = prev, tail = cur;
        ListNode third = null;
        while (idx <= n) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            idx++;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[] {3, 5});
        Solution92 solution92 = new Solution92();
        System.out.println(solution92.reverseBetween(head, 1, 1));
    }
}
