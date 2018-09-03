package com.zh.leetcode;

public class IntToRoman {

    public static void main(String[] str) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(19));
    }

    public String intToRoman(int num) {
        return handleNum(num);
    }

    static int[] baseNum = {1000, 500, 100, 50, 10, 5, 1};
    static Character[] baseRomanCharacter = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    /*
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    */
    private String handleNum(int num) {
        int lastNum = num;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseNum.length; i++) {
            lastNum = generateToRoman(lastNum, i, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private int generateToRoman(int num, int index, StringBuilder stringBuilder) {
        int remainder = num % baseNum[index];
        int quotient = num / baseNum[index];
        if (quotient == 4 && index != 0) {

        } else {
            for (int i = 0; i < quotient; i++) {
                stringBuilder.append(baseRomanCharacter[index]);
            }
        }
        return remainder;
    }
//这么写太繁琐了，等我研究一下算法那书回来弄

//    int charIndex = stringBuilder.length() - 1;
//            if (charIndex < 0) {
//        stringBuilder.append(baseRomanCharacter[index]);
//        stringBuilder.append(baseRomanCharacter[index - 1]);
//    } else {
//        Character lastChar = stringBuilder.charAt(stringBuilder.length() - 1);
//        Character lastLastChar = stringBuilder.length() >= 2 ? stringBuilder.charAt(stringBuilder.length() - 2) : 'I';
//        if (lastChar == 'V' || lastChar == 'L' || lastChar == 'D') {
//            if (lastLastChar == 'I' || lastLastChar == 'X' || lastLastChar == 'C') {
//                stringBuilder.deleteCharAt(charIndex);
//                stringBuilder.append(baseRomanCharacter[index]);
//                stringBuilder.append(baseRomanCharacter[index - 2]);
//            } else {
//                stringBuilder.append(baseRomanCharacter[index]);
//                stringBuilder.append(baseRomanCharacter[index - 1]);
//
//            }
//        } else {
//            stringBuilder.append(baseRomanCharacter[index]);
//            stringBuilder.append(baseRomanCharacter[index - 1]);
//        }
//    }
}
