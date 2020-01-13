package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 解题思路: 所有解法都和斐波那契对标,也有同样的重复计算问题
 * 1.  暴力递归,像斐波那切数列递归的思路,由于大量重复计算,时间复杂度也极高
 * 2. 记忆递归
 * 3. dp
 * 4. 由于只有一个状态,且只和前两个状态相关,所以空间复杂度可以优化成常数
 * 5. 高级数学方法...
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        /* 走到第 n 阶的方法个数*/
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
