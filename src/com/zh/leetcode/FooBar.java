package com.zh.leetcode;

public class FooBar {
    private Boolean flag = false;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (flag) {
                if (!flag) {
                    printFoo.run();
                    flag = true;
                } else {
                    i--;
                }
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (flag) {
                if (flag) {
                    printBar.run();
                    flag = false;
                } else {
                    i--;
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        FooBar t = new FooBar(50);
        Thread foo = new Thread(() -> {
            try {
                t.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        foo.setDaemon(false);
        foo.start();

        Thread bar = new Thread(() -> {
            try {
                t.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        bar.setDaemon(false);
        bar.start();

    }
}

