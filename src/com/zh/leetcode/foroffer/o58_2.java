package com.zh.leetcode.foroffer;

public class o58_2 {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                sb.append(chars[i]);
            } else {
                sb2.append(chars[i]);
            }
        }

        return sb2.toString()+sb.toString();
    }
}
