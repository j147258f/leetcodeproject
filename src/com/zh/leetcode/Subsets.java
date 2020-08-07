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
    int[] nums;

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Subsets s = new Subsets();
        s.subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        result.add(new ArrayList<>());


        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            proccess(temp, i);

            List<Integer> temp2 = new ArrayList<>();
            temp2.add(this.nums[i]);
            result.add(temp);
        }
        return result;
    }

    private void proccess(List<Integer> nums, int index) {
        //这种是每次少一个  去重判断比较费劲
//        for (int i = 0; i < nums.size(); i++) {
//            List<Integer> temp = new ArrayList<>();
//            for (int j = 0; j < nums.size(); j++) {
//                if(j!=i){
//                    temp.add(nums.get(j));
//                }
//            }
//            proccess(temp);
//            if(!result.contains(temp))
//            result.add(temp);
//        }

        //每次加一个
        for (int i = index + 1; i < this.nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(nums);
            temp.add(this.nums[i]);
            proccess(temp, i);
            result.add(temp);
        }
    }
}
