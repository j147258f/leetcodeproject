package com.zh.leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;

        ListNode result = new ListNode(0);
        ListNode returnresult = result;

        boolean addOne = false;

        int amount = l1.val + l2.val;
        if (amount > 9) {
            result.val = amount - 10;
            addOne = true;
        } else {
            result.val = amount;
        }

        while (l1Next != null || l2Next != null) {
            if (l1Next == null && l2Next == null) {
                break;
            } else if (l1Next == null) {
                l1Next = new ListNode(0);
            } else if(l2Next == null){
                l2Next = new ListNode(0);
            }


            amount = l1Next.val + l2Next.val;
            if (addOne) {
                amount += 1;
            }
            ListNode resultNext = new ListNode(0);
            if (amount > 9) {
                resultNext.val = amount - 10;
                addOne = true;
            } else {
                resultNext.val = amount;
                addOne = false;
            }
            result.next = resultNext;
            result = resultNext;

            l1Next = l1Next.next;
            l2Next = l2Next.next;
        }

        return returnresult;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
