package com.zh.leetcode;

/**
 * 142 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 */
public class LinkedListCycle2 {
    public static void main(String[] args){
        ListNode l  = new ListNode(3);
        ListNode l2  = new ListNode(2);
        ListNode l0  = new ListNode(0);
        ListNode l4  = new ListNode(-4);

        l.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l2;

        detectCycle(l);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                isCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (isCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }

}
