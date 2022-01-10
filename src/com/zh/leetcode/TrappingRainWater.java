package com.zh.leetcode;

//42. 接雨水
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int i = t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(i);
    }

    public int trap(int[] height) {
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
