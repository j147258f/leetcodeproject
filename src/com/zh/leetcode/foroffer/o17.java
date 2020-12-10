package com.zh.leetcode.foroffer;

public class o17 {
    public int[] printNumbers(int n) {
        if (n == 0) return new int[0];
        int length = 1;
        while (n != 0) {
            length = length * 10;
            n--;
        }

        int[] result = new int[length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
