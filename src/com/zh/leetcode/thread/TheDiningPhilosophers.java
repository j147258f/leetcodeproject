package com.zh.leetcode.thread;

//1226 看不懂题
public class TheDiningPhilosophers {

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        synchronized (this){
            pickLeftFork.run();
            eat.run();
            putLeftFork.run();
        }

    }
}
