package com.zh.leetcode;

public class SumofAllSubsetXORTotals {
    public static void main(String[] args) {

    }

    public int subsetXORSum(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        return sumTheXOR(nums, dp, 0);
    }

    private int sumTheXOR(int[] nums, boolean[] dp, int start) {
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                result = result ^ nums[i];
            }
        }
        for (int i = start; i < nums.length; i++) {
            dp[i] = true;
            result += sumTheXOR(nums, dp, i + 1);
            dp[i] = false;
        }
        return result;
    }
}
