package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

//14 最长公共前缀
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        List<char[]> l = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            l.add(strs[i].toCharArray());
        }

        StringBuilder sb = new StringBuilder();
        char[] c = strs[0].toCharArray();

        b:
        for (int i = 0; i < c.length; i++) {
            for (int i1 = 1; i1 < l.size(); i1++) {
                if (l.get(i1).length == i || c[i] != l.get(i1)[i]) {
                    break b;
                }
            }
            sb.append(c[i]);
        }
        return sb.toString();

    }
}
