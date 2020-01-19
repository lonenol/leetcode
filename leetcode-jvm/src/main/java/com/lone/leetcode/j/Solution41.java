package com.lone.leetcode.j;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * 思路:
 * 1. 排序然后找到第一个不连续的点
 * 2. 所有数字放到 Set 中,从下向上找到第一个不存在的数字
 * 3. 考虑到数组长度是 n ,找到第一个缺失的数,这个数组最大的情况是数组里存了 1到n,答案是 n+1,若数组里包含负数,或者比 n 大的数,则答案一定会小于 n
 * 因此可以利用数组的下标(类似桶排序的思想)
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        boolean has1 = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                has1 = true;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if (!has1) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums[i]);
            if (cur == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[cur] = -Math.abs(nums[cur]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return n;
        }
        return n + 1;
    }

    public int firstMissingPositive_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
