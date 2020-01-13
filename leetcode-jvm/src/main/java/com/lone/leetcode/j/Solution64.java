package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 思路:
 * 1. 暴力递归
 * 2. 朴素dp
 * 可以新开数组,也可以在原数组上操作(不占用空间,但是破坏了入参,leetcode 上可以 ac,但是系统开发是绝对不可以的)
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
