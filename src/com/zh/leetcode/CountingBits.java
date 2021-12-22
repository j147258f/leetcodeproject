package com.zh.leetcode;

//338. 比特位计数
public class CountingBits {
    public static void main(String[] args) {
        CountingBits c = new CountingBits();
        c.countBits(4);
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int num = 1;
        for (int i = 1; i <= n; i++) {
            if (i == num) {
                num = num * 2;
                result[i] = 1;
                continue;
            }
            result[i] = result[i - num / 2] + 1;
        }
        return result;
    }
}
