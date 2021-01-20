package com.zh.leetcode.foroffer;

public class o61 {
    public boolean isStraight(int[] nums) {
        int[] dp = new int[14];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (dp[nums[i]] != 0) return false;
            dp[nums[i]] = 1;
        }
        int min = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) {
               min = i;
               break;
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            if(dp[i]!=0){
                max = i;
                break;
            }
        }

        return max-min<5;
    }
}
