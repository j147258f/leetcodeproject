package com.zh.leetcode.foroffer;

public class o49 {
    public static void main(String[] args) {
        new o49().nthUglyNumber(10);
    }

    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        if (n == 4) return 4;
        if (n == 5) return 5;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        int index2 = 4;
        int index3 = 3;
        int index5 = 2;

        int multiply2 = index2 * 2;
        int multiply3 = index3 * 3;
        int multiply5 = index5 * 5;
        for (int i = 7; i < dp.length; i++) {
            int min = Math.min(multiply2, multiply3);
            min = Math.min(min, multiply5);
            dp[i] = min;
            if (min == multiply2) {
                index2++;
                multiply2 = dp[index2] * 2;
            }
            if (multiply3 == min) {
                index3++;
                multiply3 = dp[index3] * 3;
            }
            if (multiply5 == min) {
                index5++;
                multiply5 = dp[index5] * 5;
            }
        }

        return dp[n];
    }
}
