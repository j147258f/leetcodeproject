package com.company;

/**
 * Created by zhanghao on 2018/6/9.
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revert_x=0;
        int copy_x=x;
        while (copy_x>0){
            revert_x=revert_x*10+ copy_x%10;
            copy_x=copy_x/10;
        }
        if(revert_x==x)return true;
        else return false;
    }
}
