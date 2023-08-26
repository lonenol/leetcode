package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 思路: 回溯,去重
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backtrace(res, tmp, nums, 0, visited);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, int cur, int[] visited) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrace(res,tmp,nums,cur + 1,visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = 0;
            /*跳过重复元素*/
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] ) {
                    i++;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution47 solution47 = new Solution47();
        solution47.permuteUnique(nums);

    }
}
