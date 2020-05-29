package com.zh.leetcode;

/**
 * 没难度，不多说
 */
public class RotateList {
    public static void main(String[] str) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 3; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        printList(head);

        printList(rotateRight(head, 2));
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val);
            System.out.print(",");
            temp = temp.next;

        }
        System.out.println(temp.val);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = getListSize(head);
        int actuallyMove = k % size;
        if (actuallyMove == 0) {
            return head;
        }
        ListNode temp = head;
        ListNode beforeTemp = head;
        for (int i = 0; i < size - actuallyMove; i++) {
            beforeTemp = temp;
            temp = temp.next;
        }
        beforeTemp.next = null;
        ListNode newHead = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    private static int getListSize(ListNode head) {
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
}
class ListNode{
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}


