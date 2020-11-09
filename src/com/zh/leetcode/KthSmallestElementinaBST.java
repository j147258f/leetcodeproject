package com.zh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class KthSmallestElementinaBST {


    public int kthSmallest(TreeNode root, int k) {
        mid2(root, k);
        return res;
    }

    private int deep = 1;
    private int res = 0;

    public void mid2(TreeNode root, int limitDeep) {
        if (root == null) return;
        mid2(root.left,limitDeep);
        if (deep == limitDeep) {
            res = root.val;
            deep++;
            return;
        }
        if (deep > limitDeep) return;
        deep++;
        mid2(root.right,limitDeep);
    }

    List<Integer> list = new ArrayList<>();

    //利用中序遍历得出结果  击败54%
    public void mid(TreeNode root) {
        if (root == null) return;
        mid(root.left);
        list.add(root.val);
        mid(root.right);
    }
}
