package com.zh.leetcode;

public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        new FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{2, 2}, 3);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0) return result;
        searchRangeLeft(nums, target, 0, nums.length, result);
        return result;
    }

    public void searchRangeLeft(int[] nums, int target, int left, int right, int[] result) {
        if (left == right) {
            if (left > -1 && left < nums.length && nums[left] == target) {
                result[0] = left;
                result[1] = left;
                return;
            }
            return;
        }
        int mid = (right + left) / 2;
        if (nums[mid] < target) {
            searchRangeLeft(nums, target, mid + 1, right, result);
        } else if (nums[mid] > target) {
            searchRangeLeft(nums, target, left, mid, result);
        } else {
            int i = mid;
            int j = mid;
            while (true) {
                if (i > -1 && nums[i] == target) {
                    result[0] = i;
                    i--;
                } else if (j < nums.length && nums[j] == target) {
                    result[1] = j;
                    j++;
                } else {
                    return;
                }

            }
        }
    }
}
