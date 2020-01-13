package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * 思路: 从后往前找,找到第一个比最后一位
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 &&nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(nums[i] >= nums[j]) {
                j--;
            }
            exchange(nums, i, j);
        }
        reverse(nums, i+1);

    }

    private void reverse(int[] nums, int start) {
        for (int i = start, j = nums.length - 1; i < j; i++, j--) {
            exchange(nums, i, j);
        }
    }
    private void exchange(int[] nums, int l ,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
