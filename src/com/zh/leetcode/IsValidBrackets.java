package com.zh.leetcode;

import java.util.ArrayList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 用栈做很简单，但是没难度，想个别的实现（虽然可能更复杂）
 */
public class IsValidBrackets {
    public static void main(String[] str) {
        ArrayList<String> s=new ArrayList();
        s.remove(0);
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (chars[0] != ' ') {
            //寻找第一个)]}
            for (int i = 0; i < s.length() - 1; i++) {
                int j = i + 1;
                if (chars[i] == '(' && chars[j] == ')') {
                    char[] charsTemp1 = new char[s.length()];
                    char[] charsTemp2 = new char[s.length()];
                    System.arraycopy(chars, 0, charsTemp1, 0, i);
                    System.arraycopy(chars, j, charsTemp1, 0, s.length() - j);


                    break;
                }
            }
        }
        return true;
    }

    private static void remove(char[] chars,int size,int index){
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(chars, index+2, chars, index+1,
                    numMoved);
    }
}
