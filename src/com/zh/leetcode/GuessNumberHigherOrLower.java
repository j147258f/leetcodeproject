package com.zh.leetcode;

/**
 * 没做出来，这是网上的答案，好在我理解了这个题
 */
public class GuessNumberHigherOrLower {
    public static void main(String[] str) {
        System.out.println(getMoneyAmount(5));
    }

    public static int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        int[][] collection = new int[n + 1][n + 1];
        for (int right = 2; right <= n; right++) {
            for (int left = right - 1; left >= 0; left--) {

                int min = Integer.MAX_VALUE;

                for (int k = left + 1; k < right; k++) {
                    int max = k + Math.max(collection[left][k - 1], collection[k + 1][right]);
                    min = Math.min(max, min);
                }
                collection[left][right] = left + 1 == right ? left : min;
            }
        }
        return collection[1][n];
    }

}
