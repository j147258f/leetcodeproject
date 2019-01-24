package com.zh.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class ThreeSumClosest {
    public static void main(String[] strings) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(nums, 82));
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

        Integer left = 0;
        Integer right = 2;
        Integer mid = 1;
        int lastChangeIndex = -1;
        while (true) {

            int temp_sum = nums[left] + nums[right] + nums[mid];
            int dif = temp_sum - target;
            if (Math.abs(dif) < leastDiff) {
                lastSum = temp_sum;
            } else {
                switch (lastChangeIndex){
                    case  0:{
                        break;
                    }
                    case 1:{
                        break;
                    }
                    case 2:{
                        break;
                    }
                }
                return lastSum;
            }
            leastDiff = Math.abs(dif);

            int nextMidDiff = Integer.MIN_VALUE;
            int nextLeftDiff = Integer.MIN_VALUE;
            int nextRightDiff = Integer.MIN_VALUE;
            if (mid + 1 != right) {
                nextMidDiff = nums[mid + 1] - nums[mid];
            }
            if (left + 1 != mid) {
                nextLeftDiff = nums[left + 1] - nums[left];
            }
            if (right + 1 != nums.length) {
                nextRightDiff = nums[right + 1] - nums[right];
            }
            int minInDiff = findMax(nextMidDiff, nextLeftDiff, nextRightDiff);
            if (minInDiff == Integer.MIN_VALUE) {
                return lastSum;
            }
            if (minInDiff == nextLeftDiff) {
                left++;
            } else if (minInDiff == nextMidDiff) {
                mid++;
            } else if (minInDiff == nextRightDiff) {
                right++;
            }
        }
    }

    private static int findMax(int a, int b, int c) {
        int max = a;
        if (b > a) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    private static int maxSum(int[] nums) {
        return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
    }

    private static int minSum(int[] nums) {
        return nums[0] + nums[1] + nums[2];
    }
}
