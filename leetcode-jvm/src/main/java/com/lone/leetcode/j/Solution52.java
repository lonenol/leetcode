package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 * 思路:和 51 题一样,就是不用输出结果,直接计算结果数量就行
 */
public class Solution52 {

    private int count = 0;

    public int totalNQueens(int n) {
       if(n < 1) return 0;
        dfs(n, 0, 0, 0, 0);
       return count;
    }

    private void dfs(int n, int row, int cols, int minor, int main) {
        if(row >=n) {
            count++;
            return;
        }
        int bits = (~(cols | minor | main)) & ((1 << n) - 1);
        while (bits > 0) {
            int p = bits & -bits;
            dfs(n, row + 1, cols | p, (minor | p) << 1, (main | p) >> 1);
            bits = bits & (bits - 1);
        }
    }




    private int num;
    private int[] queues;
    private int[] rows;
    private int[] main;
    private int[] minor;
    int result = 0;

    public int totalNQueens_basic(int n) {
        num = n;
        queues = new int[n];
        rows = new int[n];
        main = new int[2 * n];
        minor = new int[2 * n];
        backtrace(0);
        return result;
    }

    private void backtrace(int row) {
        for (int col = 0; col < num; col++) {
            if (isValid(row, col)) {
                placeQueen(row, col);
                if (row + 1 == num) {
                    result++;
                } else {
                    backtrace(row + 1);
                }
                removeQueen(row, col);
            }
        }
    }

    private void removeQueen(int row, int col) {
        queues[row] = 0;
        rows[col] = 0;
        main[row -col + num] = 0;
        minor[row + col] = 0;
    }

    private void placeQueen(int row, int col) {
        queues[row] = col;
        rows[col] = 1;
        main[row - col + num] = 1;
        minor[row+col] = 1;
    }

    private boolean isValid(int row, int col) {
        return rows[col] + main[row - col + num] + minor[row + col] == 0;
    }
}
