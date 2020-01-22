package com.lone.leetcode.j;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 思路:
 * 1. dp
 * 2. 和之前的题一样,贪心解法
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }
        int maxReach = nums[0];
        for (int i = 1; i < n; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(nums[i] + i, maxReach);
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return maxReach >= n -1;
    }

    public boolean canJump_back(int[] nums) {
        int n = nums.length - 1;
        int lastPos = n;
        for (int i = n; i >= 0; i--) {
            if (nums[i] + i >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }


        public boolean canJump_dp(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int[] reach = new int[n];
        reach[0] = 1;
        for (int i = 0; i < n; i++) {
            if (reach[i] == 0) {
                continue;
            }
            if (i + nums[i] >= n - 1) {
                return true;
            }
            Arrays.fill(reach, i, i + nums[i]+1, 1);
        }
        return reach[n - 1] == 1;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums= {0,1};
        System.out.println(solution55.canJump(nums));
    }
}
