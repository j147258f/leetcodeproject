package com.zh.leetcode.foroffer;

import com.zh.ListNode;

public class o25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    public ListNode loop(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode _result = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                result.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        return _result.next;
    }

    public ListNode r(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = r(l1.next,l2);
            return l1;
        } else {
            l2.next = r(l1,l2.next);
            return l2;
        }
    }
}
