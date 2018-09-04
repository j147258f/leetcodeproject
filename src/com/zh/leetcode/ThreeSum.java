package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//没忍住又做了一题，实现真的low，算法超时
public class ThreeSum {
    public static void main(String[] strings) {
        ThreeSum s = new ThreeSum();
        s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<Data> fatherList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int lastNum = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == -lastNum) {
                        Data d = new Data();
                        d.produceList(nums[i], nums[j], nums[k]);
                        if (!isInFatherList(d, fatherList)) fatherList.add(d);
                    }
                }
            }
        }
        return fatherList.stream().map(e -> e.list).collect(Collectors.toList());
    }

    private boolean isInFatherList(Data d, List<Data> fatherList) {
        for (Data item : fatherList) {
            if (item.onlineNum == d.onlineNum) {
                if(item.hasZero==d.hasZero){
                    return true;
                }{
                    return false;
                }
            }
        }
        return false;
    }

    static class Data {
        private List<Integer> list = new ArrayList<>(3);
        int onlineNum;
        boolean hasZero = false;

        public List<Integer> produceList(int... ints) {
            int bigNum = 0;
            int index = 0;
            int bigIndex = 0;
            int littleIndex = 0;
            for (int i : ints) {
                list.add(i);
                if (i > 0) {
                    bigNum++;
                    bigIndex = index;
                } else if (i == 0) {
                    hasZero = true;
                } else {
                    littleIndex = index;
                }

                index++;
            }
            if (bigNum == 1) {
                onlineNum = ints[bigIndex];
            } else if (bigNum == 0) {
                onlineNum = 0;
            } else {
                onlineNum = ints[littleIndex];
            }
            return list;
        }
    }
}
