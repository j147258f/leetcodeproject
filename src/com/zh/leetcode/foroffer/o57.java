package com.zh.leetcode.foroffer;

public class o57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else break;
        }

        return new int[]{nums[left], nums[right]};
    }
}
