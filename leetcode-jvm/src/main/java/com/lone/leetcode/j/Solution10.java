package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 思路:
 * 1. 回溯,这个比较简单,很符合直觉
 * 2. 动态规划
 */
public class Solution10 {

    public boolean isMatch(String text, String pattern) {
        int m = text.length(), n = pattern.length();
        if (n == 0) {
            return m == 0;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m ; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean firstMatch = i < m &&(text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                if (j + 1 < n && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i+1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public boolean isMatch_backtrace(String text, String pattern) {
        return matches(text, 0, pattern, 0);

    }

    private boolean matches(String text, int ti, String pattern, int pi) {
        if (pi == pattern.length()) {
            return ti == text.length();
        }

        boolean firstCharMatch = ti < text.length() && (text.charAt(ti) == pattern.charAt(pi) || pattern.charAt(pi)
            == '.');
        if (pi < pattern.length() - 1 && pattern.charAt(pi + 1) == '*') {
            return (firstCharMatch && matches(text, ti + 1, pattern, pi))
                || matches(text, ti, pattern, pi + 2);

        }
        return firstCharMatch && matches(text, ti + 1, pattern, pi + 1);
    }

    public static void main(String[] args) {
        Solution10 s10 = new Solution10();
        System.out.println(s10.isMatch("aab", "c*a*b"));
        //        System.out.println(s10.isMatch("aa", "a*"));
        //        System.out.println(s10.isMatch("ab", ".*"));
    }

}
