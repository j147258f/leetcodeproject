package com.zh.leetcode;

//1876. 长度为三且各字符不同的子字符串
public class SubstringsofSizeThreewithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int result = 0;
        int left = 0;
        int right = 2;
        char[] cs = s.toCharArray();
        while (right < cs.length) {
            if (cs[left] != cs[right] && cs[left] != cs[right-1] && cs[left+1] != cs[right]) {
                result++;
            }
            left++;
            right++;
        }

        return result;
    }
}
