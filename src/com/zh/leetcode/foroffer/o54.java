package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

public class o54 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r1 = new TreeNode(1);
        root.left = r1;
        root.right = r4;

        new o54().kthLargest(root,1);
    }


    public int kthLargest(TreeNode root, int k) {
        r(root, k);
        return res;
    }

    int count = 0;
    int res = 0;

    public void r(TreeNode node, int k) {
        if (node == null) return;
        r(node.right, k);
        count++;
        if (count == k) {
            res = node.val;
            return;
        }
        r(node.left, k);
    }
}
