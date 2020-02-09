package com.lone.leetcode.j;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 思路:用两个栈,标准做法
 */
public class Solution232 {
}

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> reverse;
    private Integer front;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        reverse = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()) {
            front = x;
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!reverse.isEmpty()) {
            return reverse.pop();
        }
        while (!stack.isEmpty()){
            reverse.push(stack.pop());
        }
        return reverse.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!reverse.isEmpty()) {
            return reverse.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return reverse.isEmpty() && stack.isEmpty();
    }
}
