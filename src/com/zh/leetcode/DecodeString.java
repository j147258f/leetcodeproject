package com.zh.leetcode;

public class DecodeString {


    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        MyStack my = new MyStack();
        System.out.println(ds.decodeString("3[a]2[b4[F]c]"));
    }

    public String decodeString(String s) {
        MyStack ms = new MyStack();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isNumber(chars[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && isNumber(chars[i])) {
                    sb.append(chars[i]);
                    i++;
                }
                i--;
                if (sb.length() != 0) {
                    ms.push(sb.toString());
                }
            } else if (chars[i] == '[') {
                ms.push(chars[i]);
            } else if (chars[i] == ']') {
                String a = ms.pop();
                String b = ms.pop();
                if(!b.equals("[")){
                    ms.push(b + a);
                    i--;
                }else{
                    String c = ms.pop();
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < Integer.valueOf(c); j++) {
                        sb.append(a);
                    }
                    if (ms.size != 0 && (ms.getTop().length() > 1 || isLetter(ms.getTop().toCharArray()[0]))) {
                        ms.push(ms.pop() + sb.toString());
                    } else {
                        ms.push(sb.toString());
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && isLetter(chars[i])) {
                    sb.append(chars[i]);
                    i++;
                }
                i--;
                if (sb.length() != 0) {
                    ms.push(sb.toString());
                }
            }
        }
        return ms.toString();
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}

class MyStack {
    Node head = new Node();
    Node top = head;
    int size = 0;

    public void push(String val) {
        Node n = new Node();
        n.val = val;
        n.pre = top;
        top.next = n;
        top = n;
        size++;
    }

    public void push(char val) {
        push(String.valueOf(val));
    }

    public String pop() {
        Node temp = top;
        top = top.pre;
        top.next = null;
        size--;
        return temp.val;
    }

    public String getTop() {
        return top.val;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp.next != null) {
            if (temp.val != null) sb.append(temp.val);
            temp = temp.next;
        }
        if (temp.val != null) sb.append(temp.val);
        return sb.toString();
    }

    class Node {
        Node next;
        Node pre;
        String val;
    }
}