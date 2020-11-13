package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinationsofaPhoneNumber {

    static List<String> list2 = new ArrayList<>();
    static List<String> list3 = new ArrayList<>();
    static List<String> list4 = new ArrayList<>();
    static List<String> list5 = new ArrayList<>();
    static List<String> list6 = new ArrayList<>();
    static List<String> list7 = new ArrayList<>();
    static List<String> list8 = new ArrayList<>();
    static List<String> list9 = new ArrayList<>();

    static {
        list2.add("a");
        list2.add("b");
        list2.add("c");

        list3.add("d");
        list3.add("e");
        list3.add("f");

        list4.add("g");
        list4.add("h");
        list4.add("i");

        list5.add("j");
        list5.add("k");
        list5.add("l");

        list6.add("m");
        list6.add("n");
        list6.add("o");

        list7.add("p");
        list7.add("q");
        list7.add("r");
        list7.add("s");

        list8.add("t");
        list8.add("u");
        list8.add("v");

        list9.add("w");
        list9.add("x");
        list9.add("y");
        list9.add("z");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] c = digits.toCharArray();
        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case '2': {
                    result = combinate(result, list2);
                    break;
                }
                case '3': {
                    result = combinate(result, list3);
                    break;
                }
                case '4': {
                    result = combinate(result, list4);
                    break;
                }
                case '5': {
                    result = combinate(result, list5);
                    break;
                }
                case '6': {
                    result = combinate(result, list6);
                    break;
                }
                case '7': {
                    result = combinate(result, list7);
                    break;
                }
                case '8': {
                    result = combinate(result, list8);
                    break;
                }
                case '9': {
                    result = combinate(result, list9);
                    break;
                }
            }
        }

        return result;
    }

    public List<String> combinate(List<String> a, List<String> b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        List<String> result = new ArrayList<>();
        a.forEach(e -> {
            b.forEach(e1 -> {
                result.add(e + e1);
            });
        });

        return result;
    }
}
