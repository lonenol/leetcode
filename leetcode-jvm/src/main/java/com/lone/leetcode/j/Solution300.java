package com.lone.leetcode.j;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 思路:
 * 1. 暴力循环 O(n^2)
 * 2. 动态规划 dp[n]代表到达当前节点的最长路径,dp[n] = Math.max(dp[n-i]) + 1  (nums[n] > nums[i])
 */
public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


        public int lengthOfLIS_dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = i - 1;
            int preMax = 0;
            while (pre >= 0) {
                if (nums[pre] < nums[i]) {
                    preMax = Math.max(preMax, dp[pre]);
                }
                pre--;
            }
            dp[i] = preMax + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        Solution300 solution300 = new Solution300();
        solution300.lengthOfLIS(nums);
    }
}
