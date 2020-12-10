package com.zh.leetcode.foroffer;

public class o15 {

    public static void main(String[] args) {
        new o15().hammingWeight(-3);
    }

    //我觉得我用转化二进制法，才是符合这个题本意的
    public int hammingWeight(int n) {
        System.out.println(n);
        if (n >= 0) {
            int result = 0;
            while (n != 0) {
                int t = n % 2;
                if (t == 1) result++;
                n = n / 2;
            }
            return result;
        } else {
            int[] nums = new int[32];
            n = n * -1;
            int index = 0;
            while (n != 0) {
                int t = n % 2;
                nums[index] = t;
                index++;
                n = n / 2;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) nums[i] = 0;
                else nums[i] = 1;
            }
            plusOne(nums,0);
            int result  = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==1)result++;
            }
            return result;
        }
    }

    private void plusOne(int[] nums, int index) {
        if(index==nums.length-1)return;
        if (nums[index] == 0) nums[index] = 1;
        else {
            nums[index]=0;
            plusOne(nums,index+1);
        }
    }
}
