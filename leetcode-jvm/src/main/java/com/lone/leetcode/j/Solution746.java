package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *  解题思路:
 *  比 70 题传统的 dp 多了一个花费精力的概念,只要在 dp 的时候加上就行了,这个题就有点像买股票问题了.
 *  可以用数组或者两个int 表示前边的状态
 *  ps:这道题题干说的比较模糊,最后试了几次提交,才找准意思..
 *  楼梯的长度是cost.length
 *  cost[i]表示从 i 向上爬消耗的体力
 */
public class Solution746 {

    public int minCostClimbingStairs(int[] cost) {
       int dp1 = 0, dp2 = 0;
        for (int i = 2; i <= cost.length; i++) {
            int dpi = Math.min(dp1 + cost[i - 2], dp2 + cost[i - 1]);
            dp1 = dp2;
            dp2 = dpi;
        }
        return dp2;
    }
    public int minCostClimbingStairs_dp(int[] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return cost[0];
        }
        /* 爬到第 n 阶梯耗费的最少体力*/
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[1];
        dp[2] = cost[2];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 1]);
        }
        return dp[n];
    }
}
