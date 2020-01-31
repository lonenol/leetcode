package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * 思路: 和 200 题 岛屿数量差不多,但是并查集统计面积应该需要一个额外的数组
 * 如果不允许修改值需要记录一下已经访问过的节点,允许的话,直接置为 0 就可以了.
 */
public class Solution695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, area(grid, i, j));
                }
            }
        }
        return max;
    }

    private int area(int[][] grid, int i, int j) {
        if( i < 0 || j < 0 ||i >= grid.length || j >=grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + area(grid, i + 1, j) + area(grid, i - 1, j) + area(grid, i, j + 1) + area(grid, i, j - 1);
    }
}
