package com.zh.leetcode.foroffer;

public class o66 {
    //上下对齐法
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int[] c = new int[a.length];
        c[c.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            c[i] = c[i + 1] * a[i + 1];
            b[i] = b[i] * c[i];
        }

        return b;
    }
}
