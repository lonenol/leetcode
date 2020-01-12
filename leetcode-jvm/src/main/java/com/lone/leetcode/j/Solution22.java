package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 思路： 只想到了回溯法,n对括号，因此有n*2个位置，每个位置能放什么取决于前面左括号和右括号的位置
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] tmp = new char[n * 2];
        int left = 0, right = 0;
        backtrace(res, tmp, left, right, 0);
        return res;

    }

    private void backtrace(List<String> res, char[] tmp, int left, int right, int cur) {
        if (cur == tmp.length - 1) {
            tmp[cur] = ')';
            res.add(new String(tmp));
            return;
        }
        /*()都可以放*/
        if (right < left) {
            if (left < tmp.length / 2) {
                tmp[cur] = '(';
                backtrace(res, tmp, left + 1, right, cur + 1);
            }
            tmp[cur] = ')';
            backtrace(res, tmp, left, right + 1, cur + 1);
        } else if (right == left && left < tmp.length / 2) {
            /*只能放(*/
            tmp[cur] = '(';
            backtrace(res, tmp, left + 1, right, cur + 1);
        }
    }
}
