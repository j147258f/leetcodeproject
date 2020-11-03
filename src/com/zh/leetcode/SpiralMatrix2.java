package com.zh.leetcode;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        result = new int[n][n];
        if (n == 0) return result;
        top = 0;
        left = 0;
        down = result.length - 1;
        right = result[0].length - 1;
        while (top < down || left < right) {
            if (!(right(left, right) && down(top, down) && left(right, left) && up(down, top))) {
                break;
            }

        }
        if (top == down && left == right) {
            result[top][left] = count;
            count++;
        }
        return result;

    }

    int count = 1;
    int[][] result;
    int top;
    int left;
    int down;
    int right;

    public boolean right(int start, int end) {
        boolean f = false;
        for (int i = start; i <= end; i++) {
            f = true;
            result[top][i] = count;
            count++;
        }
        top++;

        return f;
    }

    public boolean down(int start, int end) {
        boolean f = false;
        for (int i = start; i <= end; i++) {
            f = true;
            result[i][right] = count;
            count++;
        }
        right--;
        return f;
    }

    public boolean left(int start, int end) {
        boolean f = false;
        for (int i = start; i >= end; i--) {
            f = true;
            result[down][i] = count;
            count++;
        }
        down--;
        return f;
    }

    public boolean up(int start, int end) {
        boolean f = false;
        for (int i = start; i >= end; i--) {
            f = true;
            result[i][left] = count;
            count++;
        }
        left++;
        return f;
    }
}
