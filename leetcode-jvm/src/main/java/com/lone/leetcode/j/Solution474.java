package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * 思路:典型的背包问题,回溯和动态规划
 *
 * 回溯 算法超时了,重复计算实在太多..
 * 这种一般都可以优化成dp,正常是 3 维数组,可以压缩成二维的,二维在处理上要比三维简单很多
 *
 */
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < strs.length; i++) {
            int cost0 = 0, cost1 = 0;
            for (int idx = 0; idx < strs[i].length(); idx++) {
                if(strs[i].charAt(idx) == '0') {
                    cost0++;
                } else {
                    cost1++;
                }
            }
            for (int num0 = m; num0 >= cost0; num0--) {
                for (int num1 = n; num1 >= cost1; num1--) {
                    dp[num0][num1] = Math.max(dp[num0][num1], 1 + dp[num0 - cost0][num1 - cost1]);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm_3d(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for (int i = 1; i <= strs.length; i++) {
            int cost0 = 0, cost1 = 0;
            for (int idx = 0; idx < strs[i-1].length(); idx++) {
                if(strs[i-1].charAt(idx) == '0') {
                    cost0++;
                } else {
                    cost1++;
                }
            }
            for (int num0 = 0; num0 <= m; num0++) {
                for (int num1 = 0; num1 <= n; num1++) {
                    if(num0 < cost0 || num1 < cost1) {
                        dp[i][num0][num1] = dp[i-1][num0][num1];
                    } else {
                        dp[i][num0][num1] = Math.max(dp[i - 1][num0][num1], 1 + dp[i - 1][num0 - cost0][num1 - cost1]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }



    public int findMaxForm_backtrace(String[] strs, int m, int n) {
        return findMax(strs, 0, m, n);
    }

    private int findMax(String[] strs, int curIdx, int numOf0, int numOf1) {
        if (curIdx >= strs.length || numOf0 <0 || numOf1 < 0) {
            return 0;
        }
        int max = 0;
        String cur = strs[curIdx];
        int need0 = 0, need1 = 0;
        for (int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) == '0') {
                need0++;
            }else {
                need1++;
            }
        }
        if(need0 > numOf0 || need1 > numOf1) {
            return findMax(strs, curIdx + 1, numOf0, numOf1);
        } else {
            return Math.max(1 + findMax(strs, curIdx + 1, numOf0 - need0, numOf1 - need1),
                findMax(strs, curIdx + 1, numOf0, numOf1));
        }
    }
}
