package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits
 * 思路： 1 : x = x &(x -1) 清零最低位的1，直到x == 0
 * 2. 也可以每次右移一位，判断最后一位是不是1，然后累加
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n  != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;

    }
}
