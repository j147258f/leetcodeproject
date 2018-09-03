package com.zh.leetcode;

/**
 * Created by zhanghao on 2018/5/13.
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args){
      System.out.print( lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int longest=0;
        char chars[] = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < chars.length; i++) {
            int index=stringBuffer.indexOf(String.valueOf(chars[i]));
            if (index >= 0) {
                if(longest<stringBuffer.length())longest=stringBuffer.length();
                stringBuffer=stringBuffer.delete(0,index+1);
                stringBuffer.append(chars[i]);
            }else {
                stringBuffer.append(chars[i]);
            }
        }
        if(longest<stringBuffer.length())longest=stringBuffer.length();
        return longest;
    }
}
