package com.zh.leetcode.foroffer;

public class o44 {
    public static void main(String[] args) {
        new o44().findNthDigit(150);
        new o44().findNthDigit_OOM(150);
    }

    public int findNthDigit(int n) {
        int i = 0;
        int j = 0;
        int base = 1;
        while (i < n) {
            j++;
            base = base * 10;
            i = (j * base - j * i) + i;

        }


        if (i == n) {
            char[] cs = String.valueOf(base).toCharArray();
            return cs[0] - 48;
        } else {
            while (i > n) {
                i = i - j;
                base--;
            }
            if(i==n){
                return String.valueOf(base).toCharArray()[0]-48;
            }else{
                char[] cs = String.valueOf(base).toCharArray();
                return cs[cs.length - 2 - (i - n)] - 48;
            }
        }
        //答案 想法基本一样，人家更巧妙
//        int digit = 1;
//        long start = 1;
//        long count = 9;
//        while (n > count) { // 1.
//            n -= count;
//            digit += 1;
//            start *= 10;
//            count = digit * start * 9;
//        }
//        long num = start + (n - 1) / digit; // 2.
//        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.

    }

    //超时
    public int findNthDigit_slow(int n) {
        int index = 0;
        int i = 1;
        while (true) {
            index += String.valueOf(i).length();
            if (index >= n) break;
            i++;
        }
        char[] cs = String.valueOf(i).toCharArray();

        return cs[cs.length - 1 - (index - n)] - 48;
    }

    //超出内存限制
    public int findNthDigit_OOM(int n) {
        int[] nums = new int[n + 1];
        int index = 0;
        int i = 0;
        while (index < nums.length) {
            char[] chars = String.valueOf(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (index == n + 1) break;
                nums[index] = chars[j] - 48;
                index++;
            }
            i++;
        }
        return nums[n];
    }
}
