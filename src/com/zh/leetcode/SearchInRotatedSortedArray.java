package com.zh.leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] str) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }

    /**
     * 仔细分析mid和最大数最小数之间的关系，会发现在形如4,5,6,1,2,3的数组中
     * 若target为x，则当x>4时，若mid在123中(mid<4)，则left必定在mid的左边
     * x<3时同理
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[0] && target > nums[nums.length - 1]) {
            return -1;
        } else if (target >= nums[0]) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < nums[0]) {
                    right = mid - 1;
                } else {
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else {

                        left = mid + 1;
                    }
                }
            }
        } else if (target <= nums[nums.length - 1]) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else {

                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }


    //不满足题目要求:时间复杂度log(n)
    //此解复杂度为 n+log(n)
    public static int searchNotLogN(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int rotatedIndex = findRotatedIndex(nums);
        if (rotatedIndex == nums.length - 1) {
            if (target < nums[0] || target > nums[rotatedIndex]) {
                return -1;
            }
            return binarySearch(nums, target, 0, rotatedIndex);
        }
        if (target > nums[rotatedIndex] || target < nums[rotatedIndex + 1]) {
            return -1;
        } else if (target >= nums[0] && target <= nums[rotatedIndex]) {
            return binarySearch(nums, target, 0, rotatedIndex);
        } else {
            return binarySearch(nums, target, rotatedIndex + 1, nums.length - 1);
        }
    }

    private static int binarySearch(int[] nums, int target, int startLength, int endStartLength) {
        if (startLength == endStartLength && nums[startLength] == target) {
            return startLength;
        } else if (startLength > endStartLength) {
            return -1;
        }
        int mid = (endStartLength + startLength) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, startLength, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, endStartLength);
        }
    }

    private static int findRotatedIndex(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length - 1;
        }
        int index = 0;
        for (; index < nums.length - 1; index++) {
            if (nums[index] > nums[index + 1]) {
                break;
            }
        }
        return index;
    }
}
