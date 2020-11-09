package com.zh.leetcode;

import java.util.Arrays;
import java.util.Random;

public class KthLargestElementinanArray {

    public static void main(String[] args) {
        int a = new KthLargestElementinanArray().findKthLargest(new int[]{-1, 2, 0}, 1);
        System.out.println(a);

//        new KthLargestElementinanArray().partition(new int[]{5, 6, 7, 4, 2}, 0, 4);
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest_fast2(nums, nums.length - k, 0, nums.length - 1);
    }


    private static Random random = new Random(System.currentTimeMillis());

    //分治算法  在原数组上进行排序  25% 还是慢
    public int findKthLargest_fast2(int[] nums, int k, int start, int end) {
        if (start == end) return nums[end];
        int index = partition(nums, start, end);
        if (index == k) {
            return nums[index];
        } else if (index > k) {
            return findKthLargest_fast2(nums, k, start, index - 1);
        } else {
            return findKthLargest_fast2(nums, k, index + 1, end);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int index = left + random.nextInt(right - left);
        swap(nums,left,index);
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l != r) {
            if (nums[r] >= pivot) {
                r--;
            } else {
                if (nums[l] <= pivot) {
                    l++;
                } else {
                    swap(nums, l, r);
                }
            }
        }

        swap(nums, l, left);
        return l;
    }

    private void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    //分治算法  时间击败14.83%
    public int findKthLargest_fast(int[] nums, int k, int start, int end) {
        if (start == end) return nums[end];
        int mid = nums[start];
        int[] temp = new int[1 + end - start];
        int temp_l = 0;
        int temp_r = temp.length - 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < mid) {
                temp[temp_l] = nums[i];
                temp_l++;
            } else {
                temp[temp_r] = nums[i];
                temp_r--;
            }
        }
        temp[temp_r] = mid;
        //右侧大小包含mid
        int rightSize = temp.length - temp_r;
        if (rightSize == k) {
            return mid;
        } else if (rightSize > k) {
            return findKthLargest_fast(temp, k, temp_r + 1, temp.length - 1);
        } else {
            return findKthLargest_fast(temp, k - rightSize + 1, 0, temp_r);
        }
    }

    //复杂度为O(kn)
    public int findKthLargest_okn(int[] nums, int k) {

        int result = 0;
        for (int i = 1; i <= k; i++) {
            int max = Integer.MIN_VALUE + 1;
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    index = j;
                }
            }
            nums[index] = Integer.MIN_VALUE;
            result = max;
        }

        return result;
    }


    //使用系统api  没啥意思
    public int findKthLargest_api(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - 1 - (k - 1)];
    }
}
