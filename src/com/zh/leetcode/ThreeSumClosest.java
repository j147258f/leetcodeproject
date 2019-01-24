package com.zh.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 后记：三重循环太low，想了一种复杂度n*logn+n的方案，写出代码（就是这个代码）后，失败了
 * 有复杂度n方的：排序，确定一个数然后剩下两个数找最接近，比较简单，就不实现了
 */
public class ThreeSumClosest {
    public static void main(String[] strings) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumClosest(nums, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        //排序
        //依次计算和target的差
        //若第n次差的绝对值为m，第n+1次差为x，且x>m 则终止循环，返回m为答案
        Arrays.sort(nums);
        int leastDiff = Integer.MAX_VALUE;
        int max = maxSum(nums);
        int min = minSum(nums);
        if (target >= max) {
            return max;
        }
        if (target <= min) {
            return min;
        }

        int lastSum = min;
        int dif = lastSum - target;

        Integer left = 0;
        Integer mid = 1;
        Integer right = 2;
        int processMode = 2;
        while (true) {
            switch (processMode) {
                case 2: {
                    if (right + 1 == nums.length) {
                        processMode = 1;
                        continue;
                    } else {
                        right++;
                        int temp_sum = nums[left] + nums[right] + nums[mid];
                        dif = temp_sum - target;
                        if (Math.abs(dif) <= leastDiff) {
                            lastSum = temp_sum;
                            leastDiff = Math.abs(dif);
                            continue;
                        } else {
                            right--;
                            processMode = 1;
                            continue;
                        }
                    }
                }
                case 1: {
                    if (mid + 1 == right) {
                        processMode = 0;
                        continue;
                    } else {
                        mid++;
                        int temp_sum = nums[left] + nums[right] + nums[mid];
                        dif = temp_sum - target;
                        if (Math.abs(dif) <= leastDiff) {
                            lastSum = temp_sum;
                            leastDiff = Math.abs(dif);
                            continue;
                        } else {
                            mid--;
                            processMode = 0;
                            continue;
                        }
                    }
                }
                case 0: {
                    if (left + 1 == mid) {
                        return lastSum;
                    } else {
                        left++;
                        int temp_sum = nums[left] + nums[right] + nums[mid];
                        dif = temp_sum - target;
                        if (Math.abs(dif) <= leastDiff) {
                            lastSum = temp_sum;
                            leastDiff = Math.abs(dif);
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    private static int maxSum(int[] nums) {
        return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
    }

    private static int minSum(int[] nums) {
        return nums[0] + nums[1] + nums[2];
    }
}
