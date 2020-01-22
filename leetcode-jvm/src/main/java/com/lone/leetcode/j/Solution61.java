package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 思路: 1. 一步一步移动,移动 k 次
 * 2. 快慢指针,快指针移动 k 步,然后满指针从头开始,移动到快指针的位置 达到尾之后从头开始
 * 3. 直接计算出最终的状态 ,求出链表的长度 n,  m = k/n ,将链表  最后 m 个节点移动到头部就是最终结果.
 * 4. 弄成一个环,然后算出新的头部所在地,重新断开链表.
 *
 * 下面是第三种
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        int n = len(head);
        if (n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int m = k % n;
        ListNode fast = head, slow = head;
        for (int i = 1; i <= m; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    private int len(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }
}
