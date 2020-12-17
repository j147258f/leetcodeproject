package com.zh.leetcode.foroffer;

public class o36 {

    public static void main(String[] args) {
        Node root = new Node(4);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n5 = new Node(5);

        root.left = n2;
        root.right = n5;

        n2.left = n1;
        n2.right = n3;

        Node r = new o36().treeToDoublyList(root);
        int i = 0;
    }

    public Node treeToDoublyList(Node root) {
        if(root == null)return null;
        m(root);
        pre.left = current;
        current.right = pre;
        return pre;

    }

    Node current;
    Node pre;

    public Node m(Node node) {
        if (node == null) return null;
        Node l = m(node.left);
        if (pre == null) {
            pre = node;
        }

        if (current == null) {
            current = node;
        } else {
            current.right = node;
            node.left = current;
            current = node;
        }
        Node temp = node.right;
        Node r = m(temp);
        return temp;
    }


    //遍历两次
//    public Node treeToDoublyList(Node root) {
//        if(root==null)return null;
//        m(root);
//        for (int i = 0; i < l.size(); i++) {
//            if (i + 1 < l.size()) l.get(i).right = l.get(i + 1);
//            if (i != 0) l.get(i).left = l.get(i - 1);
//        }
//        l.get(0).left = l.get(l.size() - 1);
//        l.get(l.size() - 1).right = l.get(0);
//
//        return l.get(0);
//    }
//
//    List<Node> l = new ArrayList<>();
//
//    public void m(Node node) {
//        if (node == null) return;
//        m(node.left);
//        l.add(node);
//        m(node.right);
//
//    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
