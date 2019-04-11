package com.zh.leetcode;

/**
 * Created by zhanghao on 2019/3/28.
 */
public class UniquePaths2 {
    public static void main(String[] strings) {
        int[][] obstacleGrid = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;

        int[][] range = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (i != 0 && range[i - 1][0] == 0) range[i][0] = 0;
            else if (obstacleGrid[i][0] == 0) range[i][0] = 1;
            else range[i][0] = 0;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (i != 0 && range[0][i - 1] == 0) range[0][i] = 0;
            else if (obstacleGrid[0][i] == 0) range[0][i] = 1;
            else range[0][i] = 0;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    range[i][j] = 0;
                    continue;
                }else {
                    range[i][j] = range[i][j - 1] + range[i - 1][j];
                }
            }
        }
        return range[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
