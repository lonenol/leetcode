package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * @author ljl133110
 * @date 2020-05-29
 * 思路:
 * 1. 求出 0 1 2的个数,然后重写数据
 * 2.
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        partition(nums, 0, nums.length);
    }

    public void partition(int[] nums, int low, int high) {

    }
}
