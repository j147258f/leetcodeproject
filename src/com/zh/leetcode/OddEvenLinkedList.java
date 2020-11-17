package com.zh.leetcode;

/**
 * 328. 奇偶链表
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        String s[] = str.split(",");
        ListNode l = new ListNode();
        ListNode t = l;
        for (int i = 0; i < s.length; i++) {
            t.next = new ListNode(Integer.valueOf(s[i]));
            t = t.next;
        }

        new OddEvenLinkedList().oddEvenList(l.next);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next == null || head.next.next == null) return head;

        ListNode even_first = new ListNode();
        ListNode even = even_first;
        ListNode odd = head;
        while (true) {
            ListNode even_temp = odd.next;
            if (even_temp == null) {
                even.next = null;
                break;
            }

            ListNode odd_temp = odd.next.next;
            if (odd_temp == null) {
                even.next = even_temp;
                break;
            }

            odd.next = odd_temp;
            odd = odd_temp;

            even.next = even_temp;
            even = even_temp;
        }

        odd.next = even_first.next;


        return head;
    }
}
