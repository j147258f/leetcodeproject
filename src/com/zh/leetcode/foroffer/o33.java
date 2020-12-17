package com.zh.leetcode.foroffer;

public class o33 {
    public static void main(String[] agrs){
        new o33().verifyPostorder(new int[]{1,2,5,10,6,9,4,3});
    }

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder,0,postorder.length-1);
    }

    public boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) return true;

        int root = postorder[right];

        int index = left;

        while (postorder[index] < root) {
            index++;
        }

        for (int i = index; i < right; i++) {
            if (postorder[i] < root) return false;
        }

        return verifyPostorder(postorder,left,index-1)&&verifyPostorder(postorder,index,right-1);
    }
}
