package com.zh.leetcode;

/**
 * 160. 相交链表
 */
public class IntersectionofTwoLinkedLists {

    public static void main(String[] args){

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;

        int aStep = 1;
        ListNode lastA = headA;
        while (lastA.next != null) {
            lastA = lastA.next;
            aStep++;
        }

        int bStep = 1;
        ListNode lastB = headB;
        while (lastB.next != null) {
            lastB = lastB.next;
            bStep++;
        }

        if (lastA != lastB) return null;

        if (aStep > bStep) {
            int a = aStep - bStep;
            for (int i = 0; i < a; i++) {
                headA = headA.next;
            }
        } else {
            int b = bStep - aStep;
            for (int i = 0; i < b; i++) {
                headB = headB.next;
            }
        }

        while (headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
