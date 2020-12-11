package com.zh.leetcode.foroffer;

import com.zh.ListNode;

public class o22 {
    //双指针法
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l1 = head;
        ListNode l2 = head;
        for (int i = 0; i < k; i++) {
            l2 = l2.next;
        }
        while(l2!=null){
            l1= l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}
