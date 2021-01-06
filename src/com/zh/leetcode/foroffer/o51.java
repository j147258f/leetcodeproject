package com.zh.leetcode.foroffer;

public class o51 {
    public static void main(String[] args) {
        new o51().reversePairs(new int[]{12, 2, 1, 17, 19, 10, 5, 23});
    }

    //参考了答案，归并排序不影响结果没想到
    public int reversePairs(int[] nums) {
        this.nums = nums;
        this.temp = new int[nums.length];
        int i = reversePairs(0, nums.length - 1);
        return i;
    }

    public int reversePairs(int left, int right) {
        if (left >= right) return 0;
        int mid = (right + left) >>> 1;
        int lc = reversePairs(left, mid);
        int rc = reversePairs(mid + 1, right);
        return merge(left, mid, mid + 1, right, lc, rc);
    }

    int[] nums;
    int[] temp;

    public int merge(int l1, int r1, int l2, int r2, int lc, int rc) {
        int l_index = l1;
        int r_index = l2;
        int bigger = 0;

        for (int i = 0; i < r2 - l1 + 1; i++) {
            if (l_index > r1) {
                temp[i] = nums[r_index];
                r_index++;
            } else if (r_index > r2) {
                temp[i] = nums[l_index];
                l_index++;
            } else if (nums[l_index] > nums[r_index]) {
                temp[i] = nums[l_index];
                l_index++;
                bigger = bigger + (r2 - r_index + 1);
            } else {
                temp[i] = nums[r_index];
                r_index++;
            }
        }

        int index = 0;
        for (int i = l1; i <= r2; i++) {
            nums[i] = temp[index];
            index++;
        }
        return lc + rc + bigger;
    }
}
