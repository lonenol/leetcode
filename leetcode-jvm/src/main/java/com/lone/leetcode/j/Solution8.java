package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * @author lone
 * @date 2018/10/9
 */
public class Solution8 {

    public int myAtoi(String str) {
        int index = 0;
        int result = 0;
        boolean positive = true;
        while (index < str.length()) {
            char c = str.charAt(index);
            if (c == ' ') {
                index++;
                continue;
            } else if (c == '+') {
                index++;
                break;
            } else if (c == '-') {
                positive = false;
                index++;
                break;
            } else {
                break;
            }
        }
        if (index >= str.length()) {
            return result;
        }
        while (index < str.length()) {
            int tmp = str.charAt(index) - '0';
            if (tmp >= 0 && tmp <= 9) {
                tmp = (positive? 1 : -1) * tmp;
                if (isValid(result, tmp, positive)) {
                    result = result * 10 + tmp;
                    index++;
                } else if (positive) {
                    result = Integer.MAX_VALUE;
                    break;
                } else {
                    result = Integer.MIN_VALUE;
                    break;
                }
            } else {
                break;
            }
        }
        return result;
    }

    private boolean isValid(int result, int tmp, boolean positive) {
        if(positive) {
            return result <= Integer.MAX_VALUE / 10 && (tmp < (Integer.MAX_VALUE - result * 10));
        } else {
            return result >= Integer.MIN_VALUE / 10 && (tmp > Integer.MIN_VALUE - result * 10);
        }
    }

    public static void main(String[] args) {
        Solution8 s = new Solution8();
        System.out.println(s.myAtoi("3.14159"));
    }
}
