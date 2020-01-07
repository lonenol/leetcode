package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * 思路:经典的回溯法解决,优化空间有限,可以用位运算简化一下
 */
public class Solution51 {
    private List<List<String>> res = new ArrayList<>();
    private int[] queue;
    private int[] rows;
    private int[] main;
    private int[] minor;

    public List<List<String>> solveNQueens(int n) {
        queue = new int[n];
        rows = new int[n];
        main = new int[2 * n];
        minor = new int[4 * n];
        backTrace(0);
        return res;
    }

    private void placeQueen(int row, int col) {
        queue[row] = col;
        rows[col] = 1;
        minor[col + row] = 1;
        main[row - col + 2*queue.length] = 1;
    }

    private void removeQueen(int row, int col) {
        queue[row] = 0;
        rows[col] = 0;
        minor[col + row] = 0;
        main[row - col + 2*queue.length] = 0;
    }

    private void backTrace(int row) {
        for (int col = 0; col < queue.length; col++) {
            if (isValid(row, col)) {
                placeQueen(row, col);
                if(row + 1 ==   queue.length) {
                    addCur();
                } else {
                    backTrace(row + 1);
                }
                removeQueen(row,col);
            }
        }
    }

    private void addCur() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < queue.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queue.length; j++) {
                sb.append(j == queue[i] ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        res.add(result);
    }

    private boolean isValid(int row, int col) {
        return rows[col] + minor[row + col] + main[row - col + 2*queue.length] == 0;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> solutions = solution51.solveNQueens(8);
        solutions.forEach(it -> it.forEach(System.out::println));
    }
}
