package com.zh.leetcode;

//375. 猜数字大小 II
public class GuessNumberHigherorLowerII {
    public static void main(String[] args) {
        GuessNumberHigherorLowerII g = new GuessNumberHigherorLowerII();
        System.out.println(g.getMoneyAmount(14));
    }

    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int[][] dp = new int[n + 2][n + 2];
        cal(dp, 1, n);

        return dp[1][n];
    }

    private void cal(int[][] dp, int left, int right) {
        if(left>right)return;
        if (dp[left][right] != 0) return;
        if (left == right) {
            dp[left][right] = 0;
            return;
        }
        if (left + 1 == right) {
            dp[left][right] = left;
            return;
        }
        if (left + 2 == right) {
            dp[left][right] = left + 1;
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            cal(dp,left,i-1);
            cal(dp,i+1,right);
            int sum = i + Math.max(dp[left][i - 1],dp[i + 1][right]);
            min = Math.min(min, sum);
        }
        dp[left][right] = min;
    }
}
