package com.zh.leetcode.foroffer;

import java.util.ArrayList;
import java.util.List;

public class o19 {
    public static void main(String[] args) {
        System.out.println(new o19().isMatch("aa", "a*"));
    }

    //击败7% 16%
    public boolean isMatch(String s, String p) {
        List<String> list = new ArrayList<>();
        char[] temp = p.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (i + 1 < temp.length && temp[i + 1] == '*') {
                list.add(temp[i] + "*");
                i++;
            } else {
                list.add(temp[i] + "");
            }
        }
        return matchNext(s.toCharArray(), 0, list.toArray(new String[0]), 0);
    }

    public boolean matchNext(char[] c, int indexC, String[] p, int indexP) {
        if (indexC == c.length&&indexP == p.length)return true;

        if (indexC == c.length) {
            if (p[indexP].contains("*")) return matchNext(c, indexC, p, indexP + 1);
            return false;
        }
        if (indexP == p.length)
            return false;


        boolean b;
        if (p[indexP].equals(".")) {
            b = matchAny(c, indexC, p, indexP);
            if (b) return matchNext(c, indexC + 1, p, indexP + 1);
            return false;
        } else if (p[indexP].contains("*")) {
            b = matchSpecial(c, indexC, p, indexP);
            return b;
        } else {
            b = matchNormal(c, indexC, p, indexP);
            if (b) return matchNext(c, indexC + 1, p, indexP + 1);
            return false;
        }

    }

    public boolean matchNormal(char[] c, int indexC, String[] p, int indexP) {
        return p[indexP].equals(String.valueOf(c[indexC]));
    }

    public boolean matchAny(char[] c, int indexC, String[] p, int indexP) {
        return true;
    }

    public boolean matchSpecial(char[] c, int indexC, String[] p, int indexP) {
        //跳过
        boolean b = matchNext(c, indexC, p, indexP + 1);
        //循环
        if (!b) {
            char[] temp = p[indexP].toCharArray();
            if (temp[0] == c[indexC] || temp[0] == '.') {
                b = matchNext(c, indexC + 1, p, indexP);
            }
        }
        return b;
    }
}