package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class o32_1 {
    List<Integer> result = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        result.add(root.val);
        r(Arrays.asList(root));
        int[] r = new int[result.size()];
        int i = 0;
        for (Integer integer : result) {
            r[i] = integer;
            i++;
        }
        return r;
    }

    public void r(List<TreeNode> parents) {
        List<TreeNode> next = new ArrayList<>();

        for (TreeNode parent : parents) {
            if (parent.left != null) {
                result.add(parent.left.val);
                next.add(parent.left);
            }
            if (parent.right != null) {
                result.add(parent.right.val);
                next.add(parent.right);
            }
        }
        if(next.isEmpty())return;
        r(next);
    }
}
