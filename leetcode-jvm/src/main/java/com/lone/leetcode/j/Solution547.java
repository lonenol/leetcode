package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 * 题解:和岛屿数量是一模一样的思路
 * 1. 检测到一个 1,深度优先搜索把他所有的朋友都设置成 0
 * 2. 并查集,看着挺高端,其实时间复杂度还是蛮高的..
 *
 */
public class Solution547 {

    class UnionFind {

        private int[] unions;
        private int count;

        public UnionFind(int n) {
            unions = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                unions[i] = i;
            }
        }

        int find(int idx) {
            if (unions[idx] != idx) {
                unions[idx] = find(unions[idx]);
            }
            return unions[idx];
        }

        void unions(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx != yy) {
                unions[xx] = yy;
                count--;
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int len = M.length;
        if (len == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || M[i][j] == 0) {
                    continue;
                } else {
                    uf.unions(i, j);
                    M[i][j] = 0;
                    M[j][i] = 0;
                }
            }
        }
        return uf.count;
    }
}
