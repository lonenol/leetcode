package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 思路:
 * 1. 暴力循环
 * 2. 回溯,优先自己回溯多次
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*排序一下,方便剪枝*/
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            backtrace(ret, candidates, target, i,cur);
        }
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, int[] candidates, int target, int idx, List<Integer> cur) {
        if (idx < candidates.length ) {
            int tmp = candidates[idx];
            /*当前分支不满足条件,直接剪掉*/
            if (tmp > target) {
                return;
            }

            target = target - tmp;
            if (target !=0 && target < tmp) {
                /*已经排序,后面没有小于 tmp 的数了*/
                return;
            }
            cur.add(tmp);
            if (target == 0) {
                ret.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                return;
            }

            /*回溯当前数*/
            backtrace(ret, candidates, target, idx, cur);
            /*回溯后面*/
            for(int i = idx; i < candidates.length; i ++) {
                backtrace(ret, candidates, target, idx+1, cur);
            }
            cur.remove(cur.size() - 1);
        }
    }
}
