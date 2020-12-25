package com.zh.leetcode.foroffer;

import java.util.PriorityQueue;

public class o41 {

    PriorityQueue<Integer> bigger = new PriorityQueue<>();
    PriorityQueue<Integer> little = new PriorityQueue<>((x, y) -> y - x);

    public void addNum(int num) {
        if (little.size() == bigger.size()) {
            bigger.add(num);
            little.add(bigger.poll());
        } else {
            little.add(num);
            bigger.add(little.poll());
        }
    }


    public double findMedian() {
        if (little.size() > bigger.size()) return little.peek();
        else return (little.peek() + bigger.peek()) / 2.0d;
    }
}
