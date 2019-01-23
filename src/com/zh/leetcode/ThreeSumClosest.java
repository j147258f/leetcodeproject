package com.zh.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class ThreeSumClosest {
    public static void main(String[] strings) {
        int[] nums = {-3, -2, -5, 3, -4};
        System.out.println(threeSumClosest(nums, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        //排序
        //依次计算和target的差
        //若第n次差的绝对值为m，第n+1次差为x，且x>m 则终止循环，返回m为答案
        Arrays.sort(nums);
        int lastSum = 0;
        int leastDiff = Integer.MAX_VALUE;
        int max = maxSum(nums);
        int min = minSum(nums);
        if (target >= max) {
            return max;
        }
        if (target <= min) {
            return min;
        }

        int left = 0;
        int right = nums.length;
        int mid = 1;
        boolean flag = false;
        while (true) {
            int dif = difference(nums[left], nums[right], nums[mid], target);
            if (dif < leastDiff) {
                lastSum = nums[left] + nums[right] + nums[mid];
                leastDiff = dif;
                flag = true;
            } else {
                int nextLeftDiff = nums[left + 1] - nums[left];
                int nextRightDiff = nums[right + 1] - nums[right];
                int nextMidLeftDiff = nums[mid + 1] - nums[mid];
                int nextMidRightDiff = nums[mid - 1] - nums[mid];
            }
        }
    }

    private static int difference(int a, int b, int c, int d) {
        int sum = a + b + c - d;
        if (sum < 0) {
            return -sum;
        } else {
            return sum;
        }
    }

    private static int maxSum(int[] nums) {
        return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
    }

    private static int minSum(int[] nums) {
        return nums[0] + nums[12] + nums[2];
    }
}
