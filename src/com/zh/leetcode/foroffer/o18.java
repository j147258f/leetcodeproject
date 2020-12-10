package com.zh.leetcode.foroffer;

import com.zh.ListNode;

public class o18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode head_ = new ListNode(0);
        head_.next = head;

        ListNode temp = head;
        ListNode pre = head_;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
                break;
            } else {
                pre = temp;
                temp = temp.next;
            }
        }
        return head_.next;
    }
}
