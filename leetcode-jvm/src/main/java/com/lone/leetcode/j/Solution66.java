package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * 思路： 就是往上加。。第一位进位的时候需要创建新数组
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i] + 1;
            if(cur == 10) {
               if(i >0) {
                   digits[i] = 0;
               } else {
                   int[] ret = new int[digits.length + 1];
                   ret[0] = 1;
                   digits[0] = 0;
                   for (int j = 1; j < ret.length; j++) {
                       ret[j] = digits[j - 1];
                   }
                   return ret;
               }
            } else {
                digits[i] = cur;
                return digits;
            }
        }
        return digits;
    }
}
