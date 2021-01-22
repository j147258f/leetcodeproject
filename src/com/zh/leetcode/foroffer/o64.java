package com.zh.leetcode.foroffer;

public class o64 {
    //这题好无聊 抄答案
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
