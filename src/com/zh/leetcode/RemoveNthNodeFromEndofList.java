package com.zh.leetcode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        String str = "[1]";
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        String s[] = str.split(",");
        ListNode l = new ListNode();
        ListNode t = l;
        for (int i = 0; i < s.length; i++) {
            t.next = new ListNode(Integer.valueOf(s[i]));
            t = t.next;
        }

        new RemoveNthNodeFromEndofList().removeNthFromEnd(l.next, 1);

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = new ListNode();
        l.next = head;
        r(l, -1, n);
        return l.next;
    }

    public int r(ListNode node, int deep, int target) {
        if (node == null) {
            return deep;
        }

        int size = r(node.next, deep + 1, target);
        if (size - deep == target + 1) {
            node.next = node.next.next;
        }
        return size;
    }
}
