package com.zh.leetcode;

public class LinkedListCycle {
    public static void main(String[] args){
        LinkedListCycle l = new LinkedListCycle();

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
