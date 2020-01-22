package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else if (i == m - 1) {
                    dp[i][j] = dp[i][j+1];
                } else if (j == n -1) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
