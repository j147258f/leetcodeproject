package com.zh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三角形最小路径和
 */
public class Triangle {
/*
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 */

    public static void main(String[] strs) {
        List<List<Integer>> triangle = new ArrayList();
        triangle.add(Collections.singletonList(2));
        Integer[] a = {3, 4};
        Integer[] b = {6, 5, 7};
        Integer[] c = {4, 1, 8, 3};
        triangle.add(Arrays.asList(a));
        triangle.add(Arrays.asList(b));
        triangle.add(Arrays.asList(c));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] result = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        result[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> stage = triangle.get(i);
            for (int j = 0; j < stage.size(); j++) {
                int left = 0;
                int right = 0;
                if (j == 0) {
                    left = right = result[i - 1][0];
                } else if (j == stage.size() - 1) {
                    left = right = result[i - 1][j - 1];
                } else {
                    left = result[i - 1][j - 1];
                    right = result[i - 1][j];
                }

                if (left < right) {
                    result[i][j] = left + stage.get(j);
                } else {
                    System.out.println(stage.size() + "----" + j);
                    result[i][j] = right + stage.get(j);
                }
            }
        }

        int max = Integer.MAX_VALUE;
        for (int i = 0; i < result[0].length; i++) {
            if (result[result.length-1][i] < max) {
                max = result[result.length-1][i];
            }
        }

        return max;
    }
}
