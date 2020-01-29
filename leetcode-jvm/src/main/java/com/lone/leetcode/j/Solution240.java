package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 思路:
 * 1. 遍历
 * 2. 二分查找
 * 3. 从左上角或者右下角遍历 ,具体分析见官方题解
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = matrix.length -1 , j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;

    }
}
