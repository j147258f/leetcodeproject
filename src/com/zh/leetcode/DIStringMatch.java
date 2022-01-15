package com.zh.leetcode;

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        char[] chars = s.toCharArray();
        int iCount = 0;
        int dCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                iCount++;
                result[i] = iCount-1;
            } else {
                dCount++;
                result[i] = s.length() + 1 -dCount +1;
            }
        }
        if(chars[chars.length-1]=='I'){
            result[chars.length]=result[chars.length-1]+1;
        }else{
            result[chars.length]=result[chars.length-1]-1;
        }
        return result;
    }
}
