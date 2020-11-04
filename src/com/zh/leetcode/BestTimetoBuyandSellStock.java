package com.zh.leetcode;

/**
 * 121 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        new BestTimetoBuyandSellStock().maxProfit(new int[]{7, 2, 1, 4});
    }

    public int maxProfit(int[] prices) {
        if(prices.length <2) return 0;
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int a = prices[i] - min;
            if (a > result) {
                result = a;
            }
            if(prices[i]<min) min = prices[i];
        }
        return result;
    }

    //n2 复杂度
    public int maxProfitSlow(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int a = prices[j] - prices[i];
                if (a > 0 && result < a) {
                    result = a;
                }
            }
        }

        return result;
    }
}
