package com.zh.leetcode;

//1221. 分割平衡字符串
public class SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        char[] cs = s.toCharArray();
        int rC = 0;
        int lC = 0;
        int result = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'R') {
                rC++;
            } else {
                lC++;
            }
            if (rC == lC && rC != 0) {
                result++;
                rC = lC = 0;
            }
        }
        return result;
    }
}
