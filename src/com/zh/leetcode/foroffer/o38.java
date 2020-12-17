package com.zh.leetcode.foroffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class o38 {
    List<String> list = new ArrayList<>();

    //回溯法
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return list.toArray(new String[0]);
    }

    public String[] permutation_1(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        r_1(new char[0],chars);
        return list.toArray(new String[0]);
    }

    //击败98.66% 94%
    public void r_1(char[] chars, char[] available) {
        if (available.length == 1) {
            char[] temp = new char[chars.length + 1];
            System.arraycopy(chars, 0, temp, 0, chars.length);
            temp[temp.length - 1] = available[0];
            list.add(new String(temp));
            return;
        }
        for (int i = 0; i < available.length; i++) {
            if(i!=0&&available[i]==available[i-1])continue;
            char[] temp = new char[chars.length + 1];
            System.arraycopy(chars, 0, temp, 0, chars.length);
            temp[temp.length - 1] = available[i];
            char[] temp2 = new char[available.length - 1];
            int temp2Inede = 0;
            for (int j = 0; j < available.length; j++) {
                if (j != i) {
                    temp2[temp2Inede] = available[j];
                    temp2Inede++;
                }
            }
            r_1(temp, temp2);
        }
    }
}
