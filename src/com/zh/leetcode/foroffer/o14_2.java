package com.zh.leetcode.foroffer;

public class o14_2 {
    public static void main(String[] args) {
        System.out.println(new o14_2().cuttingRope(62));


    }

    public int cuttingRope(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        if (n == 5) return 6;
        long result  = c(n - 3) * 3 ;
        while(result>1000000007){
            result = result%1000000007;
        }
        return  (int)result;
    }

    public long c(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        if (n == 4) return 4;
        return (c(n-3)*3)%1000000007;
    }
}
