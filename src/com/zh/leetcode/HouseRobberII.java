package com.zh.leetcode;

//213. 打家劫舍 II
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
        h.rob(new int[]{200,3,140,20,10});
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < 2) {
                dp[i] = nums[i];
            } else if (i == 2) {
                dp[i] = Math.max(nums[0] + nums[2], nums[1]);
            } else {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            }
            max = Math.max(max,dp[i]);
        }
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i < 3) {
                dp[i] = nums[i];
            } else if (i == 3) {
                dp[i] = Math.max(nums[1] + nums[3], nums[2]);
            } else {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            }
        }

        return Math.max(dp[dp.length - 1], max);
    }
}
