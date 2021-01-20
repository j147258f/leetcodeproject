package com.zh.leetcode.foroffer;

public class o62 {
    public static void main(String[] args) {
        new o62().lastRemaining(5, 3);
    }
//      数学方法。。。。
//    public int lastRemaining(int n, int m) {
//        int result = 0;
//        for(int i = 2;i<=n;i++){
//            result = (result+m)%i;
//        }
//        return result;
//    }

    int[] dp;

    public int lastRemaining(int n, int m) {
        dp = new int[n];
        r(m, 0, 0);
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]!=-1)return i;
        }
        return -1;
    }

    public void r(int m, int start, int delete) {
        if (delete == dp.length - 1) return;
        int i = 0;
        while (i != m) {
            if (dp[start] != -1) {
                i++;
            }
            if (i == m) break;
            start++;
            if (start == dp.length) start = 0;
        }
        dp[start++] = -1;
        if (start == dp.length) start = 0;
        r(m, start, ++delete);
    }
}
