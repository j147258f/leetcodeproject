package com.zh.leetcode;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int pre = 0;
        while (left < nums.length) {
            if (right <= left) {
                right = left;
                pre = nums[left];
                if (pre >= k) {
                    left++;
                    right++;
                } else {
                    result++;
                    right++;
                }
                if (right == nums.length) {
                    left++;
                    right = left;
                    continue;
                }
                pre = pre * nums[right];
                continue;
            }
            if (pre >= k) {
                left++;
                right = left;
            } else {
                result++;
                right++;
                if (right == nums.length) {
                    left++;
                    right = left;
                    continue;
                }
                pre = pre * nums[right];
            }
        }
        return result;
    }
}
