package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 思路: 典型的回溯
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> tmp = new ArrayList<>();
        backtrace(res, tmp, nums, 0);
        res.add(tmp);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx) {
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            backtrace(res, tmp, nums, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        solution78.subsets(new int[] {1, 2, 3});
    }
}
