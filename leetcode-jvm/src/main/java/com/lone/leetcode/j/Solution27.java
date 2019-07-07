package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/remove-element/submissions/
 * @author ljl133110
 * @date 2018-12-31
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            while (start <= end && nums[start] != val) {
                start++;
            }
            while(start <= end && nums[end] == val) {
                end--;
            }
            if(start >= end) {
                break;
            }
            nums[start] = nums[end];
            nums[end] = val;
        }
        if (start >= nums.length) {
            return nums.length;
        } else  if(nums[start] == val) {
            return start;
        } else {
            return ++start;
        }
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] arr = {2};
        System.out.println(solution27.removeElement(arr, 3));

    }
}
