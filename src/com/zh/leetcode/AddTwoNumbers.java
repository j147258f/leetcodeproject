package com.zh.leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;

        ListNode node = new ListNode(0);
        ListNode returnresult = node;

        ListNode pre = null;
        int amount = l1.val + l2.val;
        if (amount > 9) {
            node.val = amount - 10;
            ListNode next = new ListNode(1);
            node.next = next;
            pre = node;
            node = next;
        } else {
            node.val = amount;
            ListNode next = new ListNode(0);
            node.next = next;
            pre = node;
            node = next;
        }

        while (l1Next != null || l2Next != null) {
            if (l1Next == null) {
                l1Next = new ListNode(0);
            } else if(l2Next == null){
                l2Next = new ListNode(0);
            }

            amount = l1Next.val + l2Next.val+node.val;
            if (amount > 9) {
                node.val = amount%10;
                ListNode next = new ListNode(amount/10);
                node.next = next;
                pre = node;
                node = next;
            } else {
                node.val = amount;
                ListNode next = new ListNode(0);
                node.next = next;
                pre = node;
                node = next;
            }

            l1Next = l1Next.next;
            l2Next = l2Next.next;
        }

        if(node.val==0){
            pre.next=null;
        }

        return returnresult;
    }
}
