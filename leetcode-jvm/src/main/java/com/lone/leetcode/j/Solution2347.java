package com.lone.leetcode.j;
import java.util.*;

/**
给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。

下述是从好到坏你可能持有的 手牌类型 ：

"Flush"：同花，五张相同花色的扑克牌。
"Three of a Kind"：三条，有 3 张大小相同的扑克牌。
"Pair"：对子，两张大小一样的扑克牌。
"High Card"：高牌，五张大小互不相同的扑克牌。
请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。

注意：返回的字符串 大小写 需与题目描述相同。
 */
public class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        if(isFlush(suits)) {
            return "Flush";
        }
        int max = maxNumOfSameCard(ranks);
        if(max >=3) {
            return "Three of a Kind";
        } else if(max == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }

    private boolean isFlush(char[] suits) {
        for(int i = 1;  i< 5; i++) {
            if(suits[0] != suits[i]) {
                return false;
            }   
        }
        return true;
    }
    private int maxNumOfSameCard(int[] ranks) {
        Map<Integer,Integer> num = new HashMap<>();
        int max = 0;
        for(int i = 0; i < ranks.length; i++) {
            int cur = num.getOrDefault(ranks[i], 0);
            max = Math.max(max,++cur);
            num.put(ranks[i], cur);
        }
        return max;
    }
}