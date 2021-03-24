package com.zh.leetcode.thread;

//1114  请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行
public class PrintinOrder_s1 {


    public PrintinOrder_s1() {

    }

    volatile int state = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (state != 1) {
                this.wait();
            }
            printFirst.run();
            state = 2;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (state != 2) {
                this.wait();
            }
            printSecond.run();
            state = 3;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (state != 3) {
                this.wait();
            }
            printThird.run();
            state = 4;
            this.notifyAll();
        }
    }
}
