package com.zh.leetcode;

import java.util.Arrays;

/**
 * Created by zhanghao on 2019/2/25.
 * 想到两种解：
 * 一、创建映射表 如：2*3=6 2+3=5。在两数相乘的时候根据查找映射表得出结果
 * 二、将字符串转换为数组
 *
 * 后记：通过了，但是还有很多可以优化的地方，计算效率看上去还行，就是空间复杂度有点高。尝试有效利用int的长度（目前只用了0-9）可以有效的减少空间复杂度
 */
public class MultiplyStrings {
    public static void main(String[] str) {
        System.out.println(new ZhInteger("123").multiply(new ZhInteger("456")));
        System.out.println(123 * 456);
    }

    public static String multiply(String num1, String num2) {
        return String.valueOf(new ZhInteger(num1).multiply(new ZhInteger(num2)));
    }

    static class ZhInteger {
        public int[] numArray;

        public ZhInteger(String str) {
            int size = str.trim().length();
            this.numArray = new int[size];
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                numArray[i] = chars[i] - '0';
            }
        }

        public ZhInteger(int[] ints) {
            this.numArray = ints;
        }

        public ZhInteger multiply(ZhInteger num2) {
            int[] resultArray = new int[numArray.length + num2.numArray.length + 1];
            int[] inputArray = num2.numArray;
            int indexI = 0;
            int indexJ = 0;
            for (int i = numArray.length - 1; i >= 0; i--) {
                indexI = numArray.length - 1 - i;
                for (int j = inputArray.length - 1; j >= 0; j--) {
                    indexJ = inputArray.length - 1 - j;
                    int product = numArray[i] * inputArray[j];
                    intArrayAddInt(product, resultArray, indexI + indexJ);
                }
            }
            return new ZhInteger(resultArray);
        }

        private void intArrayAddInt(int num, int[] result, int index) {
            try {
                int lastIndex = result.length - 1;
                if (num > 9) {
                    int tempNum1 = num % 10;
                    int tempNum2 = num / 10;
                    int temp = result[lastIndex - index];
                    int rTemp = temp + tempNum1;
                    if (rTemp > 9) {
                        result[lastIndex - index] = rTemp - 10;
                        intArrayAddInt(tempNum2 + 1, result, index + 1);
                    } else {
                        result[lastIndex - index] = rTemp;
                        intArrayAddInt(tempNum2, result, index + 1);
                    }
                } else {
                    int temp = result[lastIndex - index];
                    int rTemp = temp + num;
                    if (rTemp > 9) {
                        result[lastIndex - index] = rTemp - 10;
                        intArrayAddInt(1, result, index + 1);
                    } else {
                        result[lastIndex - index] = rTemp;
                    }
                }
            } catch (Exception e) {
                throw e;
            }

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            boolean firstZero = true;
            for (int i : numArray) {
                if (firstZero && i == 0) {
                    continue;
                }
                if (i != 0) {
                    firstZero = false;
                }
                sb.append(i);
            }
            if(sb.length()==0)return "0";
            return sb.toString();
        }
    }
}
