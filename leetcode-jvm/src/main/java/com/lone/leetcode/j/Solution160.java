package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 思路：
 * 1. 最难的地方在于对空间复杂度有要求，不能使用额外的空间，所以只能从指针上着手，
 * 最后只能想到求出两个链表的长度，让长的一方前进到和短的乙方对其，然后共同前进，判断是否存在相等的节点
 *
 * 2. 官方题解有个更巧妙的思路，更简洁，时间复杂度上应该基本一样 ：
 *  假设相交部分的长度是 c， a + b - c == b + a -c,因此弄两个指针，各自遍历a和b，遍历到结尾之后便利另一个链表，直至相遇
 *  若不存在交点，则都会遍历到空节点
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);
        if (lengthA > lengthB) {
            ListNode aa = skipN(headA, lengthA - lengthB);
            return getIntersect(aa, headB);
        } else {
            ListNode bb = skipN(headB, lengthB - lengthA);
            return getIntersect(headA, bb);
        }
    }


    private ListNode getIntersect(ListNode first, ListNode sec) {
        while (first != null && sec != null) {
            if (first == sec) {
                return first;
            } else {
                first = first.next;
                sec = sec.next;
            }
        }
        return null;
    }
    private ListNode skipN(ListNode node, int num) {
        while (num-- > 0) {
            node = node.next;
        }
        return node;
    }

    private int length(ListNode node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }
}
