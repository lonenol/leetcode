package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 思路: 滑动窗口
 */
public class Solution209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums.length + 1, start = 0, end = 0, sum = 0;
        while (end < nums.length) {
            sum = sum + nums[end];
            if (sum < s) {
                end++;
                continue;
            }
            min = Math.min(min,end - start + 1);
            while (start < end) {
                sum = sum - nums[start++];
                if (sum >= s) {
                    min = Math.min(min,end - start + 2);
                } else {
                    break;
                }
            }
            end++;
        }
        return min  % (nums.length + 1);
    }

    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        solution209.minSubArrayLen(4, new int[] {1,4,4});
    }
}
