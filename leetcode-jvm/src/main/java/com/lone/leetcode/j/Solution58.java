package com.lone.leetcode.j;

/**
 *https://leetcode-cn.com/problems/length-of-last-word/
 * 思路：似乎只能往后查了。。
 *  最后的空格可以trim去掉，也可以先遍历到非空格的字符
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int right = s.length() - 1;
        while(right >=0 && s.charAt(right) == ' '){
            right--;
        }
        int left = 0,ret = 0;
        while(left <= right) {
            if(s.charAt(left) == ' ') {
                ret = 0;
            } else {
                ret++;
            }
            left++;
        }
        return ret;
    }
}
