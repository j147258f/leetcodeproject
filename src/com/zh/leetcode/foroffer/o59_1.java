package com.zh.leetcode.foroffer;

public class o59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[nums.length - k + 1];
        int max = nums[0];
        for (int i = 1; i <= k - 1; i++) {
            max = Math.max(max, nums[i]);
        }
        r[0] = max;

        int index = 1;
        for (int i = 1; i + k - 1 < nums.length; i++) {
            int right = i + k - 1;
            if (nums[i - 1] == max) {
                max = findMax(nums, i, right);
            } else if (nums[right] > max) {
                max = nums[right];
            }
            r[index] = max;
            index++;
        }

        return r;
    }

    int findMax(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
