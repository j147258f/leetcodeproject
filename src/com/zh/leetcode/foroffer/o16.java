package com.zh.leetcode.foroffer;

public class o16 {
    public static void main(String[] args) {
        new o16().myPow(0.00001d, 2147483647);
    }

    //超出时间限制 可以使用2*2*2*2 = 4*4 优化
    public double myPow(double x, int n) {
        if (n == 0 || x == 1d) return 1d;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            return -1;
        }

        if (n == 1) return x;
        if (n == -1) return 1 / x;

        long nn = n;
        if (x < 1d && nn < 0) {
            x = 1 / x;
            nn = nn * -1;
        }

        boolean postive = true;
        if (nn < 0) {
            nn = nn * -1;
            postive = false;
        }
        double result = x;
        for (int i = 1; i < nn / 2; i++) {
            result = result * x;
            if (result == Double.NEGATIVE_INFINITY) {
                return 0d;
            }
        }
        result = result * result;
        if (x < 1 || postive) {
        } else if (result == Double.POSITIVE_INFINITY) {
            return 0d;
        }
        if (nn % 2 == 1) result = result * x;
        if (!postive) result = 1 / result;
        return result;
    }

}
