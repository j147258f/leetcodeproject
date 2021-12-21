package com.zh.leetcode.top;

import com.zh.ListNode;

//2. 两数相加
public class AddTwoNumbers {

    //普通迭代解法
    public ListNode addTwoNumbers_s1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode it = result;
        int add = 0;
        while (l1 != null || l2 != null) {
            int val = add;
            add = 0;
            if (l1 != null && l2 != null) {
                val += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            } else {
                val += l2.val;
                l2 = l2.next;
            }
            if (val > 9) {
                val = val - 10;
                add = 1;
            }
            it.next = new ListNode(val);
            it = it.next;
        }
        if (add == 1) {
            it.next = new ListNode(1);
        }
        return result.next;
    }
}
