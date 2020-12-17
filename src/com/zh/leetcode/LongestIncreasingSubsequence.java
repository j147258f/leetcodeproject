package com.zh.leetcode;

/**
 * 300
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int dpLength = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[dpLength]) {
                dpLength++;
                if(dpLength>max)max = dpLength;
                dp[dpLength] = nums[i];
            } else {
                if (nums[i] < dp[1]) {
                    dp[1] = nums[i];
                } else {
                    //可以使用二分查找
                    for (int j = dpLength ; j >= 2; j--) {
                        if (nums[i] < dp[j] && nums[i] > dp[j - 1]) {
                            dp[j] = nums[i];
                        }
                    }
                }
            }
        }

        return dpLength;

    }


    public int lengthOfLIS_slow(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > temp) temp = dp[j];
                }
            }
            dp[i] = temp + 1;
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
