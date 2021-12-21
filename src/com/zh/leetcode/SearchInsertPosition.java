package com.zh.leetcode;

//35. 搜索插入位置
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int mid = (nums.length - 1) / 2;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        if (target > nums[mid]) return mid + 1;
        return mid;
    }

}
