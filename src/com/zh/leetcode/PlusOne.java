package com.zh.leetcode;

/**
 * 66
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int first = digits[0];
        plusOne(digits,digits.length-1);
        int first_t = digits[0];
        if(first!=first_t&&first_t==0){
            int[] n = new int[digits.length+1];
            System.arraycopy(digits,0,n,0,digits.length);
            n[0]=1;
            digits = n;
        }

        return digits;
    }

    private void plusOne(int[] nums,int  right){
        if(right<0)return;
        int temp = nums[right] + 1;
        if(temp==10){
            nums[right] = 0;
            plusOne(nums,right-1);
        }else{
            nums[right] = temp;
        }
    }
}
