package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 思路:
 * 1. 找到长度,逆转后半段,然后在中间位置和头部各放一个指针,比较. ,然后再逆转,空间复杂度最低
 * 2. 所有结点入栈,然后依次出栈和链表依次比较.  最符合直觉
 * 3. 递归,本质也是用栈,不过不太好想
 * 4. 放到链表里,然后双指针对向比较
 *
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode frontTail = moveHalf(head);
        ListNode backHead = reverse(frontTail.next);

        ListNode first = head, second = backHead;
        boolean res = true;
        while (second != null) {
            if (first.val != second.val) {
               res = false;
               break;
            }
            first = first.next;
            second = second.next;
        }
        frontTail.next = reverse(backHead);
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    private ListNode moveHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

}
