package com.lone.leetcode.j;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 思路：和15题一样，只是条件从等于零变成了离target最近
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i +1, k = nums.length -1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(res - target) >= Math.abs(sum - target)) {
                    res = sum;
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                   j++;
                }else {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        System.out.println(solution16.threeSumClosest(new int[]{1,1,-1,-1,3}, -1));
    }
}
