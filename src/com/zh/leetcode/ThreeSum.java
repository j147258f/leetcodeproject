package com.zh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//没忍住又做了一题，实现真的low，算法超时
public class ThreeSum {
    public static void main(String[] strings) {
        ThreeSum s = new ThreeSum();
        s.threeSum(new int[]{-1,0,1,2,-1,-4});
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<Data> fatherList = new LinkedList<>();
        if (nums.length < 3) return fatherList.stream().map(e -> e.list).collect(Collectors.toList());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                int sumWithTwo = nums[i] + nums[j];
                if(sumWithTwo>0){
                    break;
                }
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[k] == -sumWithTwo) {
                        Data d = new Data();
                        d.produceList(nums[i], nums[j], nums[k]);
                        if (!isInFatherList(d, fatherList)) {
                            fatherList.add(d);
                            break;
                        }
                    }
                }
            }
        }

        return fatherList.stream().map(e -> e.list).collect(Collectors.toList());
    }

    private boolean isInFatherList(Data d, List<Data> fatherList) {
        for (Data item : fatherList) {
            if (item.string.equals(d.string)) {
                return true;
            }
        }
        return false;
    }

    static class Data {
        private List<Integer> list = new ArrayList<>(3);
        String string = "";

        public void produceList(int... ints) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : ints) {
                list.add(i);
                stringBuilder.append(i);
            }
            string = stringBuilder.toString();
        }
    }
}
