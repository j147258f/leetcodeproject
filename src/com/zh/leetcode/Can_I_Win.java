package com.zh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 网上找的答案，大体思路明白了，就是感觉自己想的话不太好想到
 */
public class Can_I_Win {
    public static void main(String[] strs) {
        System.out.println(canIWin(5, 7));
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

        Boolean[] dp = new Boolean[1 << maxChoosableInteger];

        return canIWin(0, maxChoosableInteger, desiredTotal, dp);
    }

    private static boolean canIWin(int flag, int maxChoosableInteger, int total, Boolean[] dp) {
        if (total <= 0) {
            return false;
        }
        //dp代表已经使用了哪个数字情况下是否能赢
        if (dp[flag] == null) {
            dp[flag] = false;
            int comp = 1;
            for (int i = 1; i <= maxChoosableInteger; i++) {
                int used = flag | comp;
                //如果,我能用这个数,且用了这个数对方赢不了
                if (used != flag && !canIWin(used, maxChoosableInteger, total - i, dp)) {
                    dp[flag] = true;
                    break;
                }
                comp <<= 1;
            }
        }
        return dp[flag];
    }
}
