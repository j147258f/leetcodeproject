package com.zh.leetcode.foroffer;

public class o03 {
    public int findRepeatNumber(int[] nums) {
        byte[] b = new byte[100000];
        for (int num : nums) {
            if (b[num] == 0) {
                b[num] = 1;
            }else{
                return num;
            }
        }
        return -1;
    }
}
