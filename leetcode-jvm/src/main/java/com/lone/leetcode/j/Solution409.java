package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 * 思路:
 * 所有偶数的字母相加,奇数的取最大的一个
 */
public class Solution409 {

    public int longestPalindrome(String s) {
        int[] nums = new int[58];
        for (char c : s.toCharArray()) {
            nums[c-'A']++;
        }
        int odd = 0;
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i;
            } else {
                odd = 1;
                sum = sum + i - 1;
            }
        }
        return odd + sum;
    }

    public static void main(String[] args) {
        System.out.println('z' - 'A');
    }
}
