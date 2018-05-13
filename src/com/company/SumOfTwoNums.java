package com.company;

/**
 * Created by zhanghao on 2018/5/13.
 */
public class SumOfTwoNums {

    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        addTwoNumbers(l1,l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum=new ListNode(0);
        ListNode next=new ListNode(0);
        sum=next;
        int looptime=1;
        ListNode l1_index=l1;
        ListNode l2_index=l2;
        int lazy_add=0;
        while(l1_index!=null || l2_index!=null||lazy_add==1){
            if(l1_index==null)l1_index=new ListNode(0);
            if(l2_index==null)l2_index=new ListNode(0);
            ListNode temp=null;
            int value=l1_index.val+l2_index.val;
            if( value+lazy_add>9){
                value = (value-10);
                temp=new ListNode(value+lazy_add);
                lazy_add=1;
            }else{
                temp=new ListNode(value+lazy_add);
                lazy_add=0;
            }


            System.out.println(temp.val);
            l1_index=l1_index.next;
            l2_index=l2_index.next;
            next.next=temp;
            next=next.next;
        }

        return sum.next;
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
