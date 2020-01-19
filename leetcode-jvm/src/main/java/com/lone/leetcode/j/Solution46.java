package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 标准回溯题目
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrace(ret, tmp, nums, visited);
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, List<Integer> tmp, int[] nums, int[] visited) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrace(ret, tmp, nums, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = 0;
        }
    }
}
