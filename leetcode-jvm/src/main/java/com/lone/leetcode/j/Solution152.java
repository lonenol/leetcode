package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 思路：
 * 1. 暴力循环
 * 2. dp
 * 如果没有复数的话和求和是一摸一样的解法，乘负数之后最大会变成最小，因此需要维护一个最大值，一个最小值
 * 有两个状态的dp，状态至于前一位相关，因此用两个int也够了
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int res = nums[0], max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > 0) {
                max = Math.max(max* nums[i], nums[i]);
                min = Math.min(min*nums[i],nums[i]);
            } else {
                int tmp = max;
                max = Math.max(min*nums[i],nums[i]);
                min = Math.min(tmp*nums[i],nums[i]);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
