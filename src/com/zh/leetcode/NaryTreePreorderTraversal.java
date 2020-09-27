package com.zh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *         1
 *      2  5  3
 * 20  50  30
 * 中序遍历版
 */
public class NaryTreePreorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> l = new ArrayList<>();
        l.add(new Node(2));
        l.add(new Node(5));
        l.add(new Node(3));
        root.children = l;

        List<Node> l2 = new ArrayList<>();
        l2.add(new Node(20));
        l2.add(new Node(50));
        l2.add(new Node(30));
        l.get(0).children = l2;

        NaryTreePreorderTraversal n = new NaryTreePreorderTraversal();
        for (Integer integer : n.preorder(root)) {
            System.out.println(integer);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        recursive(root, result);
        return result;
    }

    void recursive(Node n, List<Integer> result) {
        if (n == null) return;

        if (n.children != null && n.children.size() != 0) {
            int i = 0;
            for (Node child : n.children) {
                if (i == 1) {
                    result.add(n.val);
                }
                recursive(child, result);
                i++;
            }
        }else{
            result.add(n.val);
        }

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}