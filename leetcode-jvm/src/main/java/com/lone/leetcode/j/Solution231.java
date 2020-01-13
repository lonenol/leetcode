package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/power-of-two
 * 思路： 1. 从1开始往上乘 或者从n开始往下除,这种做法会超过时间限制
 * 2. 2^x只会有1个1，因此一定会满足 x&(x-1) == 0
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        Solution231 solution231 = new Solution231();
        solution231.isPowerOfTwo(1221212);
    }
}
