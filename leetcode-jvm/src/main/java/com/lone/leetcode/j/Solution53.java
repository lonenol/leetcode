package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2020/01/08
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 思路: 数据结构与算法分析-java 语言描述 第二章里给了这道题的四种解法,最精妙的解法是 O(n)的.用以展示算法之美
 * 1. 三重循环 ,穷举,写法比较奇怪,正常人应该不会那么些..
 * 2. 二重循环,正常思路,穷举从每个值开始的最大值,然后选一个最大的
 * 3. 递归 O(nlgn)的,分治法,思路不太好想,复杂度也比较高
 * 4. O(n)
 * 除此之外,还可以用动态规划来解
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public int maxSubArray_4(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0];
        int stack = nums[0];
        for (int i = 1; i < nums.length; i++) {
            stack = Math.max(stack + nums[i], nums[i]);
            max = Math.max(stack, max);
        }
        return max;
    }
}
