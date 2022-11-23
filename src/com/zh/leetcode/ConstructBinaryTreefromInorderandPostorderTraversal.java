package com.zh.leetcode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreefromInorderandPostorderTraversal c = new ConstructBinaryTreefromInorderandPostorderTraversal();
        c.buildTree(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3});
    }

    int[] inorder;
    int[] postorder;
    int lastNodeIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.lastNodeIndex = postorder.length - 1;
        TreeNode root = new TreeNode(postorder[lastNodeIndex]);
        lastNodeIndex--;
        int index = findIndex(inorder, 0, inorder.length - 1, root.val);
        root.right = buildTree(index + 1, inorder.length - 1);
        root.left = buildTree(0, index - 1);
        return root;
    }

    public TreeNode buildTree(int leftI, int rightI) {
        if (leftI > rightI) return null;
        if (leftI == rightI) {
            lastNodeIndex--;
            return new TreeNode(inorder[leftI]);
        }
        TreeNode root = new TreeNode(postorder[lastNodeIndex]);
        lastNodeIndex--;
        int index = findIndex(inorder, leftI, rightI, root.val);
        root.right = buildTree(index + 1, rightI);
        root.left = buildTree(leftI, index - 1);
        return root;
    }

    private int findIndex(int[] nums, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}
