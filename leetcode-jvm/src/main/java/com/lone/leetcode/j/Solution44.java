package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {return s.length() == 0;}
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = m; i >=0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    dp[i][j] = true;
                } else if(i == m) {
                    dp[i][j] = p.charAt(j) == '*' && dp[i][j + 1];
                } else if(j == n) {
                    dp[i][j] = false;
                }  else {
                    if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if(p.charAt(j) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[0][0];
    }

}
