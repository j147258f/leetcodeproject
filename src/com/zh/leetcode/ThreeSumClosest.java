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

        int left = 0;
        int right = nums.length - 1;
        int mid = 1;
        while (true) {
            int dif = difference(nums[left], nums[right], nums[mid], target);
            if (Math.abs(dif) < leastDiff) {
                lastSum = nums[left] + nums[right] + nums[mid];
            }else{
                //若操作导致和target的差值相较上次变大，则需要以最小差值取进行反操作

            }
            leastDiff = Math.abs(dif);
            boolean isSumBiggerThanTarget = dif > 0;
            if (isSumBiggerThanTarget) {
                //如果三数之和大于target，则最右边的指针忘左边移动
                if (right - 1 == mid) {
                    return lastSum;
                }
                right--;
            } else {
                int nextMidDiff = Integer.MIN_VALUE;
                int nextLeftDiff = Integer.MIN_VALUE;
                if (mid + 1 != right) {
                    nextMidDiff = nums[mid + 1] - nums[mid];
                }
                if (nextLeftDiff == Integer.MIN_VALUE && nextMidDiff == Integer.MIN_VALUE) {
                    return lastSum;
                }
                //否则左边的两个指针以最大差值往右边移动
               if(nextMidDiff >= nextLeftDiff){
                   mid++;
                   if(mid == right)return lastSum;
               }else {
                   left++;
                   if(left == mid) return lastSum;
               }
            }
        }
    }

    private static int difference(int a, int b, int c, int d) {
        return a + b + c - d;
    }

    private static int maxSum(int[] nums) {
        return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
    }

    private static int minSum(int[] nums) {
        return nums[0] + nums[1] + nums[2];
    }
}
