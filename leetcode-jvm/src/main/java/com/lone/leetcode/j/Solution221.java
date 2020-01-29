package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 * 思路: dp,这个没做过不太会想到用 dp, dp 方程本身比较简单
 * 1. 普通 dp
 * 2. 压缩
 */
public class Solution221 {


    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[] dp = new int[n + 1];
        int pre = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(pre, Math.min(dp[j], dp[j - 1])) + 1;
                    res = Math.max(res, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = tmp;
            }
        }
        return res * res;
    }


        public int maximalSquare_plain(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }
}
