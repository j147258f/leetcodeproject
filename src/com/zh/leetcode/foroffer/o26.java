package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

public class o26 {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (b == null) return false;
        return r(a, b, false);
    }

    private void printlnTree(TreeNode a, String parent, String type) {
        if (a != null) {
            System.out.println(a.val + "parent:" + parent + " type:" + type);
            printlnTree(a.left, a.val + "", "left");
            printlnTree(a.right, a.val + "", "right");
        }
    }

    //击败6% 41%
    public boolean r(TreeNode a, TreeNode b, boolean parentEquals) {
        if (b == null) return true;
        else if (a != null) {
            if (a.val == b.val) {
                if (r(a.left, b.left, true) && r(a.right, b.right, true)) return true;
                boolean left = r(a.left, b, false);
                if (left) return true;
                return r(a.right, b, false);
            } else {
                if (parentEquals) {
                    return false;
                } else {
                    boolean left = r(a.left, b, false);
                    if (left) return true;
                    return r(a.right, b, false);
                }
            }
        }
        return false;
    }
}
