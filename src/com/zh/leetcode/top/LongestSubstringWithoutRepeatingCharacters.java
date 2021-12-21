package com.zh.leetcode.top;

//3. 无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int result = 1;

        //设立一个滑动窗口  在数组chars中滑动  该窗口中所有的字符都不重复；每次滑动时记录窗口最大值，滑动完时即得出答案
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            char newC = chars[i];

            //判断newC是否在窗口中重复
            int index = findNewC(newC, chars, left, right);
            if (index != -1) {
                left = index + 1;
                right++;
            } else {
                right++;
            }
            int length = right - left + 1;
            result = Math.max(length, result);
        }
        return result;
    }

    private int findNewC(char newC, char[] chars, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (chars[i] == newC) {
                return i;
            }
        }
        return -1;
    }
}
