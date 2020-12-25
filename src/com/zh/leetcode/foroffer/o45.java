package com.zh.leetcode.foroffer;

import java.util.Arrays;

public class o45 {
    public static void main(String[] args){
        new o45().minNumber(new int[]{3,30,34,5,9});
    }

    public String minNumber(int[] nums) {
        String[] in = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            in[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(in, ((a, b) -> {
            return compare(String.valueOf(a), String.valueOf(b));
        }));

        StringBuilder sb = new StringBuilder();
        for (String s : in) {
            sb.append(s);
        }
        return sb.toString();
    }

    //选择a 1 选b -1
    int compare(String a, String b) {
        int maxLength  = a.length()+b.length();
        int newA =Integer.parseInt(a) ;
        int newB =Integer.parseInt(b);
        int i = maxLength-a.length();
        while(i!=0){
            newA*=10;
            i--;
        }
        i = maxLength-b.length();
        while(i!=0){
            newB*=10;
            i--;
        }
        newA = newA+Integer.parseInt(b);
        newB = newB+Integer.parseInt(a);
        return newA-newB;
    }

}
