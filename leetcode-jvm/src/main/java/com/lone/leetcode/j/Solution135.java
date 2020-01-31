package com.lone.leetcode.j;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/candy/
 * 思路: 感觉应该是动态规划,但是规划不出..
 *
 * 1. 左右遍历
 *
 * 2.
 */
public class Solution135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) {
            return n;
        }
        int sum = 1, candy = 1, max = 0, downIndex = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] < ratings[i - 1]) {
                //下降
                if (downIndex == 0) {
                    max = candy;
                    downIndex = i;
                }
                candy = 1;
                sum += i - downIndex;
                if (i - downIndex + 1 >= max) {
                    sum++;
                }
            } else if (ratings[i] == ratings[i - 1]) {
                //平坡
                candy = 1;
                downIndex = 0;
            } else if (ratings[i] > ratings[i - 1]) {
                //上升
                candy += 1;
                downIndex = 0;
            }
            sum += candy;
        }
        return sum;
    }

    public int candy_oneArray(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] candidates = new int[ratings.length];
        Arrays.fill(candidates, 1);
        for (int i = 1; i < candidates.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candidates[i] = candidates[i - 1] + 1;
            }
        }
        int sum = candidates[candidates.length - 1];
        for (int i = candidates.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candidates[i] <= candidates[i + 1]) {
                    candidates[i] = candidates[i + 1] + 1;
                }
            }
            sum += candidates[i];
        }
        return sum;
    }

    public int candy_twoArray(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
