package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

public class o28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val == r.val) return isSymmetric(l.left, r.right)&&isSymmetric(l.right, r.left);
        return false;
    }
}
