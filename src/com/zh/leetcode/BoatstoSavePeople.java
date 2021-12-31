package com.zh.leetcode;

import java.util.Arrays;

//881. 救生艇
public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;

        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] > limit) {

                r--;
            }else {
                r--;l++;
            }
            result++;
        }

        return result;
    }
}
