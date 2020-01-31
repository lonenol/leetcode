package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/add-strings/
 * 思路: 相加..
 */
public class Solution415 {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0 , i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int first = i < 0 ? 0 : (num1.charAt(i--) - '0');
            int sec = j < 0 ? 0 : (num2.charAt(j--) - '0');
            int sum = first + sec + carry;
            res.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }
}
