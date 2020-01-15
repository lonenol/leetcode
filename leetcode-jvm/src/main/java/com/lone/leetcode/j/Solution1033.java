package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/moving-stones-until-consecutive/
 * 思路:这个题目太奇怪了..要注意三个参数不是无序的,以及 1 3 5 这种可以直接移动成 3 1 5
 * 最大值就是一步一步移动即可
 */
public class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b > c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int min = Math.min(1,b-a -1) + Math.min(1,c - b -1);
        if(b-a == 2 || c-b == 2) {
            min = 1;
        }
        int max = c - a -2;
        return new int[] {min, max};
    }

    public static void main(String[] args) {
        Solution1033 solution1033 = new Solution1033();
        int[] arr = {4, 3, 2,};
        solution1033.numMovesStones(4, 3, 2);

    }
}
