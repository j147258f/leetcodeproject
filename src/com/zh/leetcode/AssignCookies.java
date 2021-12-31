package com.zh.leetcode;

import java.util.Arrays;

//455. 分发饼干
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        int sIndex = 0;
        for (int i = 0; i < g.length; i++) {
            if (sIndex == s.length) break;

            if (s[sIndex] >= g[i]) {
                num++;
                sIndex++;
            } else {
                break;
            }
        }
        return num;
    }
}
