package com.zh.leetcode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestorofaBinarySearchTree {



    //击败99.89%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode little = p;
        TreeNode big = q;
        if (p.val > q.val) {
            little = q;
            big = p;
        }

        while (true) {
            if (root.val >= little.val && root.val <= big.val) return root;
            if (root.val > big.val) root = root.left;
            else root = root.right;
        }
    }
}
