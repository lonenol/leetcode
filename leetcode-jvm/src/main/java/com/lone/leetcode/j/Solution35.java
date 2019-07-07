package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/search-insert-position/submissions/
 * @author ljl133110
 * @date 2019-01-03
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        int mid = left + (right-left)/2;
        while(left + 1 < right) {
            int val = nums[mid];
            if(val == target) {
                return mid;
            } else if(val < target) {
                left = mid;
                mid = left + (right-left)/2;
            } else {
                right = mid;
                mid = left + (right-left)/2;
            }
        }
        if(nums[left] == target) {
            return left;
        } else if(nums[right] == target) {
            return right;
        } else if(nums[left] > target) {
            return Math.max(left - 1,0);
        } else if(nums[right] < target) {
            return right + 1;
        } else {
            return left + 1;
        }
    }
}
