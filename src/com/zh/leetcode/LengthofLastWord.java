package com.zh.leetcode;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        char[] cs = s.toCharArray();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == ' ') {
                if(length!=0)return length;
            } else {
                length++;
            }
        }
        return length;
    }
}
