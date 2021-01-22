package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

public class o68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode little = p;
        TreeNode bigger = q;
        if (p.val > q.val) {
            little = q;
            bigger = p;
        }

        if (bigger.val < root.val) {
            return lowestCommonAncestor(root.left, little, bigger);
        } else if (little.val > root.val) {
            return lowestCommonAncestor(root.right, little, bigger);
        } else return root;
    }
}
