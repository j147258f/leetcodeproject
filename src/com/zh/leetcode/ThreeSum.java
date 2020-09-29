package com.zh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//没忍住又做了一题，实现真的low，算法超时
public class ThreeSum {
    public static void main(String[] strings) {
        ThreeSum s = new ThreeSum();
        List<List<Integer>> l = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        l.forEach(e -> {
            System.out.print(e + "_");
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int h = nums.length - 1;
            while (j < h) {
                int sum = nums[j] + nums[i] + nums[h];
                if (sum == 0) {
                    if (j != i + 1 && nums[j] == nums[j - 1]) {
                        j ++;
                        continue;
                    }

                    List<Integer> t = new ArrayList<Integer>();
                    t.add(nums[j]);
                    t.add(nums[i]);
                    t.add(nums[h]);
                    l.add(t);
                    j++;
                } else if (sum > 0) {
                    h--;
                } else {
                    j++;
                }
            }
        }
        return l;
    }

}

