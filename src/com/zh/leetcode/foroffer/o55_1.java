package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

public class o55_1 {
    public int maxDepth(TreeNode root) {
        r(root, 1);
        return result;
    }

    int result = 0;

    public void r(TreeNode node, int deep) {
        if (node == null) {
            result = Math.max(deep-1,result);
            return;
        }
        r(node.left, deep + 1);
        r(node.right, deep + 1);
    }
}
