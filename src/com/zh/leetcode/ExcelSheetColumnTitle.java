package com.zh.leetcode;

//168. Excel表列名称
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        int offset = 65 - 1;

        if (columnNumber <= 26) {
            return String.valueOf((char) (columnNumber + offset));
        } else {
            if(columnNumber % 26==0)return  convertToTitle(columnNumber/26-1)+String.valueOf((char) (26 + offset));
            return  convertToTitle(columnNumber/26)+String.valueOf((char) (columnNumber % 26 + offset));
        }
    }

}
