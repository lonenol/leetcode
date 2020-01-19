package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/add-binary/
 * 思路:略
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return b;
        }
        /*最多进一位*/
        char[] res = new char[Math.max(a.length(), b.length()) + 1];
        int i = a.length()-1, j = b.length()-1,k = res.length - 1;
        boolean carry = false;
        while (i >=0 && j >=0) {
            char ac = a.charAt(i--);
            char bc = b.charAt(j--);
            if (ac == '1' && bc == '1') {
                res[k--] = carry ? '1' : '0';
                carry = true;
            } else if(ac == '1' || bc == '1') {
                res[k--] = carry ? '0' : '1';
            } else {
                res[k--] = carry ? '1' : '0';
                carry = false;
            }
        }
        while (i >= 0) {
            char ac = a.charAt(i--);
            if (ac == '1') {
                res[k--] = carry ? '0' : '1';
            } else {
                res[k--] = carry ? '1' : '0';
                carry = false;
            }
        }
        while (j >= 0) {
            char bc = b.charAt(j--);
            if (bc == '1') {
                res[k--] = carry ? '0' : '1';
            } else {
                res[k--] = carry ? '1' : '0';
                carry = false;
            }
        }
        res[k] = carry ? '1' : '0';
        return new String(res, carry ? 0 : 1, carry ? res.length : res.length - 1);
    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        solution67.addBinary("1010", "1011");
    }
}
