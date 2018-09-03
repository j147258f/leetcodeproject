package com.zh.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhanghao on 2018/5/13.
 */
public class LongestPalindrome {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abcda"));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int longest = 0;
        String answer = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int start_temp = 0;
            int end_temp = 0;
            int left = i - 1;
            int right = i + 1;
            if ( right >= s.length()) continue;
            //尝试两次
            //1 以当前元素为对称轴
            if(i!=0){
                while (chars[left] == chars[right]) {
                    start_temp = left;
                    end_temp = right;
                    left = left - 1;
                    right = right + 1;
                    if (left < 0 || right >= s.length()) break;

                }
                if (longest < end_temp - start_temp) {
                    longest = end_temp - start_temp;
                    start=start_temp;
                    end=end_temp;
                }
            }
            //2 当前元素及其右共同组成对称轴
            if (i + 1 < s.length() && chars[i] == chars[i + 1]) {
                start_temp = i;
                end_temp = i+1;
                left = i - 1;
                right = i + 2;
                if (longest < end_temp - start_temp) {
                    longest = end_temp - start_temp;
                    start=start_temp;
                    end=end_temp;
                }
                if (left < 0 || right >= s.length()) continue;

                while (chars[left] == chars[right]) {
                    start_temp = left;
                    end_temp = right;
                    left = left - 1;
                    right = right + 1;
                    if (left < 0 || right >= s.length()) break;
                }

                if (longest < end_temp - start_temp) {
                    longest = end_temp - start_temp;
                    start=start_temp;
                    end=end_temp;
                }
            }
        }
        if(s.length()==1)return s;
        return s.substring(start, end+1);
    }
}
