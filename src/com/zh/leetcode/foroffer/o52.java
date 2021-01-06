package com.zh.leetcode.foroffer;

import com.zh.ListNode;

public class o52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aT = headA;
        ListNode bT = headB;

        while (aT != bT) {
            aT = aT == null ? headB : aT.next;
            bT = bT == null ? headA : bT.next;
        }
        return aT;
    }
}
