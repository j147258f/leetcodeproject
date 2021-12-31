package com.zh.leetcode;

import java.util.LinkedList;

/**
 * Created by zhanghao on 2019/3/28.
 */
public class UniquePaths {

    public static void main(String[] args){
        UniquePaths u = new UniquePaths();
        u.uniquePaths(3,7);
    }

    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        cal(m,n);
        return dp[m-1][n-1];
    }

    int cal(int m,int n){
        if(dp[m-1][n-1]!=0)return dp[m-1][n-1];
        dp[m-1][n-1] = cal(m-1,n)+cal(m,n-1);
        return dp[m-1][n-1];
    }
}
