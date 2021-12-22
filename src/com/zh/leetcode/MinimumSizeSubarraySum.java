package com.zh.leetcode;

//209. 长度最小的子数组
public class MinimumSizeSubarraySum {
    public static void main(String[] args){
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        m.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = nums[0];
        int left = 0;
        int right = 0;
        int min = nums.length;
        while (left <= nums.length - 1) {
            if (result < target) {
                right++;
                if (right == nums.length) {
                    break;
                }
                result += nums[right];
            } else if (result >= target) {
                result = result - nums[left];
                left++;
                min = Math.min(min,right-left+1);
                if (left > right) {
                    right = left;
                }
            }
        }
        return min==nums.length?0:min;
    }
}
