package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 思路： 第一想法是暴力循环，但是貌似不太好写，然后就考虑用回溯了，和n皇后其实是一种题目，但是简单很多
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        char[][] arr = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> result = new ArrayList<>();
        char[] tmp = new char[digits.length()];
        backtrace(result,arr, tmp, digits, 0);
        return result;

    }

    private void backtrace(List<String> result,char[][] arr, char[] tmp, String digits, int idx) {
        int cur = Integer.parseInt(digits.substring(idx,idx+1));
        for (char c : arr[cur - 2]) {
            tmp[idx] = c;
            if (idx == digits.length() - 1) {
                result.add(new String(tmp));
            } else {
                backtrace(result,arr,tmp,digits,idx+1);
            }
        }
    }


    public static void main(String[] args) {
        int a = '2';
        System.out.println(a);
    }
}
