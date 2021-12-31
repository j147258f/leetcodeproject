package com.zh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhanghao on 2019/3/6.
 * 递归实现，leetcode用时5ms 还可以，但是内存使用多了 35mb
 *
 *
 */
public class Permutations {
    public static void main(String[] strings) {
        permute(new int[]{1, 2, 3}).forEach(e -> {
            e.forEach(s -> System.out.print(s));
            System.out.println();
        });
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        addToList(result, nums, 0, nums.length - 1);
        return result;
    }

    public static void addToList(List<List<Integer>> result, int[] nums, int left, int right) {
        if (left == right) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                l.add(num);
            }
            result.add(l);
            return;
        }
        for (int i = left; i < nums.length; i++) {
            swap(nums,i,left);
            addToList(result,nums,left+1,right);
            swap(nums,i,left);
        }

    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }


    public static List<List<Integer>> permute_old(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> usedIndex = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            usedIndex.add(i);
            tempList.add(nums[i]);
            process(result, tempList, nums, usedIndex, 1);
            tempList.clear();
            usedIndex.clear();
        }
        return result;
    }

    private static void process(List<List<Integer>> result, List<Integer> tempList, int[] nums, List<Integer> usedIndex,int recursionCount) {
        if (recursionCount == nums.length) {
            result.add(clone(tempList));
            return;
        }
        int index = 0;
        while (index < nums.length) {
            if (!usedIndex.contains(index)) {
                tempList.add(nums[index]);
                usedIndex.add(index);
                process(result, tempList, nums, usedIndex,recursionCount+1);
                tempList.remove(tempList.size()-1);
                usedIndex.remove(usedIndex.size()-1);
            }
            index++;
        }
    }

    private static List<Integer> clone(List<Integer> input) {
        List<Integer> list = new ArrayList<>();
        list.addAll(input);
        return list;
    }
//网上答案
    public static void permute2(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        List<List<Integer>> result = new ArrayList<>();
        fullSort(result,arr, 0, arr.length - 1);
    }

    public static void fullSort(List<List<Integer>> result,int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (int i : arr) {
                list.add(i);
            }
            result.add(list);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(result,arr, start + 1, end);
            swap(arr, i, start);
        }
    }

}
