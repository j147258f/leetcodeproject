package com.zh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//没忍住又做了一题，实现真的low，算法超时
public class ThreeSum {
    public static void main(String[] strings) {
        ThreeSum s=new ThreeSum();
        s.threeSum(new int[]{0, 0, 0, 0});
    }

    List<List<Integer>> fatherList = new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int index1 = 0;
        int index2 = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int lastNum = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == -lastNum) {
                        List<Integer> sonList = new LinkedList<>();
                        sonList.add(nums[i]);
                        sonList.add(nums[j]);
                        sonList.add(nums[k]);
                        if (!isInFatherList(sonList)) fatherList.add(sonList);
                    }
                }
            }
        }
        return fatherList;
    }

    private boolean isInFatherList(List<Integer> sonList) {
        for (List<Integer> item : fatherList) {
            List<Integer> itemCopy=item.stream().collect(Collectors.toList());
            int index1 = itemCopy.indexOf(sonList.get(0));
            if(index1>-1)itemCopy.remove(index1);
            int index2 = itemCopy.indexOf(sonList.get(1));
            if(index2>-1)itemCopy.remove(index2);
            int index3 = itemCopy.indexOf(sonList.get(2));
            if(index3>-1)itemCopy.remove(index3);
            boolean allHas=index1>-1&&index2>-1&&index3>-1;
            if(allHas)return true;
        }
        return false;
    }
}
