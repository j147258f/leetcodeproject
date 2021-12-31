package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 *
 * 时间击败了99.16%的用户
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        add(result, nums, used, 0);
        return result;
    }

    private void add(List<List<Integer>> result, int[] nums, boolean[] used, int start) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < used.length; i++) {
            if (used[i]) l.add(nums[i]);
        }
        result.add(l);

        if (start == used.length) return;

        for (int i = start; i < used.length; i++) {
            used[i] = true;
            add(result,nums, used, i+1);
            used[i] = false;
        }
    }
}
