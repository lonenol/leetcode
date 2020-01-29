package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 思路:
 * 1. 暴力法,递归
 * 2. dp 当前屋的最大值是偷这个屋子或者不偷这个屋子里边比较大的
 * 3. 只用一个变量,降低空间复杂度,不过依旧是 dp,下边这个处理优秀的地方在于不用处理 nums.length == 0 和 nums.length == 1的情况,
 * 代码特别简洁,空间占用按理来说应该不可能更低了.只击败了14.34% 很神奇..
 */

public class Solution198 {
    public int rob(int[] nums) {
        int max = 0, pre = 0;
        for (int i : nums) {
            int tmp = max;
            max = Math.max(pre + i, max);
            pre = tmp;
        }
        return max;
    }

    public int rob_dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
