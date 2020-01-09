package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2020/01/09
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * 121  122 123  309 188 714 五道股票价格计算题目
 * 思路:
 * 1. 通用的 dp 思路,
 */
public class Solution123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int k = 2;
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
