package com.zh.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 54 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }

    List<Integer> result;
    int[][] matrix;
    int top;
    int left;
    int down;
    int right;

    public List<Integer> spiralOrder(int[][] matrix) {
        result = new LinkedList<>();
        if (matrix.length == 0) return result;
        this.matrix = matrix;
        top = 0;
        left = 0;
        down = matrix.length - 1;
        right = matrix[0].length - 1;
        while (top < down || left < right) {
            if (!(right(left, right) && down(top, down) && left(right, left) && up(down, top))) {
                break;
            }

        }
        if (top == down && left == right) result.add(matrix[top][left]);
        return result;
    }

    public boolean right(int start, int end) {
        boolean f = false;
        for (int i = start; i <= end; i++) {
            f = true;
            result.add(matrix[top][i]);
        }
        top++;

        return f;
    }

    public boolean down(int start, int end) {
        boolean f = false;
        for (int i = start; i <= end; i++) {
            f = true;
            result.add(matrix[i][right]);
        }
        right--;
        return f;
    }

    public boolean left(int start, int end) {
        boolean f = false;
        for (int i = start; i >= end; i--) {
            f = true;
            result.add(matrix[down][i]);
        }
        down--;
        return f;
    }

    public boolean up(int start, int end) {
        boolean f = false;
        for (int i = start; i >= end; i--) {
            f = true;
            result.add(matrix[i][left]);
        }
        left++;
        return f;
    }


}
