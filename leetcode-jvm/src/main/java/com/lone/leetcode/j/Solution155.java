package com.lone.leetcode.j;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 思路: 用栈实现栈
 */
public class Solution155 {

}


class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x < min.peek() ) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}