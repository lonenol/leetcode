package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2020/01/09
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 带手续费,买入的时候减掉手续费就行
 */

public class Solution714 {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = -prices[0] -fee;
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1,tmp - prices[i] - fee);
        }
        return dp0;
    }
}
