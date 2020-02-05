package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 思路: 按要求就是自底向上的递归,是标准的归并排序,比较适合链表,详见算法第四版,归并排序那一节
 */
public class Solution148 {

    public ListNode sortList(ListNode head) {
        int len = len(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 1; i < len; i = i * 2) {
            mergeSort(dummy, i);
        }
        return dummy.next;
    }

    private void mergeSort(ListNode dummy, int num) {
        ListNode pre = dummy;
        while (pre.next != null) {
            ListNode slow = pre.next, fast = pre.next;
            ListNode slowPre = pre, fastPre = pre;
            for (int i = 0; i < num && fast != null; i++) {
                fast = fast.next;
                fastPre = fastPre.next;
            }
            if (fast == null) {
                return;
            }
            int slowIdx = num, fastIdx = num;
            while (slowIdx >= 1 && fastIdx >= 1 && slow != null && fast!=null) {
                if (slow.val > fast.val) {
                    ListNode tmp = fast.next;
                    slowPre.next = fast;
                    fast.next = slow;
                    slowPre = fast;
                    fastPre.next = tmp;
                    fast = tmp;
                    fastIdx--;
                } else {
                    slowPre = slow;
                    slow = slow.next;
                    slowIdx--;
                }
            }

            while (fastIdx-- >= 1 && fast != null) {
                fastPre = fast;
                fast = fast.next;
                pre = fastPre;
            }

            while (slowIdx-- >= 1 && slow != null) {
                slowPre = slow;
                slow = slow.next;
                pre = slowPre;
            }

        }

    }

    private int len(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[] {4, 3, 2, 1});
        Solution148 solution148 = new Solution148();
        solution148.sortList(head);
    }
}
