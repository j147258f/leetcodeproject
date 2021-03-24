package com.zh.leetcode.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

//1114  LockSupport解法
public class PrintinOrder_s3 {

    Map<Integer, Thread> map = new ConcurrentHashMap<>();

    public PrintinOrder_s3() {

    }
    public void first(Runnable printFirst) throws InterruptedException {
        map.putIfAbsent(1, Thread.currentThread());
        printFirst.run();
        LockSupport.unpark(map.get(2));
    }

    public void second(Runnable printSecond) throws InterruptedException {
        map.putIfAbsent(2, Thread.currentThread());
        Thread t1 = map.get(1);
        if (t1 == null || t1.isAlive()) LockSupport.park();
        printSecond.run();
        LockSupport.unpark(map.get(3));
    }

    public void third(Runnable printThird) throws InterruptedException {
        map.putIfAbsent(3, Thread.currentThread());
        Thread t1 = map.get(1);
        Thread t2 = map.get(2);
        if (t1 == null || t1.isAlive()) LockSupport.park();
        else if (t2 == null || t2.isAlive()) LockSupport.park();
        printThird.run();
    }
}
