package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author lone
 * @date 2018/11/14
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        int i = 0;
        while (i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if ( i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return result;
                }
            }
            result += c;
            i++;
        }
        return result;
    }
}
