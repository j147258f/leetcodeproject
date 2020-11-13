package com.zh.leetcode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) return left;
        return root;
    }

    //还是击败5%
    public TreeNode lowestCommonAncestor_string(TreeNode root, TreeNode p, TreeNode q) {
        char[] pPath = find_path(root, p, "3").toCharArray();
        char[] qPath = find_path(root, q, "3").toCharArray();
        int i = 0;
        while (i < pPath.length && i < qPath.length) {
            if (pPath[i] != qPath[i]) {
                return root;
            }
            if ('3' == pPath[i]) {

            } else if ('1' == pPath[i]) {
                root = root.right;
            } else {
                root = root.left;
            }
            i++;
        }
        return root;
    }

    //0 left 1 right
    private String find_path(TreeNode node, TreeNode p, String path) {
        if (node == null) return "";
        if (node == p) return path;
        String s = find_path(node.left, p, path + "0");
        if (s.length() != 0) return s;
        else return find_path(node.right, p, path + "1");
    }

    //击败5%  最起码做出来了
    public TreeNode lowestCommonAncestor_slow(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root.left;
        TreeNode pre = root;
        while (true) {
            boolean findP = find_slow(result, p);
            boolean findQ = find_slow(result, q);
            if (findP && findQ) {
                pre = result;
                result = result.left;
            } else if (findQ || findP) {
                return pre;
            } else {
                result = pre.right;
            }
        }
    }

    public boolean find_slow(TreeNode node, TreeNode p) {
        if (node == null) return false;
        if (node == p) return true;
        if (find_slow(node.left, p)) return true;
        else return find_slow(node.right, p);
    }
}
