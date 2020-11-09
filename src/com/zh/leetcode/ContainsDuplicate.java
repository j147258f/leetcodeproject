package com.zh.leetcode;

import java.util.Arrays;

/**
 * 217 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        Arrays.sort(nums);
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
            i++;
        }
        return false;
    }
}
