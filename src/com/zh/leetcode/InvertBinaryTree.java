package com.zh.leetcode;

//226. 翻转二叉树
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        reveres(root);
        return root;
    }

    private void reveres(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reveres(root.left);
        reveres(root.right);
    }
}
