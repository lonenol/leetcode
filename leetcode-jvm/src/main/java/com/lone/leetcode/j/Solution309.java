package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2020/01/09
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 121  122 123  309 188 714 五道股票价格计算题目
 * 有冷冻期,因此第 n 天买入要从 n-2转义,不能从 n-1
 */
public class Solution309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int dp0 = 0, dp1 = -prices[0],dpPre = 0;
        for (int i = 1; i < n; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dpPre - prices[i]);
            dpPre = tmp;
        }
        return dp0;

    }


    public int maxProfit_arr(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /**
             * 第一天状态转移特殊处理
             */
            dp[i][1] = Math.max(dp[i - 1][1], (i<=1 ? 0 : dp[i - 2][0]) - prices[i]);
        }
        return dp[n - 1][0];
    }
}
