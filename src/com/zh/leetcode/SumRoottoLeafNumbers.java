package com.zh.leetcode;

//129. 求根节点到叶节点数字之和
public class SumRoottoLeafNumbers {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        r(root,0);
        return result;
    }

    public void r(TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.right == null && root.left == null) {
            result += sum;
            return;
        }
        r(root.left,sum);
        r(root.right,sum);
    }

}
