package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/rectangle-overlap/
 * 思路:
 * 1. 投影 ,如果相交,则在 x 轴的投影和在 y 轴的投影都相交
 *
 */
public class Solution836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec2[2],rec1[2]) > Math.max(rec1[0],rec2[0]))
               && (Math.min(rec2[3],rec1[3]) > Math.max(rec1[1],rec2[1]));
    }


}
