package com.zh.leetcode.foroffer;

public class o29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return result;
        this.matrix = matrix;
        this.result = new int[matrix.length * matrix[0].length];
        top = 0;
        left = 0;
        down = matrix.length - 1;
        right = matrix[0].length - 1;
        while (top < down || left < right) {
            if (!(right(left, right) && down(top, down) && left(right, left) && up(down, top))) {
                break;
            }

        }
        if (top == down && left == right) {
            result[resultIndex++] = (matrix[top][left]);
        }
        return result;
    }

    int[] result;
    int resultIndex;
    int[][] matrix;
    int top;
    int left;
    int down;
    int right;

    public boolean right(int start, int end) {
        boolean f = false;
        for (int i = start; i <= end; i++) {
            f = true;
            result[resultIndex++] = (matrix[top][i]);
        }
        top++;

        return f;
    }

    public boolean down(int start, int end) {
        boolean f = false;
        for (int i = start; i <= end; i++) {
            f = true;
            result[resultIndex++] = (matrix[i][right]);
        }
        right--;
        return f;
    }

    public boolean left(int start, int end) {
        boolean f = false;
        for (int i = start; i >= end; i--) {
            f = true;
            result[resultIndex++] = (matrix[down][i]);
        }
        down--;
        return f;
    }

    public boolean up(int start, int end) {
        boolean f = false;
        for (int i = start; i >= end; i--) {
            f = true;
            result[resultIndex++] = (matrix[i][left]);
        }
        left++;
        return f;
    }
}
