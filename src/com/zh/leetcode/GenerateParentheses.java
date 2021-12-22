package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 没思路 先做别的
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis(3);
        System.out.println(g.list);
    }

    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        recursiveString("", n, n);
        return list;
    }

    private void recursiveString(String str, int leftNum, int rightNum) {
        if (rightNum < leftNum || rightNum <= -1 || leftNum <= -1) return;

        if (leftNum == 0 && rightNum == 0) {
            list.add(str);
            return;
        }
        if (leftNum == rightNum) {
            recursiveString(str + "(", leftNum - 1, rightNum);
        } else {
            recursiveString(str + "(", leftNum - 1, rightNum);
            recursiveString(str + ")", leftNum, rightNum - 1);
        }

    }

}
