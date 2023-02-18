package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/distribute-candies-to-people
 * 思路：只想到了按正常思路分的方式
 *
 */
public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int cur = 0;
        while (candies > 0) {
            for (int i = 0; i < num_people && candies > 0; i++) {
                cur = Math.min(cur + 1, candies);
                res[i] += cur;
                candies -= cur;
            }
        }
        return res;
    }
}
