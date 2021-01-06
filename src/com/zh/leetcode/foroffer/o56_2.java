package com.zh.leetcode.foroffer;

public class o56_2 {

    //这题放弃
    public int singleNumber(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        return 0;
    }
}
