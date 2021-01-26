package com.zh.leetcode.foroffer;

public class o33 {
    public static void main(String[] agrs) {
        new o33().verifyPostorder(new int[]{1,2,5,10,6,9,4,3});
    }

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return verifyPostorder(0, postorder.length - 1);
    }


    int[] postorder;

    public boolean verifyPostorder(int left, int right) {
        if (left >= right) return true;

        int root = postorder[right];
        int mid = left;
        while (postorder[mid] < root) {
            mid++;
        }
        for (int i = mid; i < right; i++) {
            if (postorder[i] < root) return false;
        }
        return verifyPostorder(left, mid - 1) && verifyPostorder(mid, right - 1);
    }
}
