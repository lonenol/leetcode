package com.lone.leetcode.j;


/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class Solution557 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if(s.charAt(i)== ' ') {
                sb.append(" ");
                i++;
            } else {
                int nextSpace = s.indexOf(" ", i);
                if(nextSpace == -1) {
                    nextSpace = s.length();
                }
                sb.append(reverse(s, i, nextSpace-1));
                i  = nextSpace;
            }
        }
        return sb.toString();
    }

    private String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= start; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
