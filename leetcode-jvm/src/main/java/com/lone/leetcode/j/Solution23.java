package com.lone.leetcode.j;

/**
 * @author ljl133110
 * @date 2019-06-05
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        boolean flag = true;
        ListNode cur = head;
        while (flag) {
            flag = false;
            ListNode node = null;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode tmp = lists[i];
                if (tmp == null) {
                    continue;
                }
                flag = true;
                if (node == null || node.val > tmp.val) {
                    node = tmp;
                    index = i;
                }
            }
            if (index != -1) {
                lists[index] = lists[index].next;
                cur.next = node;
                cur = cur.next;
            }

        }
        return head.next;
    }
}


