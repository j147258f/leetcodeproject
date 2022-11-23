package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        hasPathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public void hasPathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> thisList) {
        if (root == null) return;
        thisList.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(thisList));
            thisList.remove(thisList.size() - 1);
            return;
        }
        targetSum = targetSum - root.val;
        hasPathSum(root.left, targetSum, result, thisList);
        hasPathSum(root.right, targetSum, result, thisList);
        if(thisList.size()!=0)thisList.remove(thisList.size() - 1);
    }
}
