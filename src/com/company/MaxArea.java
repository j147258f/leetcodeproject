package com.company;

public class MaxArea {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int startIndex = 0;
        int endIndex = height.length - 1;
        while (true) {
            if (startIndex == endIndex) {
                break;
            }
            int area = 0;
            int minNum = -1;
            if (height[startIndex] < height[endIndex]) {
                area = height[startIndex] * (endIndex - startIndex);
                startIndex++;
            } else {
                area = height[endIndex] * (endIndex - startIndex);
                endIndex--;
            }
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }
}
