package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * 题解:本身比较简单,就是需要注意区间是无序的..
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length;) {
            int next = i + 1;
            for (int j = next; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0]) {
                    intervals[i][1] = Math.max(intervals[i][1],intervals[j][1]);
                    next++;
                } else {
                    next = j;
                    break;
                }
            }
            ret.add(new int[] {intervals[i][0], intervals[i][1]});
            i = next;
        }
        return ret.toArray(new int[0][0]);
    }

}
