package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 思路:似乎没什么好思路..
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            List<Integer> pre = res.get(res.size() - 1);
            for (int j = 1; j < i - 1; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }

}
