package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 * 思路:就是玩弄坐标..每个点都顺时针旋转,整体上是整个矩形分为了四个小矩形,然后颠倒互换位置
 * 具体实现上是四个小矩形每个出一个点,顺时针交换位置,公式需要推导..
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
