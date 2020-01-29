package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 思路:
 * 1. map记录数组数量
 * 2. 排序,然后从前往后找
 * 3. 暴力循环
 * 4. 2*sum(set(nums)) - sun(nums)
 * 5. 异或.. 这个自己真的没想到..
 *
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
