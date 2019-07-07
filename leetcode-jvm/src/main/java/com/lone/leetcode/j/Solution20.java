package com.lone.leetcode.j;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author ljl133110
 * @date 2018-12-06
 */
public class Solution20 {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(match(stack,'(')) {break;} else {return false;}
                case ']':
                    if(match(stack,'[')) {break;} else {return false;}
                case '}':
                    if(match(stack,'{')) {break;} else {return false;}
                default:break;
            }
        }
        return stack.isEmpty();
    }

    private boolean match(LinkedList<Character> stack, char expect) {
        return !stack.isEmpty() && stack.pop() == expect;
    }
}
