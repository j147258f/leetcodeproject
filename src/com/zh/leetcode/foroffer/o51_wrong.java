package com.zh.leetcode.foroffer;

//题目理解错了。。。。我以为是数组可以组合
public class o51_wrong {
    public static void main(String[] args) {
        new o51_wrong().reversePairs(new int[]{7, 5, 6, 4});
    }

    int result = 0;
    int[] nums;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        r(0, nums.length - 2, nums.length - 1);
        return result;
    }

    //rightEnd(incloud)
    public void r(int leftIndex, int leftEnd, int rightEnd) {
        if (leftIndex > leftEnd) {
            return;
        }
        int rightIndex = leftEnd + 1;
        int temp = rightEnd;
        while (temp >= rightIndex) {
            if (compare(leftIndex, leftEnd, rightIndex, temp)) {
                System.out.println(buildNum(leftIndex, leftEnd)+"______"+buildNum(rightIndex,temp));

                result++;
            }
            temp--;
        }
        r(leftIndex, leftEnd - 1, rightEnd);
        r(leftIndex + 1, leftEnd, rightEnd);
    }

    boolean compare(int ls, int le, int rs, int re) {
        int l = buildNum(ls, le);
        int r = buildNum(rs, re);

        if (l > r) return true;
        return false;
    }

    int buildNum(int s, int e) {
        int result = 0;
        while (s <= e) {
            result = result * 10 + nums[s];
            s++;
        }
        return result;
    }
}
