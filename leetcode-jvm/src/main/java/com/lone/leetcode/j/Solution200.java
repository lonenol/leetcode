package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 思路:
 * 1. 碰到 1 就把 1 周围的 1 全变成 0
 * 2. 并查集(Union find) ,优势是不需要改动输入,劣势是比较复杂..下边的实现为了省事,也改动了输入..
 *
 * ps:grid 赋值的时候需要特别注意 grid[i][j] = '0' 而不是  grid[i][j] = 0
 */
public class Solution200 {

    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
                count--;
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '0') {
                    continue;
                }
                grid[i][j] = '0';
                /*up*/
                if (i - 1 >= 0 && grid[i-1][j] == '1') {
                    uf.union(i * n + j, (i - 1) * n + j);
                }
                /*down*/
                if (i + 1 < m && grid[i+1][j] == '1') {
                    uf.union(i * n + j, (i + 1) * n + j);
                }
                /*left*/
                if(j-1 >= 0 && grid[i][j-1] == '1') {
                    uf.union(i * n + j, i * n + j -1);
                }
                /*right*/
                if(j+1 < n && grid[i][j+1] == '1') {
                    uf.union(i * n + j, i * n + j + 1);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        solution200.numIslands(grid);

    }
}
