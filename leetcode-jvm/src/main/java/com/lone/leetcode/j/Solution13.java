package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2018/11/6
 */
public class Solution13 {
    public int romanToInt(String s) {
        int[]nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int sIdx = 0;
        int i = 0;
        int result = 0;
        while (i < s.length()) {
            while (s.startsWith(symbols[sIdx],i)) {
                result += nums[sIdx];
                i += symbols[sIdx].length();
            }
            sIdx++;

        }
        return result;
    }
}
