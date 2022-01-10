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
        if (nums1.length < nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        if (nums1[nums1.length - 1] < nums2[0]) {

        }

        int mid1 = nums1[getMidIndex(0, nums1.length - 1)];
        int mid2 = nums2[getMidIndex(0, nums2.length - 1)];
        if (mid1 == mid2) {
            return (mid1 + mid2) / 2d;
        }


        return 0.0;
    }

    private static int getMidIndex(int left, int right) {
        if ((left + right - 1) % 2 == 1) {
            return (left + right) / 2;
        } else {

        }
        return 1;
    }
}
