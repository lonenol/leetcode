package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/word-search/
 * 思路:还是回溯..
 */
public class Solution79 {

    private boolean res = false;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        dfs(board, word);
        return res;

    }

    private void dfs(char[][] board,  String word) {
        int[] exists = new int[board.length * board[0].length];
        for (int i = 0; i < board.length && !res; i++) {
            for (int j = 0; j < board[0].length && !res; j++) {
                backtrace(board, i, j, word, 0, exists);
            }
        }
    }

    private void backtrace(char[][] board, int mi, int ni, String word, int wi, int[] exists) {
        int m = board.length;
        int n = board[0].length;
        if (mi < 0 || mi >= m || ni < 0 || ni >= n || wi >= word.length()) {
            return;
        }
        if (res || exists[mi * n + ni] == 1) {
            return;
        }

        if (wi == word.length() - 1) {
            res = (board[mi][ni] == word.charAt(wi));
            return;
        }
        if (board[mi][ni] != word.charAt(wi)) {
            return;
        }
        exists[mi * n + ni] = 1;
        backtrace(board, mi + 1, ni, word, wi + 1, exists);
        backtrace(board, mi - 1, ni, word, wi + 1, exists);
        backtrace(board, mi, ni + 1, word, wi + 1, exists);
        backtrace(board, mi, ni - 1, word, wi + 1, exists);
        exists[mi * n + ni] = 0;
    }

}
