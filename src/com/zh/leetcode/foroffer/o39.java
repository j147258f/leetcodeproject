package com.zh.leetcode.foroffer;

public class o39 {

    public static void main(String[] args) {
        new o39().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    //真慢 2581 ms, 在所有 Java 提交中击败了5.12%的用户
    public int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
            if (nums.length - 1 - i <= nums.length / 2) return nums[nums.length - i - 1];
        }
        return nums[nums.length / 2];
    }

    //摩尔投票解法
    public int majorityElement_more(int[] nums) {
        int baseNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (baseNum == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    baseNum = nums[i];
                    count = 1;
                }
            }
        }
        return baseNum;
    }
}
