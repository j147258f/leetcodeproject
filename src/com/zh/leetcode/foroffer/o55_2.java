package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

public class o55_2 {
    public boolean isBalanced(TreeNode root) {
        r(root,1);
        return result;
    }

    boolean result = true;

    public int r(TreeNode node, int deep) {
        if (node == null) {
            return deep - 1;
        }
        if (!result) return 0;
        int leftDeep = r(node.left, deep + 1);
        int rightDeep = r(node.right, deep + 1);
        if (Math.abs(leftDeep - rightDeep) > 1) {
            result = false;
        }
        return Math.max(leftDeep,rightDeep);
    }
}
