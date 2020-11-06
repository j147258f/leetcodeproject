package com.zh.leetcode;

/**
 * 206. 反转链表
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        String str = "[4,3,2,1]";
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        String s[] = str.split(",");
        ListNode l = new ListNode();
        ListNode t = l;
        for (int i = 0; i < s.length; i++) {
            t.next = new ListNode(Integer.valueOf(s[i]));
            t = t.next;
        }

        new ReverseLinkedList().reverseList_loop(l.next);
    }

    public ListNode reverseList(ListNode head) {
        return null;
    }

    public ListNode reverseList_loop(ListNode head) {
        ListNode c = head;
        ListNode pre = null;
        while (c != null) {
            ListNode t = c.next;
            c.next = pre;
            pre = c;
            c = t;
        }
        return pre;

    }

    public ListNode reverseList_recursively(ListNode head, ListNode pre) {
        if (head == null) return head;
        if (head.next == null) {
            head.next = pre;
            return head;
        }
        ListNode t = head.next;
        head.next = pre;
        return reverseList_recursively(t, head);
    }
}
