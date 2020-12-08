package com.zh.leetcode.foroffer;

import com.zh.ListNode;

//使用递归 只遍历了一次
public class o06 {

    int[] result = null;

    public int[] reversePrint(ListNode head) {
        if(head==null)return new int[0];
        find(head, 0);
        return result;
    }

    private int find(ListNode n, int index) {
        if (n.next == null) {
            if (result == null) {
                result = new int[index + 1];
            }
            result[0] = n.val;
            return index;
        }
        int i = find(n.next, index + 1);
        if (result == null) {
            result = new int[i + 1];
        }
        result[i - index] = n.val;
        return i;
    }
}
