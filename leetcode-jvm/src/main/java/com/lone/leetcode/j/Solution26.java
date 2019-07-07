package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author ljl133110
 * @date 2018-12-21
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int start = 0, point =1;
        while(point < nums.length) {
            if(nums[point] != nums[start] && point -start > 1) {
                nums[++start] = nums[point++];
            } else if(nums[point] != nums[start] && point -start == 1){
                start++;
                point++;
            } else if(nums[point] == nums[start]) {
                point++;
            }
        }
        return start + 1;
    }
}
