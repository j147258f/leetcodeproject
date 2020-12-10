package com.zh.leetcode.foroffer;

public class o20 {
    public static void main(String[] args) {
        new o20().isNumber(" +51.93483302981e917");
    }

    //虽然写出来了 但是真丑陋  明天用状态机重新
    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        //跳过空格
        while (start != end) {
            if (chars[start] == ' ') start++;
            else if (chars[end] == ' ') end--;
            else break;
        }
        if (start == chars.length) return false;

        //+-
        if (chars[start] != '+' && chars[start] != '-' && !isNumber(chars[start]) && chars[start] != '.') return false;
        //小数点个数
        int littleIndex = -1;
        int littleE = -1;
        int i = start + 1;
        if (chars[start] == '.') littleIndex = start;
        while (i <= end) {
            if (chars[i] == '.') {
                if (littleIndex != -1) return false;
                littleIndex = i;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                if(i-1<start || (!isNumber(chars[i-1])&&chars[i-1]!='.'))return false;
                littleE = i;
                i++;
                break;
            } else if (!isNumber(chars[i])) {
                return false;
            }
            i++;
        }
        if (littleIndex != -1 && (littleIndex - 1 < start || !isNumber(chars[littleIndex - 1]))
                && (littleIndex + 1 > end || !isNumber(chars[littleIndex + 1]))) return false;


        if (littleE != -1) {
            //e的表示
            if (littleE == end) return false;
            if (i <= end && (chars[i] == '-' || chars[i] == '+')) i++;
            if (i > end || !isNumber(chars[i])) return false;
            while (i <= end) {
                if (chars[i] == '.') {
                    return false;
                } else if (chars[i] == 'e' || chars[i] == 'E') {
                    return false;
                } else if (!isNumber(chars[i])) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public boolean isNumber(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }
}
