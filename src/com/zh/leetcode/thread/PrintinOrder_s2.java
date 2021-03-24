package com.zh.leetcode.thread;

import java.util.concurrent.CountDownLatch;

//1114  请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行
//解法二 用countDownLaunch
public class PrintinOrder_s2 {
    CountDownLatch c2 = new CountDownLatch(1);
    CountDownLatch c3 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        c2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        c2.await();
        printSecond.run();
        c3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        c3.await();
        printThird.run();
    }
}
