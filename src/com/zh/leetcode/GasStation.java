package com.zh.leetcode;

/**
 * 134
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[][] currentGas = new int[gas.length][];


        return -1;
    }

    //击败33.17
    public int canCompleteCircuit_slow2(int[] gas, int[] cost) {
        int sum = 0;
        int[] subtract = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            subtract[i] = gas[i] - cost[i];
            sum += subtract[i];
        }
        if (sum < 0) return -1;
        for (int i = 0; i < subtract.length; i++) {
            int currentGas = subtract[i];
            if (subtract[i] < 0) continue;
            int j = i + 1;
            if (j == subtract.length) {
                j = 0;
            }
            while (j != i) {
                currentGas += subtract[j];
                if (currentGas < 0) break;
                j++;
                if (j == gas.length) {
                    j = 0;
                }
            }
            if (j == i && currentGas >= 0) {
                return i;
            }
        }
        return -1;
    }

    //击败29.47%
    public int canCompleteCircuit_slow(int[] gas, int[] cost) {
        int gasSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
        }

        int costSum = 0;
        for (int i = 0; i < cost.length; i++) {
            costSum += cost[i];
        }
        if (costSum > gasSum) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            //如果从i开始
            int currentGas;
            int j = i + 1;
            currentGas = gas[i] - cost[i];
            if (currentGas < 0) continue;
            if (i == gas.length - 1) {
                j = 0;
            }

            while (j != i) {
                currentGas = currentGas + gas[j] - cost[j];
                if (currentGas < 0) {
                    //开不到
                    break;
                } else {
                    //开得到
                    j++;
                    if (j == gas.length) {
                        j = 0;
                    }
                }
            }
            if (j == i) {
                return i;
            }
        }
        return -1;
    }
}
