package com.zh.leetcode.foroffer;

public class o46 {
    public static void main(String[] args) {
        new o46().translateNum(419605557);
    }

    //动态规划 优化空间
    public int translateNum(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int a = 1;
        int b;
        if (cs.length < 2) return 1;
        int temp = (cs[0] - 48) * 10 + (cs[1] - 48);
        if (temp >= 0 && temp <= 25) b = 2;
        else b = 1;
        int c = b;
        for (int i = 3; i < cs.length + 1; i++) {
            if (cs[i - 2] - 48 == 0) {
                c = b;
            } else {
                temp = (cs[i - 2] - 48) * 10 + (cs[i - 1] - 48);
                if (temp >= 0 && temp <= 25) c = a + b;
                else c = b;
            }
            a = b;
            b = c;
        }
        return c;
    }

    //动态规划
    public int translateNum_dp(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int[] dp = new int[cs.length + 1];
        dp[1] = 1;
        if (cs.length < 2) return 1;
        int temp = (cs[0] - 48) * 10 + (cs[1] - 48);
        if (temp >= 0 && temp <= 25) dp[2] = 2;
        else dp[2] = 1;

        for (int i = 3; i < dp.length; i++) {
            if (cs[i - 2] - 48 == 0) dp[i] = dp[i - 1];
            else {
                temp = (cs[i - 2] - 48) * 10 + (cs[i - 1] - 48);
                if (temp >= 0 && temp <= 25) dp[i] = dp[i - 1] + dp[i - 2];
                else dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    //递归解法
    public int translateNum_r(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int length = cs.length;
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cs[i] - 48;
        }
        r(nums, 0, 1);
        r(nums, 0, 2);

        return result;
    }

    int result = 0;

    public void r(int[] nums, int index, int step) {
        if (step == 1) {
            if (index == nums.length - 1) {
                result++;
                return;
            } else if (index >= nums.length - 1) return;
            r(nums, index + 1, 1);
            r(nums, index + 1, 2);
        } else {
            if (index + 1 == nums.length - 1) {
                if (nums[index] == 0) return;
                int temp = nums[index] * 10 + nums[index + 1];
                if (temp >= 0 && temp <= 25) {
                    result++;
                    return;
                } else return;
            } else if (index + 1 >= nums.length - 1) return;
            if (nums[index] == 0) return;
            int temp = nums[index] * 10 + nums[index + 1];
            if (temp >= 0 && temp <= 25) {
                r(nums, index + 2, 1);
                r(nums, index + 2, 2);
            }
        }
    }
}
