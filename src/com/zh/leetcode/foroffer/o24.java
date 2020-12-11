package com.zh.leetcode.foroffer;

import com.zh.ListNode;

public class o24 {
    public ListNode reverseList(ListNode head) {
        return null;
    }

    public ListNode loop(ListNode head) {
        if (head.next == null) return head;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return current;
    }

    public ListNode r(ListNode node, ListNode pre) {
        if (node.next == null) {
            node.next = pre;
            return node;
        }
        ListNode next = node.next;
        node.next = pre;
        return r(next, node);
    }
}
