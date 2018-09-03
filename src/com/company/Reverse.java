package com.company;

/**
 * Created by zhanghao on 2018/5/22.
 */
public class Reverse {
    public static void main(String[] args){
        System.out.println(-2>>1);
        System.out.println(reverse(1534236469));
    }

    public static int reverse( int num) {
        long l=num;
        long max=Integer.MAX_VALUE;
        long min=Integer.MIN_VALUE;
        long answer=0;
        while (num!=0){
            answer=answer*10+(num%10);
            num=num/10;
        }
        if(answer<min || answer>max)
        {
            answer=0;
        }
        return (int)answer;
    }
}
/*   感觉好像有更优雅的解决方案
 long re=0;
 boolean negative = false;
 if(x < 0) {
 x = Math.abs(x);
 negative = true;
 }
 while(x > 0) {
 re *= 10;
 re += x % 10;
 x /= 10;
 }
 if(re > Integer.MAX_VALUE) {
 re = 0;
 }
 return negative ? -(int)re : (int)re;
 */
