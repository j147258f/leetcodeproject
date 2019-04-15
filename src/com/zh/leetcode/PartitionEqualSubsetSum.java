package com.zh.leetcode;

import java.math.BigDecimal;

public class PartitionEqualSubsetSum {
    public static void main(String[] strs) {
        FindMax();
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;

        //找出数组中某几个数的合是否 == half
        int[][] result = new int[nums.length][half];

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                if (j < nums[i]) {
                    //数字放不进去
                    result[i - 1][j] = result[i][j];
                } else {
//                    if(result[i-1][j] > result[i-1][j-nums[i]]+)
                }

            }
        }


        return false;
    }

    static void FindMax()//动态规划
    {
        int number=4;
        int capacity=8;
        int[] w={1,2,8,4,5,6,7};
        int[] v={1,2,113,4,5,6,7};
        int[][] V = new int[5][9];
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
        int sssd=0;
    }

}
