package com.zh.leetcode;

public class SortList {

    public static void main(String[] args) {
        String str = "[4,2,1,3,4,2,3,45,67,83,4,6,26,547457,456,4,3,7,54,3,6,7,347,74537,23]";
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        String s[] = str.split(",");
        ListNode l = new ListNode();
        ListNode t = l;
        for (int i = 0; i < s.length; i++) {
            t.next = new ListNode(Integer.valueOf(s[i]));
            t = t.next;
        }

        SortList sl = new SortList();
        Long start = System.currentTimeMillis();
        ListNode n = sl.sortList(l.next,null);
        System.out.println(System.currentTimeMillis()-start);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }


    public ListNode sortListFastest(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode t = head;
        ListNode s = head;
        while (t.next != null && t.next.next != null) {
            s = s.next;
            t = t.next.next;
        }
        t = s.next;
        s.next = null;
//        head.next = sortListFastest(head);
//        t.next = sortListFastest(t);
        return merge(sortListFastest(head), sortListFastest(t));
    }

    public ListNode merge2(ListNode h1,ListNode h2){ //合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if(h1!=null)    p.next = h1;
        else if(h2!=null) p.next = h2;
        return dummy.next;

    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }


    //每次找最小 递归  速度太慢
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode t = head;
        ListNode pre = null;
        ListNode min = head;
        ListNode minpre = null;
        ListNode max = head;
        ListNode maxpre = null;
        while (t != null) {
            if (min.val > t.val) {
                min = t;
                minpre = pre;
            }
            if (max.val < t.val) {
                max = t;
                maxpre = pre;
            }
            pre = t;
            t = t.next;
        }

        if (minpre != null) {
            minpre.next = null;
            pre.next = head;
        }
        min.next = sortList(min.next);
        return min;

    }

    //每次寻找最小的同时也找最大，并放至最后，效率加倍（时间复杂度不变，空间复杂度up）
    public ListNode sortList(ListNode start, ListNode end) {
        if (start == end || start.next == end) return start;
        ListNode t = start;
        ListNode pre = null;
        ListNode min = start;
        ListNode minpre = null;
        ListNode max = start;
        ListNode maxpre = null;
        while (t != null && t != end) {
            if (min.val > t.val) {
                min = t;
                minpre = pre;
            }
            if (max.val < t.val) {
                max = t;
                maxpre = pre;
            }
            pre = t;
            t = t.next;
        }

        ListNode newListLast;
        if (minpre != null) {
            minpre.next = end;
            pre.next = start;
            newListLast = minpre;
        } else {
            newListLast = pre;
        }

        if (newListLast != max) {
            if (maxpre == null) {
                ListNode temp = newListLast.next;
                newListLast.next = max;
                pre.next = max.next;
                max.next = temp;
            } else {
                maxpre.next = max.next;
                ListNode temp = newListLast.next;
                newListLast.next = max;
                max.next = temp;
            }
        }

        min.next = sortList(min.next, max);
        return min;

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

