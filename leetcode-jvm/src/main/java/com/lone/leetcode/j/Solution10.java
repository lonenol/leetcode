package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * @author lone
 * @date 2018/10/22
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        //都是空 true
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        // x* 号代表任意个x,包括0
        if (s.isEmpty() && p.length() == 2 && p.charAt(1) == '*') {
            return true;
        }
        int i = 0, j = 0;
        while (i > 0 && i < s.length() && j < p.length()) {
            /**
             * 特殊处理.*
             */
            if (p.charAt(j) == '.' && j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (j + 1 == p.length() - 1 || isEffectiveZeroFrom(p, j + 2)) {
                    return true;
                }
                j = j + 2;
                //比较p后面的元素能否匹配到s最后几个元素即可
                i = s.length() - (p.length() - j);
            } else if (p.charAt(j) == '.' || (s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (p.charAt(j) == '*' && p.charAt(j - 1) == s.charAt(i)) {
                i++;
                if (i == s.length()) {
                    j++;
                }
            } else {
                return false;
            }

        }
        /**
         * 如果 p 还剩下 x*,也可以视为相等
         */
        return (i == s.length() && j == p.length()) || (j == p.length() - 2 && p.charAt(j + 1) == '*');

    }

    private boolean isEffectiveZeroFrom(String p, int from) {
        int start = from + 1;
        while (start < p.length()) {
            if (p.charAt(start) != '*') {
                return false;
            } else {
                if (start == p.length() - 1) {
                    return true;
                }
                start += 2;
            }
        }
        return false;


    }


    public static void main(String[] args) {
        Solution10 s10 = new Solution10();
        System.out.println(s10.isMatch("aab", "c*a*b"));
//        System.out.println(s10.isMatch("aa", "a*"));
//        System.out.println(s10.isMatch("ab", ".*"));
    }

}
