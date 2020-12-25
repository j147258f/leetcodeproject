package com.zh.leetcode.foroffer;

public class o42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < nums[i]) {
                if (dp[i - 1] > 0) dp[i] = dp[i - 1] + nums[i];
                else dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            if (dp[i] > result) result = dp[i];
        }

        return result;
    }

    public int maxSubArray2(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]<0)nums[i]=nums[i];
            else nums[i]+=nums[i-1];
            if(result<nums[i])result = nums[i];
        }
        return result;
    }
}
