package com.zh.leetcode;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class KthSmallestElementinaBST {
    int index = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        r(root, k);
        return result;
    }

    public void r(TreeNode root, int k) {
        if (root == null) return;
        r(root.left, k);
        index++;
        if (index == k) {
            result = root.val;
            return;
        }
        r(root.right, k);
    }
}
