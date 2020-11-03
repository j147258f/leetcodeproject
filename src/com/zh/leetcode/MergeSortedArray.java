package com.zh.leetcode;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if (index2 < 0) {
                nums1[i] = nums1[index1];
                index1--;
            } else if (index1 < 0) {
                nums1[i] = nums2[index2];
                index2--;
            } else if (nums1[index1] < nums2[index2]) {
                nums1[i] = nums2[index2];
                index2--;
            } else {
                nums1[i] = nums1[index1];
                index1--;
            }
        }
    }
}
