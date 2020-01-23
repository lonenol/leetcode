package com.lone.leetcode.j;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 * 思路:
 * 1. 记录需要被置零的行和列,然后置零
 * 2. 编辑 matrix[m][0]和  matrix[0][n] 然后统一指令
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix[0].length; r++) {
                if (matrix[c][r] == 0) {
                    col.add(c);
                    row.add(r);
                }
            }
        }
        for (int c : col) {
            for (int i = 0; i < matrix[c].length; i++) {
                matrix[c][i] = 0;
            }
        }

        for (int r : row) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][r] = 0;
            }
        }
    }
}
