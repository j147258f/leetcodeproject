package com.company;

/**
 * Created by zhanghao on 2018/5/13.
 */
public class FindMedianSortedArrays {
    public static void main(String[] args){
        System.out.println(3/2);
        System.out.println(1/2);
        System.out.println(5/2);
        findMedianSortedArrays(new int[]{},new int[]{2,3});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isNums1 = true;
        int length_all = nums1.length + nums2.length;
        int[] temps = new int[length_all];
        int index_1 = 0;
        int index_2 = 0;
        int index_temp = 0;
        if (nums1.length == 0) {
            temps = nums2;
        }
        if (nums2.length == 0) {
            temps = nums1;
        }
        if (nums1.length != 0 && nums2.length != 0) {
            while (true) {
                if (index_1 == nums1.length) {
                    break;
                }
                if (index_2 == nums2.length) {
                    isNums1 = false;
                    break;
                }
                if (nums1[index_1] < nums2[index_2]) {
                    temps[index_temp] = nums1[index_1];
                    index_temp++;
                    index_1++;
                } else {
                    temps[index_temp] = nums2[index_2];
                    index_temp++;
                    index_2++;
                }
            }
            if (isNums1) {
                while (index_2 < nums2.length) {
                    temps[index_temp] = nums2[index_2];
                    index_temp++;
                    index_2++;
                }
            } else {
                while (index_1 < nums1.length) {
                    temps[index_temp] = nums1[index_1];
                    index_temp++;
                    index_1++;
                }
            }
        }


        int center = 0;
        center = length_all / 2;
        if (length_all % 2 == 1) {
            return (temps[center]);
        } else {
            return (temps[center] + temps[center - 1]) / 2.0;
        }
    }
}
