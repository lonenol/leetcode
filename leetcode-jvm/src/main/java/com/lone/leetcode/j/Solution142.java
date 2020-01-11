package com.lone.leetcode.j;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 思路：
 * 1. set存放，如果有环，set.contains(node) == true的值就是结果
 * 2. 快慢指针，需要拿起草稿纸了。。
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
