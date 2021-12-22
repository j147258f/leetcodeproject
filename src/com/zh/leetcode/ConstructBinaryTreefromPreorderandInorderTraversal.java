package com.zh.leetcode;

//105. 从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args){
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        c.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndex(inorder, 0, preorder.length - 1, root.val);
        root.left = getNode(1,   index, 0, index - 1);
        root.right = getNode(1 + index , preorder.length - 1, index + 1, preorder.length - 1);
        return root;
    }

    public TreeNode getNode(int pL, int pR, int iL, int iR) {
        if (pR < pL) return null;
        TreeNode root = new TreeNode(preorder[pL]);
        if (pL == pR) return root;
        //找到root 在 中序遍历中的位置
        int index = findIndex(inorder, iL, iR, root.val);
        //中序遍历左节点的长度
        int lengthOfOL = index - iL;


        int pRIndex = findIndex(inorder, iL, iR, root.val);
        root.left = getNode(pL + 1, pL + lengthOfOL, iL, index - 1);
        root.right = getNode(pL + 1 + lengthOfOL, pR, index + 1, iR);
        return root;
    }

    private int findIndex(int[] nums, int pL, int pR, int target) {
        for (int i = pL; i <= pR; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //-1: 中序遍历num在num2之前
    //1: 中序遍历num在num2之后
    private int isAfter(int[] inorder, int num, int num2) {
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == num) {
                index1 = i;
            }
            if (inorder[i] == num2) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                break;
            }
        }
        if (index1 == index2) return 0;
        if (index1 < index2) return -1;
        return 1;

    }
}
