package com.zh.leetcode;

/**
 * 155 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

    public MinStack() {

    }

    public void push(int x) {
        last.next = new Node();
        last.next.val = x;
        last.next.pre = last;
        if (min == null || min > x) min = x;
        last = last.next;
    }

    public void pop() {
        int lastVal = last.val;
        last = last.pre;
        last.next = null;
        if (lastVal == min) {
            min = null;

            Node n = head.next;
            while (n != null) {
                if (min == null || n.val < min) min = n.val;
                n = n.next;
            }
        }

    }

    public int top() {
        return last.val;
    }

    public int getMin() {
        return min;
    }

    private Integer min = null;
    private Node head = new Node();
    private Node last = head;

    private static class Node {
        int val;
        Node next;
        Node pre;
    }
}
