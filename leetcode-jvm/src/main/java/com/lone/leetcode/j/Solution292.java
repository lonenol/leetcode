package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/nim-game/solution/
 * 思路:游戏技巧
 */
public class Solution292 {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }
}
