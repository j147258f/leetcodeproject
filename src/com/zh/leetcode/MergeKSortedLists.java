package com.zh.leetcode;

/**
 * niub 一次过  就是效率低了点
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //find null

        ListNode min =null;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
           if(min==null&&lists[i]!=null){
               min = lists[i];
               index = i;
           }else if(min!=null){
               if(lists[i]!=null && lists[i].val<min.val){min = lists[i];index = i;}
           }
        }

        if(index!=-1){
            lists[index] = lists[index].next;
            min.next = mergeKLists(lists);
        }

        return min;
    }
}