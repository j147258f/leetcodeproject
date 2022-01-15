package com.zh.leetcode;

//42. 接雨水
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int i = t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(i);
    }

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[height.length-1]= height[height.length-1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return result;
    }

    //双指针解法
    public int trap_double_point(int[] height) {
        int result = 0;
        int left = 0;
        int right = left + 1;
        while (right < height.length) {
            if (height[right] >= height[left]) {
                int max = height[left];
                int c = 0;
                for (int i = left; i < right; i++) {
                    c = c + max - height[i];
                }
                result = result + c;
                left = right;
                right = right + 1;
            } else {
                right++;
                if (right == height.length) {
                    right--;
                    int endLeft = left;
                    left = right-1;
                    while (right >= endLeft) {
                        if (height[left] >= height[right]) {
                            int max = height[right];
                            int c = 0;
                            for (int i = right; i > left; i--) {
                                c = c + max - height[i];
                            }
                            result = result + c;
                            right = left;
                            left = right-1;
                        } else {
                            left--;
                        }
                    }
                }
            }
        }

        return result;
    }
}
