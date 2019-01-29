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
        System.out.println(isValid("([]"));
    }

    //栈
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int[] stack = new int[chars.length];
        int stackIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (stackIndex == 0) {
                stack[stackIndex] = chars[i];
                stackIndex++;
            }else{
                boolean isLittle = stack[stackIndex-1]=='(' && chars[i]==')';
                boolean isMid=stack[stackIndex-1]=='[' && chars[i]==']';
                boolean isBig=stack[stackIndex-1]=='{' && chars[i]=='}';
                if(isLittle||isMid||isBig){
                    stackIndex--;
                }else{
                    stack[stackIndex] = chars[i];
                    stackIndex++;
                }
            }
        }
        if(stackIndex!=0)return false;
        return true;
    }


    //用消除法，也可以用链表，可能会增加效率
    public static boolean isValid_2(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;

        jump:
        while (size > 0) {
            //寻找第一个)]}
            if (size == 1) return false;
            for (int i = 0; i < size - 1; i++) {
                int j = i + 1;
                boolean little = chars[i] == '(' && chars[j] == ')';
                boolean mid = chars[i] == '[' && chars[j] == ']';
                boolean big = chars[i] == '{' && chars[j] == '}';
                if (little || mid || big) {

                    int numMoved = size - i - 2;
                    if (numMoved > 0) {
                        System.arraycopy(chars, i + 2, chars, i,
                                numMoved);
                        size = size - 2;
                        break;
                    } else if (numMoved == 0) {
                        //如果移动的是最后两位，则判断size-2后的值
                        size = size - 2;
                        if (size == 0) return true;
                        else return false;
                    } else {
                        break jump;
                    }
                }
                if (i == size - 2) {
                    return false;
                }
            }


        }
        if (size != 0) return false;
        return true;
    }

}
