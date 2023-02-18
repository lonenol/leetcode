package com.lone.leetcode.j;

/**
 * @author ljl133110
 * @date 2020-05-14
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return m & n;
    }
}
