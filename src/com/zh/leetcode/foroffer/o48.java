package com.zh.leetcode.foroffer;

import java.util.HashMap;
import java.util.Map;

public class o48 {
    public static void main(String[] args) {
        new o48().lengthOfLongestSubstring("aabaab!bb");
    }

    //代码简洁了  速度慢了
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < chars.length; right++) {
            Integer i = map.get(chars[right]);

            if (i == null) {
                map.put(chars[right], right);
            } else if (i >= left) {
                left = i + 1;
                map.put(chars[right], right);
                continue;
            }else{
                map.put(chars[right], right);
            }

            int length = right - left + 1;
            result = Math.max(length, result);
        }
        return result;
    }

    //时间复杂度o n，代码写的像n方
    public int lengthOfLongestSubstring_badCode(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        int[] dp = new int[255];
        int left = 0;
        int result = 0;
        int right = 0;
        while (left <= s.length() - 1) {
            //移动右窗口
            while (right <= chars.length - 1) {
                if (dp[chars[right]] == 0) {
                    dp[chars[right]] = 1;
                } else {
                    int length = right - left;
                    if (result < length) result = length;
                    break;
                }
                right++;
            }
            //判断右窗口
            if (right == chars.length) {
                int length = right - left;
                if (result < length) result = length;
                return result;
            }
            //移动左窗口
            while (left <= s.length() - 1 && right <= s.length() - 1 && chars[left] != chars[right]) {
                dp[chars[left]] = 0;
                left++;
            }
            left++;
            right++;
        }
        return result;
    }

    //特别慢
    public int lengthOfLongestSubstring_slow(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length; i > 0; i--) {
            int left = 0;
            int right = left + i - 1;
            while (right <= chars.length - 1) {
                boolean equals = false;
                s:
                for (int j = left; j <= right; j++) {
                    for (int h = j + 1; h <= right; h++) {
                        if (chars[j] == chars[h]) {
                            equals = true;
                            break s;
                        }
                    }
                }
                if (!equals) return i;
                left++;
                right = left + i - 1;
            }
        }
        return 0;
    }
}
