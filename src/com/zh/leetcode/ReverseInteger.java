package com.zh.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int original = x;

        Integer[] stack = new Integer[32];
        int result = 0;
        int i = 0;
        int base = 10;
        while (true) {
            int temp = x % base;
            if (temp == 0 && x / base == 0) break;
            stack[i] = temp * 10 / base;
            x = (x - temp) / 10;
            i++;
        }
        for (int i1 = 0; i1 < stack.length; i1++) {
            if (stack[i1] == null) break;
            if ((result * 10) % 10 != 0) {
                return 0;
            }
             result = result * 10 + stack[i1];
        }
        return result;
    }

}
