package com.zh.leetcode.foroffer;

public class o60 {
    public static void main(String[] args){
        new o60().dicesProbability(2);
    }

    //动态规划
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n][6 * n];
        for (int i = 1; i <= 6; i++) {
            dp[0][i - 1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i ; j < (i+1 ) * 6; j++) {
                for (int h = 1; j - h>=0&&h<=6; h++) {
                    dp[i][j] += dp[i - 1][j - h];
                }
            }
        }
        double[] count = new double[6 * n - n + 1];
        double count_sum = Math.pow(6d, (double) n);
        for (int i = 0; i < count.length; i++) {
            count[i] = dp[n-1][i+n-1] / count_sum;
        }

        return count;
    }


    //递归解法  速度太慢
    double[] count;
    int offset;

    public double[] dicesProbability_slow(int n) {
        offset = n;
        count = new double[6 * n - n + 1];
        r(n, 0);
        double count_sum = Math.pow(6d, (double) n);
        for (int i = 0; i < count.length; i++) {
            count[i] = count[i] / count_sum;
        }
        return count;
    }

    public void r(int loop, int sum) {
        if (loop != 1) {
            for (int i = 1; i <= 6; i++) {
                r(loop - 1, sum + i);
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                count[sum + i - offset]++;
            }
        }
    }
}
