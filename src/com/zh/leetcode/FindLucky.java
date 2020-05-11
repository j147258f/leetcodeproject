package com.zh.leetcode;

public class FindLucky {
    public int findLucky(int[] arr) {
        int[] temp = new int[500];
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            temp[t]++;
        }

        int result = -1;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == i && i > result) {
                result = i;
            }
        }
        if(result == 0) return -1;
        return result;
    }
}
