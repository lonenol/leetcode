package com.lone.leetcode.j;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }


    public static ListNode createList(int[] arr) {
        ListNode dump = new ListNode(-1);
        ListNode head = dump;
        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dump.next;
    }

    //@Override
    //public String toString() {
    //    StringBuilder sb = new StringBuilder("ListNode:");
    //    ListNode head = this;
    //    while (head != null) {
    //        sb.append(head.val).append("  ");
    //        head = head.next;
    //    }
    //    return sb.toString();
    //}
}
