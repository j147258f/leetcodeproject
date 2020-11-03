package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 * 可以使用递归或者迭代
 */
public class GrayCode {
//    List<Integer> list = new ArrayList<>();
//
//    public static void main(String[] args) {
//        GrayCode gc = new GrayCode();
//        gc.grayCode(2);
//    }
//
//    //递归版本
//    public List<Integer> grayCode(int n) {
//        if (n == 1) {
//            List<Integer> temp = new ArrayList<>();
//            temp.add(0);
//            temp.add(1);
//            addToResult(temp);
//        }else{
//
//            grayCode(n-1);
//        }
//
//        return list;
//    }
//
//    private void addToResult(List<Integer> add) {
//        for (int i = add.size() - 1; i >= 0; i--) {
//            list.add(add.get(i));
//        }
//    }
//
//    //迭代版本
//    public List<Integer> grayCode(int n) {
//        if (n == 1) {
//            List<Integer> temp = new ArrayList<>();
//            temp.add(0);
//            temp.add(1);
//            addToResult(temp);
//        }else{
//
//            grayCode(n-1);
//        }
//
//        return list;
//    }
}
