package com.zh.leetcode.thread;

import java.util.concurrent.Semaphore;

//1117 信号量
public class BuildingH2O {

    volatile int h = 0;

    Semaphore hSmp = new Semaphore(2);
    Semaphore oSmp = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSmp.acquire();
        releaseHydrogen.run();
        synchronized (this) {
            if (h == 0) {
                h = 1;
            }else if(h==1){
                oSmp.release(1);
                h = 0;
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSmp.acquire();
        releaseOxygen.run();
        hSmp.release(2);
    }
}
