package com.zh.leetcode;

/**
 * Created by zhanghao on 2019/6/3.
 */
public class MaximumSubarray {
    static public void main(String[] str) {
        int[] i = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(i));
    }

    static public int maxSubArray(int[] nums) {
        int sum = 0;
        int biggestSum = 0;
        int biggestNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (biggestNum < nums[i]) {
                biggestNum = nums[i];
            }

            if (nums[i] > 0) {
                //下一个数会增加最大值
                sum += nums[i];
                if (sum > biggestSum) biggestSum = sum;
            } else {
                //下一个数会减小最大值
                sum += nums[i];
                if (sum < 0) {
                    sum = 0;
                }
            }
        }
        if (biggestNum < 0) {
            return biggestNum;
        }

        if (biggestSum > biggestNum) {
            return biggestSum;
        } else {
            return biggestNum;
        }
    }
}
