package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * 思路:
 * 1. 用 map 计数
 * 2. 异或操作.. x^x = 0   x^-x得到的是最低位的 1
 */

public class Solution260 {

    public int[] singleNumber(int[] nums) {
        int bit = 0;
        for (int i : nums) {
            bit = bit ^ i;
        }
        int lowBit = bit & (-bit);
        int x = 0;
        for (int i : nums) {
            if ((lowBit & i) != 0) {
                x = x ^ i;
            }
        }
        return new int[] {x, lowBit ^ x};
    }
}
