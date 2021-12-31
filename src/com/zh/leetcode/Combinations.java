package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

//77. 组合
public class Combinations {

    public static void main(String[] args){
        Combinations c = new Combinations();
        c.combine(5,3);
    }

    int count;

    public List<List<Integer>> combine(int n, int k) {
        count = k;
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        add(result, used, k, 0);
        return result;
    }

    private void add(List<List<Integer>> result, boolean[] used, int k, int start) {
        if (k == 0) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < used.length; i++) {
                if (used[i]) {
                    l.add(i + 1);
                }
            }
            if (l.size() == count) {
                result.add(l);
            }
            return;
        }
        for (int i = start; i < used.length; i++) {
            used[i] = true;
            add(result, used, k - 1, i + 1);
            used[i] = false;
        }
    }
}
