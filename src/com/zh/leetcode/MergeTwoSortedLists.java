package com.zh.leetcode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l14 = new ListNode(4);
        l1.next = l12;
        l12.next = l14;


        ListNode l2 = new ListNode(1);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);
        l2.next = l23;
        l23.next = l24;


        ListNode n = m.mergeTwoLists(l1, l2);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    ListNode t = new ListNode();

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l2.next, l1);
        return l2;
    }
}