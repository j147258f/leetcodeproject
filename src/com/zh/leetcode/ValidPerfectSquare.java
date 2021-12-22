package com.zh.leetcode;

//367. 有效的完全平方数
public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare v = new ValidPerfectSquare();
        v.isPerfectSquare(808201);
    }

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num/2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long s = (long)mid * mid;
            if (s == num) {
                return true;
            }
            if (s > num ) {
                right = mid - 1;
            } else {
                 left = mid + 1;
            }
        }
        return false;
    }
}
