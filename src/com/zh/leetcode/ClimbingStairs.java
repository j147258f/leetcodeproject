package com.zh.leetcode;

/**
 * 爬楼梯
 */
public class ClimbingStairs {
    public static void main(String[] strs) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 0) return 0;
        else if (n == 2) return 2;
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
