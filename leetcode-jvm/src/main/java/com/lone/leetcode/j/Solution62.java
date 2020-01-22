package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 思路:
 * 1. 标准的回溯 超时了,因为有很多的重复计算
 * 2. 所以考虑下 dp[x][y] = dp[x+1][y] + dp[x][y+1] (x+1 <=m-1 y+1 <=n-1) 从 dp[m-1][n-1]开始,dp[0][0]是答案
 * 可以做一些优化,边上肯定都是 1,可以不用计算,直接赋值
 * 可以只用 int[n] 存储结果,空间利用率会更低
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int x = m - 1; x >= 0; x--) {
            for (int y = n - 1; y >= 0; y--) {
                if (x == m - 1 && y == n - 1) {
                    dp[x][y] = 1;
                } else if(x == m-1) {
                    dp[x][y] = dp[x][y + 1];
                } else if (y == n - 1) {
                    dp[x][y] = dp[x + 1][y];
                } else {
                    dp[x][y] = dp[x + 1][y] + dp[x][y + 1];
                }
            }
        }
        return dp[0][0];
    }
    public int uniquePaths_backtrace(int m, int n) {
        return backtrace(m, n, 1,1);
    }

    private int backtrace(int m, int n, int x, int y) {
        if (x < m && y < n) {
            return backtrace(m, n, x, y + 1) + backtrace(m, n, x + 1, y);
        } else if (x < m) {
            return backtrace(m, n, x+1, y);
        } else if (y < n) {
            return backtrace(m, n, x , y+1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        solution62.uniquePaths(51, 9);
    }
}
