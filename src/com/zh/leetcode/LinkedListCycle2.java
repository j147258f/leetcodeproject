package com.zh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 142 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 */
public class LinkedListCycle2 {
    public static void main(String[] args) {
        ListNode l = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l2;

        detectCycle(l);
    }

    public static ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> m = new HashMap<>();

        ListNode temp = head;
        while (temp!=null) {
            Integer n = m.get(temp);
            if (n == null) {
                m.put(temp, 0);
            } else {
                if (n == 2) {
                    return temp;
                } else {
                    m.put(temp, ++n);
                }
            }
            temp = temp.next;
        }
        return null;

    }

    public static ListNode detectCycle_t(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }

        }
        if (isCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }

}
