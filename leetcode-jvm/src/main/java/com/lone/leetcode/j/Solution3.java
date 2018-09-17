package com.lone.leetcode.j;

/**
 *
 * /**
 *  *
 *  * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", which the length is 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *  * @author lonenol
 *  * @date  2018/9/6
 *  */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        int longest = 0;
        int curFirst = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c] == -1 || arr[c] < curFirst) {
                arr[c] = i;
            } else {
                longest = Math.max(longest, i - curFirst);
                curFirst = arr[c] + 1;
                arr[c] = i;
            }
        }

        return Math.max(longest, s.length() - curFirst);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("aab"));
    }
}
