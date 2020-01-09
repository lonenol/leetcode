package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2020/01/08
 *  121  122 123  309 188 714 五道股票价格计算题目
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 通用思路,这里可以简化掉买卖 k 次这个维度
 */
public class Solution122 {


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, tmp - prices[i]);
        }
        return dp0;

    }


        public int maxProfit_bak(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
