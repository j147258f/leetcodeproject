package com.zh.leetcode;

//239. 滑动窗口最大值
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        s.maxSlidingWindow(new int[]{1,-1}, 1);
    }

    ListNode head = new ListNode(0);
    ListNode tail;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        int max = build(nums, 0, k - 1);
        result[resultIndex] = max;
        resultIndex++;
        int left = 1;
        int right = left + k - 1;
        while (right < nums.length) {
            int lost = nums[left - 1];
            int add = nums[right];
            max = findMax(add, lost);
            result[resultIndex] = max;
            left++;
            right++;
            resultIndex++;
        }
        return result;
    }

    private int findMax(int add, int lost) {
        remove(lost);
        addToListNode(add);
        return tail.val;
    }

    private int build(int[] nums, int left, int right) {
        ListNode node = new ListNode(nums[left]);
        head.next = node;
        node.pre = head;
        tail = node;
        for (int i = left + 1; i <= right; i++) {
            addToListNode(nums[i]);
        }
        return tail.val;
    }

    private void remove(int num) {
        if (tail.val == num) {
            tail.pre.next = null;
            tail = tail.pre;
        }
    }

    private void addToListNode(int num) {
        ListNode node = new ListNode(num);
        if(num>tail.val||head.next==null){
            //处理num最大的情况
            head.next = node;
            node.pre = head;
            tail = node;
            return;
        }

        ListNode current = head.next;
        while (current != null) {
            if (current.val >= num) {
                head.next = node;
                node.pre = head;
                node.next = current;
                current.pre = node;
                return;
            }
            current = current.next;
        }

    }

    private static class ListNode {
        ListNode next;
        ListNode pre;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private String print() {
        String s = "";
        ListNode temp = head.next;
        while (temp != null) {
            s = s + "," + temp.val;
            temp = temp.next;
        }
        return s;
    }


}
