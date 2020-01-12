package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 思路：
 * 1.反转之后删除第n个，然后在反转
 * 2. 快慢指针，快指针先走n，然后慢指针和快指针一起向前，知道快指针走到尾部，删除慢指针所在的节点。时间复杂度要比第一种少
 *
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        while (fast != null && n--!=0) {
            fast = fast.next;
        }
        /*如果不保证n是有效的，在这里应该做一次有效性校验，不过题目里做了保证就跳过了*/
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
