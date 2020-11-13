package com.zh.leetcode;

/**
 * 13. 罗马数字转整数
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int result = 0;

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            switch (cs[i]) {
                case 'I': {
                    result += 1;
                    break;
                }
                case 'V': {
                    result += 5;
                    if (i != 0 && cs[i-1] == 'I') {
                        result = result - 2;
                    }

                    break;
                }
                case 'X': {
                    result += 10;
                    if (i != 0 && cs[i-1] == 'I') {
                        result = result - 2;
                    }
                    break;
                }
                case 'L': {
                    result += 50;
                    if (i != 0 && cs[i-1] == 'X') {
                        result = result - 20;
                    }
                    break;
                }
                case 'C': {
                    result += 100;
                    if (i != 0 && cs[i-1] == 'X') {
                        result = result - 20;
                    }
                    break;
                }
                case 'D': {
                    result += 500;
                    if (i != 0 && cs[i-1] == 'C') {
                        result = result - 200;
                    }
                    break;
                }
                case 'M': {
                    result += 1000;
                    if (i != 0 && cs[i-1] == 'C') {
                        result = result - 200;
                    }
                    break;
                }

            }
        }

        return result;
    }
}
