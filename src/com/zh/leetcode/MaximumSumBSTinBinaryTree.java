package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumBSTinBinaryTree {
    public int maxSumBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        r(root, l);

        int result = 0;
        for (int i = 1; i < l.size(); i++) {

        }
        return 0;
    }

    public void r(TreeNode node, List<Integer> l) {
        if (node == null) return;
        r(node.left, l);
        l.add(node.val);
        r(node.right, l);
    }
}
