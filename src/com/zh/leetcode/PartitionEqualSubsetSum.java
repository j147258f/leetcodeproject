package com.zh.leetcode;

import java.math.BigDecimal;

public class PartitionEqualSubsetSum {
    public static void main(String[] strs) {
//        FindMax();
        canPartition(new int[]{1, 2, 3, 4, 5, 6, 7});
//        canPartition(new int[]{1,5,11,5});
    }

    //由于全是正整数，所以保证和要小于half；此时每加一个数会逼近half
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;

        //找出数组中某几个数的合是否 == half
        int[][] result = new int[nums.length + 1][half + 1];
        int[] numsClone = new int[nums.length + 1];
        for (int i = 1; i < numsClone.length; i++) {
            numsClone[i] = nums[i - 1];
        }
        //i代表方到第几个数
        for (int i = 1; i <= nums.length; i++) {
            //j代表当前目标和
            for (int j = 1; j <= half; j++) {
                if (j < numsClone[i]) {
                    //数字放不进去
                    result[i][j] = result[i - 1][j];
                } else {
                    //能放进去的时候，判定放和不放哪个的和距离目标数近
//                    int notPut = j - result[i - 1][j];
//                    int put = j - (result[i - 1][j] + numsClone[i]);

                    int notPut = j - result[i - 1][j];
                    int put = j - (result[i - 1][j - numsClone[i]] + numsClone[i]);
                    if (put >= 0 && notPut > put) {
                        result[i][j] = result[i - 1][j - numsClone[i]] + numsClone[i];
                    } else {
                        //放距离目标数最近
                        result[i][j] = result[i - 1][j];
                    }
                }

            }
        }
        if (result[nums.length][half] == half) {
            return true;
        }
        return false;
    }

    static void FindMax()//动态规划
    {
        int number = 7;
        int capacity = 8;
        int[] w = {0, 1, 2, 8, 4, 5, 6, 7};
        int[] v = {0, 1, 100, 113, 4, 5, 80, 7};
        int[][] V = new int[number + 1][capacity + 1];
        int i, j;
        //填表
        for (i = 1; i <= number; i++) {
            for (j = 1; j <= capacity; j++) {
                if (j < w[i])//包装不进
                {
                    V[i][j] = V[i - 1][j];
                } else//能装
                {
                    if (V[i - 1][j] > V[i - 1][j - w[i]] + v[i])//不装价值大
                    {
                        V[i][j] = V[i - 1][j];
                    } else//前i-1个物品的最优解与第i个物品的价值之和更大
                    {
                        V[i][j] = V[i - 1][j - w[i]] + v[i];
                    }
                }
            }
        }
        int sssd = 0;
    }

}
