package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 思路: 1. 暴力匹配,复杂度太高,脑袋有点绕不过来
 *      2. 回溯试试
 *      ps: 身体太重要了...长度相等..
 *      隐藏点是可以重叠..
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words.length == 0 || words[0].length() == 0) {
            return Collections.emptyList();
        }
        int len = words[0].length();
        int totalCount = len * words.length;
        if (s.length() < totalCount) {
            return Collections.emptyList();
        }
        Map<String, Integer> wordCount = new HashMap<>(words.length);
        for (String str : words) {
            Integer count = wordCount.get(str);
            wordCount.put(str, count == null ? 1 : count + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - totalCount; i++) {
            Map<String, Integer> tmp = new HashMap<>(wordCount);
            int start = i;
            while (start <= s.length() - len) {
                String cur = s.substring(start, start + len);
                Integer co = tmp.get(cur);
                if (co == null || co == 0) {
                    break;
                }
                tmp.put(cur, --co);
                start += len;

            }
            if (matches(tmp)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean matches(Map<String, Integer> tmp) {
        for (Integer val : tmp.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        String str =  "a";
        String[] words = {"a"};
        System.out.println(solution30.findSubstring(str, words));
    }
}
