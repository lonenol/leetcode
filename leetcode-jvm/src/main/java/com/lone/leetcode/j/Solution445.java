package com.lone.leetcode.j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 思路:
 * 1. 翻转相加,然后再翻转.比较好处理进位以及对其
 * 2. 先转成数字,相加,然后转回链表
 * 3. 算出长度,找到七点,进行不进位加法,然后统一处理进位,这种处理起来比较麻烦
 * 4. 进栈,然后栈顶相加,逆向构建链表,和翻转链表在本质上一样
 * 5. 递归,本质上也是进栈,但是需要处理长度的问题,处理上也比较麻烦
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return  l1;

        Deque<Integer> deque1 = new LinkedList<>();
        while ((l1 != null)) {
            deque1.push(l1.val);
            l1 = l1.next;
        }
        Deque<Integer> deque2 = new LinkedList<>();
        while (l2 != null) {
            deque2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int val = popOrZero(deque1) + popOrZero(deque2) + carry;
            carry = val / 10;
            ListNode n = new ListNode(val % 10);
            n.next = head;
            head = n;
        }
        if (carry == 1) {
            ListNode n = new ListNode(1);
            n.next = head;
            head = n;
        }
        return head;
    }

    private int popOrZero(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return 0;
        }
        return deque.pop();
    }
}
