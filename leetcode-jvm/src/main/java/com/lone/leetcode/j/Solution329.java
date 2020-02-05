package com.lone.leetcode.j;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * 思路:第一感觉是回溯,一个点能达到的最大长度是固定的,因此可以用一个数组记忆这个长度,降低时间复杂度
 */
public class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curMax = calMax(matrix, i, j, res);
                res[i][j] = curMax;
                max = Math.max(max, curMax);
            }
        }
        return max;
    }

    private int calMax(int[][] matrix, int i, int j, int[][] res) {
        if (res[i][j] != 0) {
            return res[i][j];
        }
        int max = 0;
        if(i+1 < matrix.length && matrix[i+1][j] > matrix[i][j]) {
            int upMax = calMax(matrix, i + 1, j, res);
            res[i+1][j] = upMax;
            max = upMax;
        }
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
            int downMax = calMax(matrix, i - 1, j, res);
            res[i-1][j] = downMax;
            max = Math.max(max, downMax);
        }
        if(j+1<matrix[0].length && matrix[i][j+1] > matrix[i][j]) {
            int rightMax = calMax(matrix, i, j + 1, res);
            res[i][j + 1] = rightMax;
            max = Math.max(max,rightMax);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            int leftMax =  calMax(matrix, i, j - 1, res);
            res[i][j-1] = leftMax;
            max = Math.max(max, leftMax);
        }
        return max+1;
    }
}
