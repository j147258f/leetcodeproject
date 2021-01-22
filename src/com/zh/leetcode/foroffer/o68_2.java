package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

public class o68_2 {
    TreeNode p;
    TreeNode q;
    TreeNode result;
    boolean findQ = false;

    public TreeNode lowestCommonAncestor_Solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor_Solution(root.left, p, q);
        TreeNode right = lowestCommonAncestor_Solution(root.right, p, q);
        if (left == null && right == null) return root;
        if (left == null) return right;
        return left;
    }


    //一遍递归 想法有点low
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        findP(root);
        if (result == null) return root;
        return result;
    }

    boolean findP(TreeNode root) {
        //先找p 再找q
        if (root == null) return false;
        if (root.val == p.val) {
            boolean q = findQ(root);
            if (q) {
                findQ = true;
                result = root;
            }
            return true;
        }
        boolean l = findP(root.left);
        if (l) {
            if (findQ) return true;
            boolean q = findQ(root.left);
            if (q) {
                findQ = true;
                result = root.left;
            }
            return true;
        }
        boolean r = findP(root.right);
        if (r) {
            if (findQ) return true;
            boolean q = findQ(root.right);
            if (q) {
                findQ = true;
                result = root.right;
            }
            return true;
        }
        return false;
    }

    boolean findQ(TreeNode root) {
        //先找p 再找q
        if (root == null) return false;
        if (root.val == q.val) return true;
        boolean l = findQ(root.left);
        if (l) {
            return l;
        }
        boolean r = findQ(root.right);
        if (r) {
            return r;
        }
        return false;
    }
}
