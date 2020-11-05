package com.zh.leetcode;

/**
 * 124 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
//        String str = "[-10,9,20,null,null,15,7]";
        String str = "[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]";
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        String[] s = str.split(",");
        TreeNode root = createTree(s, 0);

        BinaryTreeMaximumPathSum v = new BinaryTreeMaximumPathSum();
        v.m(root);
        System.out.println(v.max);
    }

    int max = Integer.MIN_VALUE;

    public int m(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(m(root.left), 0);
        int r = Math.max(m(root.right), 0);
        int value = Math.max(root.val + l, root.val + r);

        int price = l+r+root.val;

        if (price > max) {
            max = price;
        }

        return value;
    }

    public static TreeNode createTree(String[] s, int index) {
        if (index >= s.length) {
            return null;
        }

        if ("null".equals(s[index])) return null;

        TreeNode root = new TreeNode(Integer.parseInt(s[index]));

        int l = 2 * index + 1;
        int r = 2 * index + 2;
        if (l >= s.length) {
            root.left = null;
        } else {
            root.left = createTree(s, l);
        }

        if (r >= s.length) {
            root.right = null;
        } else {
            root.right = createTree(s, r);
        }
        return root;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
