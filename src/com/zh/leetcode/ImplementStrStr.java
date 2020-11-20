package com.zh.leetcode;

/**
 * 28
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr i = new ImplementStrStr();
        String h = "mississippi";
        String n = "sip";

        System.out.println(i.strStr_kmp(h, n));
        System.out.println(i.strStr_low(h, n));

    }

    public int strStr_kmp(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        int[][] dp = new int[needle.length()][200];
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();

        dp[0][nc[0]] = 1;
        int x = 0;
        for (int i = 1; i < nc.length; i++) {
            for (int j = 0; j < 200; j++) {
                if (nc[i] == j) {
                    //字符串匹配上了  状态+1
                    dp[i][j] = i + 1;
                } else {
                    //更新前置位
                    dp[i][j] = dp[x][j];
                }
            }
            //更新x
            x = dp[x][nc[i]];
        }

        int j = 0;
        for (int i = 0; i < hc.length; i++) {
            j = dp[j][hc[i]];
            if (j == nc.length)
                return i - nc.length + 1;
        }

        return -1;
    }

    public int strStr_low(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();

        for (int i = 0; i < hc.length; i++) {
            out:
            if (hc[i] == nc[0]) {
                //确保haystack长度足够
                if (i + needle.length() > hc.length) {
                    return -1;
                }

                for (int j = 1; j < nc.length; j++) {
                    if (hc[i + j] != nc[j]) {
                        break out;
                    }
                }
                return i;
            }
        }
        return -1;
    }
}
