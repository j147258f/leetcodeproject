package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public static void main(String[] args) {
        isPalindrome(1210121);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return x == num || x == num / 10;
    }

    public boolean isPalindrome_Slow(int x) {
        if (x < 0) return false;
        int base = 10;
        int count = 0;
        List<Integer> l = new ArrayList<>();
        while (x > 0) {
            int a = x % base;
            x = (x - a) / 10;
            l.add(a);
            count++;
        }

//        int[] nums = new int[count];
        int left = 0;
        int right = l.size() - 1;
        while (left < right) {
            if (!l.get(left).equals(l.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
