package com.zh.leetcode.foroffer;

public class o12 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0]) {
                    board[i][j] = ' ';
                    boolean b = find(board, words, 1, i, j);
                    board[i][j] = words[0];
                    if (b) return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, char[] words, int index, int n, int m) {
        if (index == words.length) return true;

        //在(n,m)的上下左右找
        boolean b = false;

        if (n - 1 >= 0) {
            if (board[n - 1][m] == words[index]) {
                board[n - 1][m] = ' ';
                b = find(board, words, index + 1, n - 1, m);
                board[n - 1][m] = words[index];
            }
        }
        if (b) return true;
        if (n + 1 <= board.length - 1) {
            if (board[n + 1][m] == words[index]) {
                board[n + 1][m] = ' ';
                b = find(board, words, index + 1, n + 1, m);
                board[n + 1][m] = words[index];
            }
        }
        if (b) return true;

        if (m - 1 >= 0) {
            if (board[n][m - 1] == words[index]) {
                board[n][m - 1] = ' ';
                b = find(board, words, index + 1, n, m - 1);
                board[n][m - 1] = words[index];
            }
        }
        if (b) return true;

        if (m + 1 <= board[0].length - 1) {
            if (board[n][m + 1] == words[index]) {
                board[n][m + 1] = ' ';
                b = find(board, words, index + 1, n, m + 1);
                board[n][m + 1] = words[index];
            }
        }
        return b;
    }
}
