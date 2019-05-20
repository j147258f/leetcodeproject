package com.zh.leetcode;

public class Can_I_Win {
    public static void main(String[] strs) {

    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int maxAmount = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (maxAmount < desiredTotal) {
            return false;
        } else if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (maxChoosableInteger < 3) {
            if (desiredTotal <= 2) return true;
            else return false;
        }

        boolean[][][] cache = new boolean[maxChoosableInteger + 1][maxChoosableInteger + 1][desiredTotal + 1];
        for (int i = cache.length - 1; i > 0; i--) {
            for (int j = i + 1; j < cache[0].length; j++) {
                for (int d = 1; d <= desiredTotal; d++) {
                    for (int k =)
                }
            }
        }


        return true;
    }
}
