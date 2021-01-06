package com.zh.leetcode.foroffer;

public class o58_1 {
    public static void main(String[] args){
        reverseWords("  hello world!  ");
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = chars.length - 1;
        int right = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                for (int j = left+1; j <= right; j++) {
                    sb.append(chars[j]);
                }
                if (right != left) sb.append(' ');
                right = left = i - 1;
            } else {
                left--;
            }
        }

        for (int j = left + 1; j <= right; j++) {
            sb.append(chars[j]);
        }
        return sb.toString().trim();
    }
}
