package com.zh.leetcode.foroffer;

public class o11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) return numbers[0];

        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i]>numbers[i+1])return numbers[i+1];
        }
        return numbers[0];
    }
}
