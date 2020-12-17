package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class o32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        result.add(Arrays.asList(root.val));
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        int h = 1;
        while (!l.isEmpty()) {
            LinkedList<TreeNode> l2 = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            while (!l.isEmpty()) {
                TreeNode n;
                n = l.pollLast();

                if (h == -1) {
                    if (n.left != null) {
                        temp.add(n.left.val);
                        l2.add(n.left);
                    }
                    if (n.right != null) {
                        temp.add(n.right.val);
                        l2.add(n.right);
                    }
                } else {
                    if (n.right != null) {
                        temp.add(n.right.val);
                        l2.add(n.right);
                    }
                    if (n.left != null) {
                        temp.add(n.left.val);
                        l2.add(n.left);
                    }
                }
            }
            h = h * -1;
            if (!temp.isEmpty()) result.add(temp);
            l = l2;
        }
        return result;
    }
}
