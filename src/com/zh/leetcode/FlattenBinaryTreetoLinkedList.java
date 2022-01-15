package com.zh.leetcode;

//114. 二叉树展开为链表
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        r(root);
    }

    private void r(TreeNode root) {
        if (root == null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        connect(root);
        r(l);
        r(r);
    }

    private TreeNode pre;

    private void connect(TreeNode node) {
        if(pre==null){
            pre = node;
            node.left = null;
            node.right = null;
            return ;
        }
        pre.left = null;
        pre.right = node;
        pre = node;
    }
}
