package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 思路:
 * 1. 排序,然后比较是否相同
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        Map<String,List<String>> strChars = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            List<String> strList = strChars.computeIfAbsent(new String(charArray), k -> new ArrayList<>());
            strList.add(str);
        }

        res.addAll(strChars.values());
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        Solution49 solution49 = new Solution49();
        solution49.groupAnagrams(strs);
    }
}
