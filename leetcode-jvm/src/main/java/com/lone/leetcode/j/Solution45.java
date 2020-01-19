package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 思路:
 * 1.第一 感觉和楼梯问题很像,用 dp可以 解决
 * dp[i]表示跳到第 i 个位置用到的最小步数
 * dp[i]应该等于 dp[i]之前所有能跳到这个位置的地点之中的最小值
 * di[i] = Math.min(dp[i-x] >= x) +1
 *
 * 2. 第一种解法超时了,然后感觉这题只能贪心了..
 */
public class Solution45 {

    public int jump(int[] nums) {
        int end = 0, max = 0,step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(nums[i], max);
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }

    public int jump_do_exceed_time(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = dp[i-1];
            for(int j = i -2; j >=0; j--) {
                if(nums[j] >= (i - j)) {
                    min = Math.min(min, dp[j]);
                }
            }
            dp[i] = min + 1;
        }
        return dp[nums.length - 1];
    }
}
