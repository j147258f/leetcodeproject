package com.company;

/**
 *
 * 妈的，这个题难倒不难，就是需要判断的点太多了，改了好多次才把所有情况跑通
 *
 * Created by zhanghao on 2018/5/27.
 */
public class MyAto {

    public static void main(String args[]) {
        System.out.println(myAtoi("   +0 123"));
    }

    public static int myAtoi(String str) {
        int result = 0;
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean first_value_checked = false;
        boolean isMinus = false;
        for (int i = 0; i < chars.length; i++) {
            if (!first_value_checked) {
                if (' ' == chars[i]) continue;
                //第一个字符的相关验证
                first_value_checked = true;
                if ((chars[i] < '0' || chars[i] > '9') && (chars[i] != '+' && chars[i] != '-')) {
                    //第一个字符为无效字符
                    return result;
                } else if (chars[i] == '-') {
                    //第一个字符为'-'
                    isMinus = true;
                } else if (chars[i] == '+' || chars[i] == '0') {

                } else {
                    stringBuilder.append(chars[i]);
                }
            } else {
                if (' ' == chars[i]) break;
                if (chars[i] < '0' || chars[i] > '9') break;
                if (chars[i] == '0') {
                    if (stringBuilder.length() != 0) stringBuilder.append(chars[i]);
                } else stringBuilder.append(chars[i]);
            }
        }
        if (stringBuilder.toString().isEmpty()) return result;

        if (!isMinus && (stringBuilder.length() > 10 || (stringBuilder.length() == 10 && stringBuilder.toString().compareTo(String.valueOf(Integer.MAX_VALUE)) >= 0)))
            return Integer.MAX_VALUE;
        if (isMinus && (stringBuilder.length() > 10 || (stringBuilder.length() == 10 && stringBuilder.toString().compareTo("2147483648") >= 0)))
            return Integer.MIN_VALUE;

        result = Integer.valueOf(stringBuilder.toString());
        if (isMinus) result *= -1;
        return result;
    }
}
