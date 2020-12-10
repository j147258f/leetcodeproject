package com.zh.leetcode.foroffer;

public class o13 {

    public static void main(String[] args) {

        new o13().movingCount(1, 2, 1);
    }

    //循环了两遍 所以慢
    public int movingCount(int m, int n, int k) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int sum = sum(i) + sum(j);
                if (sum > k) {
                    dp[i][j] = 1;
                }
            }
        }
        dp[0][0] = 2;
        findWay(dp, 0, 0);
        return num;
    }

    public int sum(int m) {
        int result = 0;
        while (m != 0) {
            result += m % 10;
            m = m / 10;
        }
        return result;
    }

    int num = 1;

    public void findWay(int[][] dp, int i, int j) {

        if (i - 1 >= 0 && dp[i - 1][j] == 0) {
            dp[i - 1][j] = 2;
            num++;
            findWay(dp, i - 1, j);
        }


        if (i + 1 <= dp.length - 1 && dp[i + 1][j] == 0) {
            dp[i + 1][j] = 2;
            num++;
            findWay(dp, i + 1, j);
        }


        if (j - 1 >= 0 && dp[i][j - 1] == 0) {
            dp[i][j - 1] = 2;
            num++;
            findWay(dp, i, j - 1);
        }


        if (j + 1 <= dp[0].length - 1 && dp[i][j + 1] == 0) {
            dp[i][j + 1] = 2;
            num++;
            findWay(dp, i, j + 1);
        }
    }
}
