package com.zh.leetcode.foroffer;

import com.zh.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class o37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "[]";

        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<String> sb = new LinkedList();

        list.add(root);
        sb.add(String.valueOf(root.val));
        while (!list.isEmpty()) {
            TreeNode temp = list.pollFirst();

            if (temp.left == null) {
                sb.add("null");
            } else {
                sb.add(String.valueOf(temp.left.val));
                list.add(temp.left);
            }

            if (temp.right == null) {
                sb.add("null");
            } else {
                sb.add(String.valueOf(temp.right.val));
                list.add(temp.right);
            }
        }
        while (sb.peekLast().equals("null")) {
            sb.removeLast();
        }

        return "["+String.join(",", sb)+"]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if(data.length()==0)return null;
        String[] datas = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < datas.length; i++) {
            TreeNode temp = list.pollFirst();
            if (!"null".equals(datas[i])) {
                temp.left = new TreeNode(Integer.parseInt(datas[i]));
                list.add(temp.left);
            }
            i++;
            if (i == datas.length) break;
            if (!"null".equals(datas[i])) {
                temp.right = new TreeNode(Integer.parseInt(datas[i]));
                list.add(temp.right);
            }
        }

        return root;
    }
}
