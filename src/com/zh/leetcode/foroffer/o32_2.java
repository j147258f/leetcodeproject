package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class o32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        result.add(Arrays.asList(root.val));
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        while (!l.isEmpty()) {
            LinkedList<TreeNode> l2 = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            while (!l.isEmpty()) {
                TreeNode n = l.pollFirst();
                if (n.left != null) {
                    temp.add(n.left.val);
                    l2.add(n.left);
                }
                if (n.right != null) {
                    temp.add(n.right.val);
                    l2.add(n.right);
                }
            }
            if (!temp.isEmpty()) result.add(temp);
            l = l2;
        }
        return result;
    }
}
