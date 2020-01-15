package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 思路: 和 39 题一样回溯,这里需要注意去重
 */
public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            backtrace(ret, candidates, target, i, cur);
            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, int[] candidates, int target, int idx, List<Integer> cur) {
        int tmp = candidates[idx];
        if (target < tmp) {
            return;
        }
        cur.add(tmp);
        target = target - tmp;
        if (target == 0) {
            ret.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        for (int i = idx + 1; i < candidates.length; i++) {
            backtrace(ret, candidates, target, i, cur);
        }
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        int[] can = {10, 1, 2, 7, 6, 1, 5};
        Solution40 solution40 = new Solution40();
        solution40.combinationSum2(can, 8);
    }
}
