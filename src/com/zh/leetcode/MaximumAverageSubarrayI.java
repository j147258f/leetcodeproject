package com.zh.leetcode;

//643. 子数组最大平均数 I
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {

        int pre = 0;
        int left = 0;
        int right = k - 1;
        for (int i = 0; i <= right; i++) {
            pre += nums[i];
        }
        double result = (double) pre / k;
        left++;
        right++;
        while (right  < nums.length) {
            pre = pre - nums[left - 1] + nums[right];
            result = Math.max((double) pre / k, result);
            left++;
            right++;
        }
        return result;
    }
}
