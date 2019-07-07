package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2018/10/15
 */
public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        String num = String.valueOf(x);
        int start = 0, end = num.length() -1;
        while (start <= end) {
            if (num.charAt(start++) != num.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
