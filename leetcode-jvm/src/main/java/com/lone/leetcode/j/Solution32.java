package com.lone.leetcode.j;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 思路:
 * 1. 暴力法
 * 利用判断括号是否匹配的方法 O(n)
 * 2. 动态规划
 *  动态规划稍微有一点绕
 * 3. 堆栈
 *
 */
public class Solution32 {

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i  = 0; i< s.length(); i++){
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(i - stack.peek(), max);
                }
            }
        }
        return max;
    }
}
