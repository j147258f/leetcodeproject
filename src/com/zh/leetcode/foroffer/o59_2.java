package com.zh.leetcode.foroffer;

import java.util.LinkedList;

public class o59_2 {
    LinkedList<Integer> a = new LinkedList<>();
    LinkedList<Integer> b = new LinkedList<>();

    public int max_value() {
        if(a.isEmpty())return -1;
        return b.peekFirst();
    }

    public void push_back(int value) {
        a.add(value);
        if (b.isEmpty()) {
            b.add(value);
        } else if (value > b.peekLast()) {
            Integer temp = b.pollLast();
            while (temp != null) {
                if (temp > value) {
                    b.add(temp);
                    b.add(value);
                    break;
                }
                temp = b.pollLast();
            }
            if (b.isEmpty()) b.add(value);
        }else{
            b.add(value);
        }
    }

    public int pop_front() {
        if(a.isEmpty())return -1;
        int temp = a.pollFirst();
        if (temp == b.peekFirst()) {
            b.pollFirst();
        }
        return temp;
    }
}
