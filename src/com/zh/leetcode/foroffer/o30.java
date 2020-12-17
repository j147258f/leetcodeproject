package com.zh.leetcode.foroffer;

import java.util.Stack;

public class o30 {

    private Stack<Integer> a = new Stack<>();
    private Stack<Integer> b = new Stack<>();

    public void push(int x) {
        a.add(x);
        if (b.isEmpty() || b.peek() >= x) b.add(x);
    }

    public void pop() {
        int i = a.pop();
        if(i==b.peek())b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}
