package com.lone.leetcode.j;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 思路:
 * 1. 暴力循环算
 *
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
