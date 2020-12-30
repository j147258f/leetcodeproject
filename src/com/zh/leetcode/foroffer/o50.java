package com.zh.leetcode.foroffer;

import java.util.LinkedHashMap;
import java.util.Map;

public class o50 {
    public static void main(String[] args){
        char c = new o50().firstUniqChar("leetcode");
        System.out.println(c);
    }

    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
