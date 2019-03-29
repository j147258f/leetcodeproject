package com.zh.leetcode;

/**
 * Created by zhanghao on 2019/3/17.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] strings) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //todo 两个数组各选取一半，若左侧最大值小于右侧最小值，则调整数组
return 0.0;
    }


    /**
     * 复杂度不对，不是log(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays_notRight(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return midNum(nums2);
        }
        if (nums2.length == 0) {
            return midNum(nums1);
        }

        int allLength = nums1.length + nums2.length;
        int[] tempNums = new int[allLength / 2 + 1];
        int tempIndex = 0;
        int num1Index = 0;
        int num2Index = 0;
        boolean isOdd = allLength % 2 == 1;

        while (true) {
            if (tempIndex > tempNums.length - 1) {
                tempIndex--;
                break;
            }
            if (num1Index >= nums1.length) {
                tempNums[tempIndex] = nums2[num2Index];
                num2Index++;
            } else if (num2Index >= nums2.length) {
                tempNums[tempIndex] = nums1[num1Index];
                num1Index++;
            } else {
                if (nums1[num1Index] < nums2[num2Index]) {
                    tempNums[tempIndex] = nums1[num1Index];
                    num1Index++;
                } else {
                    tempNums[tempIndex] = nums2[num2Index];
                    num2Index++;
                }
            }
            tempIndex++;
        }
        if (isOdd) {
            return tempNums[tempIndex];
        } else {
            return (tempNums[tempIndex] + tempNums[tempIndex - 1]) / 2.0;
        }
    }

    private static double midNum(int[] nums) {
        if (nums.length % 2 == 1) {
            return nums[nums.length / 2];
        } else {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }
    }

}
