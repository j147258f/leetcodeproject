package com.zh.leetcode;

/**
 * 3. 无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        char[] c = s.toCharArray();
        int left = 0;
        int right = left;
        int max = 1;
        for (int i = 1; i < c.length; i++) {
            int index = -1;
            for (int j = left; j <= right; j++) {
                if (c[i] == c[j]) {
                    index = j;
                    break;
                }
            }

            if (index == -1) {
                right++;
            } else {
                if (index == left) {
                    left++;
                    right++;
                } else {
                    left = index + 1;
                    right++;
                }
            }
            if (right - left + 1 > max) {
                max = right - left + 1;
            }
        }

        return max;
    }
}
