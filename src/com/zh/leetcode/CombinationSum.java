package com.zh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39. 组合总和
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        c.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum(candidates, 0, result, new ArrayList<>(), target);
        return result;
    }

    private void combinationSum(int[] nums, int start, List<List<Integer>> result, List<Integer> l, int target) {
        if (target == 0 || start >= nums.length || nums[start] > target) return;
        int count = target / nums[start];

        combinationSum(nums, start + 1, result, l, target);
        for (int i = 1; i <= count; i++) {
            List<Integer> thisL = new ArrayList<>(l);
            int newTarget = target - i * nums[start];
            for (int j = 0; j < i; j++) {
                thisL.add(nums[start]);
            }
            if (newTarget == 0) {
                result.add(thisL);
                break;
            }
            combinationSum(nums, start + 1, result, thisL, newTarget);
        }
    }
}
