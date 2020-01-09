package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2020/01/08
 * 121  122 123  309 188 714 五道股票价格计算题目
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 思路:
 * 1. 和 53 最大子序列的思路类似
 * 2. 动态规划的通用解法
 * 由于状态只和上一个状态相关,因此可以用两个 int 简化计算,降低空间复杂度
 * 由于只能卖出一次,因此卖出时,是 Math.max(dp[i - 1][1], -prices[i])
 * 和可以卖出多次的算法不一样.
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }

        public int maxProfit_dp_with_array(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];

    }

    public int maxProfit_nodp(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0],maxProfix = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfix = Math.max(maxProfix, prices[i] - minPrice);
        }
        return maxProfix;
    }
}
