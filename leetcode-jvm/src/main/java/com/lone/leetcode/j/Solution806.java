package com.lone.leetcode.j;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int MAX = 100;
        int lineNum = 1,curLength = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cLength = widths[c - 'a'];
            if(curLength + cLength > MAX) {
                lineNum++;
                curLength = cLength;
            } else {
                curLength += cLength;
            }
        }
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        random.nextInt();

        return new int[]{lineNum,curLength};

    }
}
