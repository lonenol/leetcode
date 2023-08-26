package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 思路:动态规划经典问题,天数 买卖次数 和 是否持有这三种状态的遍历,是股票类问题中最通用的一道,可以退化到其它几个股票问题
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k > n / 2) {
            return maxProfitNoLimit(prices);
        }
        int[][][] mp = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    mp[i][j][0] = 0;
                    mp[i][j][1] = -prices[i];
                    continue;
                }
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
            }
        }
        int max = mp[n-1][0][0];
        for (int i = 0; i < k+1; i++) {
            max = Math.max(max, mp[n-1][i][0]);
        }
        return max;

    }

    private int maxProfitNoLimit(int[] prices) {
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, tmp - prices[i]);
        }
        return dp0;
    }

    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        //System.out.println(solution188.maxProfit(2, new int[] {2, 4, 1}));
        solution188.maxProfit(1, new int[] {1, 2});
    }
}
