package com.zh.leetcode.foroffer;

import java.util.ArrayList;
import java.util.List;

public class o58 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> l = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            int sum = 0;
            int j = i;
            while (sum < target) {
                sum += j;
                j++;
            }
            if (sum == target) {
                int[] temp = new int[j-i+1];
                int index  = i;
                for (int h = 0; h < temp.length; h++) {
                    temp[h] = index;
                    index++;
                }
                l.add(temp);
            }
        }
        return l.toArray(new int[0][]);
    }
}
