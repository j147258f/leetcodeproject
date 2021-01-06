package com.zh.leetcode.foroffer;

public class o53_1 {
    public int search(int[] nums, int target) {
        int index = find(nums, 0, nums.length - 1, target);
        if (index == -1) return 0;
        int result = 1;
        int temp = index + 1;
        while (temp < nums.length && nums[temp] == target) {
            result++;
            temp++;
        }
        temp = index - 1;
        while (temp > -1 && nums[temp] == target) {
            result++;
            temp--;
        }
        return result;
    }

    public int find(int[] nums, int left, int right, int target) {
        if (left >= right){
            int t = left;
            if(right<0){

            }else {
                t = right;
            }
            if(nums[t]!=target){
                return -1;
            }
            return t;

        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return find(nums, left, mid - 1, target);
        } else {
            return find(nums, mid + 1, right, target);
        }
    }
}
