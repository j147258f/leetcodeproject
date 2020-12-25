package com.zh.leetcode.foroffer;

public class o40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if(k==0)return result;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            result[index++] = arr[i];
            if (i == k - 1) return result;
        }
        return result;
    }
}
