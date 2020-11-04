package com.zh.leetcode;

/**
 * 121 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class BestTimetoBuyandSellStock2 {

    public static void main(String[] args) {
        int a = new BestTimetoBuyandSellStock2().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(a);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int a = prices[i] - min;
            if (a > 0) {
                result += a;
                min = prices[i];
            } else if (prices[i] < min) min = prices[i];
        }
        return result;
    }
}
