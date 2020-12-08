package com.zh.leetcode.foroffer;

public class o05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i]==' '){
                sb.append("%20");
            }else{
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}
