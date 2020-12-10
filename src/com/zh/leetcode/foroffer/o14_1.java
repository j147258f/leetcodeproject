package com.zh.leetcode.foroffer;

public class o14_1 {
    //这递归也太简单了吧？
    public int cuttingRope(int n) {
        if(n==1)return 1;
        if(n==2)return 1;
        if(n==3)return 2;
        if(n==4)return 4;
        if(n==5)return 6;
        return c(n-3)*3;
    }

    public int c (int n){
        if(n==1)return 1;
        if(n==2)return 2;
        if(n==3)return 3;
        if(n==4)return 4;
        return c(n-3)*3;
    }
}