package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int start = 1;
        int up = 0, down = n -1, left = 0, right = n - 1;
        int[][] res = new int[n][n];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[up][i] = start++;
            }
            if(++up > down){break;}
            for (int i = up; i <= down; i++) {
                res[i][right] = start++;
            }
            if(--right < left) {break;}
            for (int i = right; i >= left; i--) {
                res[down][i] = start++;
            }
            if(--down < up){break;}
            for (int i = down; i >= up; i--) {
                res[i][left] = start++;
            }
            if(++left > right ) {break;}
        }
        return res;
    }
}
