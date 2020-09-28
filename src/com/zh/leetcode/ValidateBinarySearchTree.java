package com.zh.leetcode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateBinarySearchTree {
    Integer lastN = null;
//    public boolean isValidBST(TreeNode root) {
//        recursive(root);
//    }

    public static void main(String[] arg) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
//        [-2147483648,null,2147483647]
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root4 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        TreeNode root6 = new TreeNode(6);
        root.left = root1;
        root.right = root4;
        root4.left = root3;
        root4.right = root6;
        System.out.println(v.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        try {
            recursive(root);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        recursive(node.left);
        if (lastN != null && lastN >= node.val) {
            throw new RuntimeException("asdf");
        }
        lastN = node.val;
        recursive(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
