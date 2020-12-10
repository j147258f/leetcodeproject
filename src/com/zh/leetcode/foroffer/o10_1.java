package com.zh.leetcode.foroffer;

public class o10_1 {
    int[] nums = new int[100];

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a,b;

        if(nums[n-1]!=0){
            a = nums[n-1]%1000000007;
        }else{
            a = fib(n-1);
            nums[n-1]=a;
        }


        if(nums[n-2]!=0){
            b = nums[n-2]%1000000007;
        }else{
            b = fib(n-2);
            nums[n-2]=b;
        }
        return (a + b)%1000000007;
    }
}
