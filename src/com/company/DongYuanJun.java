package com.company;

/**
 * Created by zhanghao on 2018/5/29.
 */
public class DongYuanJun {
    public void biggestAndRepeatmost(int[] ints) {
        if (null == ints || 0 == ints.length) return;
        int biggest = 0;
        int repeatCount_most = 0;
        for (int i = 0; i < ints.length; i++) {
            int repeatCount = 0;
            for (int j = 0; j < ints.length; j++) {
                if (ints[i] == ints[j]) {
                    repeatCount++;
                }
                if (j == ints.length - 1) {
                    if (repeatCount > repeatCount_most) {

                        biggest = ints[i];
                        repeatCount_most = repeatCount;
                    } else if (repeatCount > repeatCount_most && biggest < ints[i]) {
                        biggest = ints[i];
                        repeatCount_most = repeatCount;
                    }
                }
            }
        }
        System.out.println("num:" + biggest);
        System.out.println("count:" + (repeatCount_most - 1));
    }
}
