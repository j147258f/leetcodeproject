package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class o34 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        r(root, sum, new LinkedList<>());
        return result;
    }

    public void r(TreeNode node, int sum, LinkedList<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            this.result.add(new ArrayList<>(list));
        }
        r(node.left, sum - node.val, list);
        r(node.right, sum - node.val, list);
        list.removeLast();
    }
}
