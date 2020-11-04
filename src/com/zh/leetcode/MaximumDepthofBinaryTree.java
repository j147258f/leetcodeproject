package com.zh.leetcode;

/**
 * 104 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root9 = new TreeNode(9);
        TreeNode root20 = new TreeNode(20);
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);

        root.left = root9;
        root.right = root20;
        root20.left = root15;
        root20.right = root7;


        new MaximumDepthofBinaryTree().find(root, 1);
    }

    public int maxDepth(TreeNode root) {
        return find(root, 1);
    }

    public int find(TreeNode t, int deep) {
        if (t == null) return deep;
        deep = deep + 1;
        return Math.max(find(t.left, deep), find(t.right, deep));
    }
}
