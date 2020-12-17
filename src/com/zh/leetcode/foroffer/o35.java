package com.zh.leetcode.foroffer;

import java.util.HashMap;
import java.util.Map;

public class o35 {

    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        n0.next = n1;
        n0.random = null;

        n1.next = n2;
        n1.random = n0;

        n2.next = n3;
        n2.next = n4;

        n3.next = n4;
        n3.next = n2;

        n4.next = null;
        n4.random = n0;

        new o35().copyRandomList(n0);
    }

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node copy = new Node(head.val);
        map.put(copy, copy);
        if (head.next != null) {
            Node nextCopy;
            nextCopy = copyRandomList(head.next);
            copy.next = nextCopy;
        } else {
            copy.next = null;
        }

        if (head.random != null) {
            Node randomCopy;
            if (map.get(head.random) == null) {
                randomCopy = copyRandomList(head.random);
                map.put(head.random, randomCopy);
            } else {
                randomCopy = map.get(head.random);
            }

            copy.random = randomCopy;
        } else {
            copy.random = null;
        }
        return copy;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

