package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/counting-bits
 * 思路：
 * 0. 暴力循环求1肯定可以，不过复杂度太高了
 * 1. 动态规划-1  n&(n-1)是清空最低位的1，因此n的个数比n&(n-1)多1，也就是状态转移方程
 * 2. 动态规划： 看奇偶数， 如果n为奇数 则n中1的个数比n>>1多1，因为最后一位1被移掉了，若为偶数，则n中1的个数和n >> 1相等
 */
public class Solution338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i&i-1] +1;
        }
        return dp;
    }
}
