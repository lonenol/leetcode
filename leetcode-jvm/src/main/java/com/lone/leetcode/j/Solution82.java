package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 思路: 也是捣腾指针..
 *
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            if(head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pre.next = head.next;
                head.next = null;
                head = pre.next;
            }else {
                pre = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
