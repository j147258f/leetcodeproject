package com.zh.leetcode.foroffer;

import java.util.Stack;

public class o09 {
    Stack<Integer> i = new Stack<>();
    Stack<Integer> d = new Stack<>();

    public o09() {

    }

    public void appendTail(int value) {
        i.add(value);
    }

    public int deleteHead() {
        if (!d.isEmpty()) return d.pop();
        else {
            while (!i.isEmpty()) {
                d.add(i.pop());
            }
            if(d.isEmpty()){
                return -1;
            }
            return d.pop();
        }
    }
}
