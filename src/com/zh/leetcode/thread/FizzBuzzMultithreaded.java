package com.zh.leetcode.thread;

import java.util.function.IntConsumer;

//1195
public class FizzBuzzMultithreaded {

    private int n;
    volatile private int index = 1;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (index <= n) {
                boolean fizz = index % 3 == 0;
                boolean buzz = index % 5 == 0;
                if (fizz && buzz) {
                    this.wait();
                } else if (fizz) {
                    printFizz.run();
                    index++;
                    this.notifyAll();
                } else if (buzz) {
                    this.wait();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (index <= n) {
                boolean fizz = index % 3 == 0;
                boolean buzz = index % 5 == 0;
                if (fizz && buzz) {
                    this.wait();
                } else if (fizz) {
                    this.wait();
                } else if (buzz) {
                    printBuzz.run();
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (index <= n) {
                boolean fizz = index % 3 == 0;
                boolean buzz = index % 5 == 0;
                if (fizz && buzz) {
                    printFizzBuzz.run();
                    index++;
                    this.notifyAll();
                } else if (fizz) {
                    this.wait();
                } else if (buzz) {
                    this.wait();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (index <= n) {
                boolean fizz = index % 3 == 0;
                boolean buzz = index % 5 == 0;
                if (fizz && buzz) {
                    this.wait();
                } else if (fizz) {
                    this.wait();
                } else if (buzz) {
                    this.wait();
                } else {
                    printNumber.accept(index);
                    index++;
                    this.notifyAll();
                }
            }
        }
    }
}
