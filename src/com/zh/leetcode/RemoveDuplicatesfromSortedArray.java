package com.zh.leetcode;

/**
 * 26 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 2});
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;
        int a = nums[0];
        int exchange = 1;
        for (int i = 1; i < nums.length; i++) {
            if (a != nums[i]) {
                count++;
                a = nums[i];
                int temp = nums[exchange];
                nums[exchange] = nums[i];
                nums[i] = temp;
                exchange++;

            }
        }

        return count;
    }
}
