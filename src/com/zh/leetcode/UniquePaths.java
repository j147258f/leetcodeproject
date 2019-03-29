package com.zh.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zhanghao on 2019/3/28.
 */
public class UniquePaths {
    public static void main(String[] strings) {
        System.out.println(uniquePaths(25, 12));
//        System.out.println(uniquePaths1(99, 99));
    }

    static int remanentDown = -1;
    static int remanentRight = -1;
    static Way popedWay = null;
    static LinkedList<Way> path = new LinkedList<>();
    static int pathEmptiedTime = 0;

    public static int uniquePaths1(int m, int n) {
        int[][] range = new int[m][n];
        for(int i =0;i<n;i++){
            range[0][i]=1;
        }
        for (int i=0;i<m;i++){
            range[i][0]=1;
        }
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                range[i][j]=range[i-1][j]+range[i][j-1];
            }
        }
        return range[m-1][n-1];
    }

    /**
     * 复杂度太高
     * @param rightLength 横坐标
     * @param downLength  纵坐标
     * @return
     */
    public static int uniquePaths(int rightLength, int downLength) {
        if ((rightLength == 2 && downLength == 1) || (rightLength == 1 && downLength == 2)) return 1;
        if(rightLength==1&&downLength==1)return 1;
        popedWay = null;
        path = new LinkedList<>();
        remanentDown = downLength - 1;
        remanentRight = rightLength - 1;
        int result = 0;
        pathEmptiedTime = 0;
        for (;;) {
//            printlnPath();
            //总是先下后右
            if (pathEmptiedTime==2 && path.isEmpty()) {
                return result;
            }
            //tryToDown
            if (remanentDown > 0) {
                if (popedWay == Way.Down) {
                    if (remanentRight == 0) {
                        if (path.isEmpty()) {
                            return result;
                        }
                        popWay();
                        continue;
                    }
                    goRight();
                } else if (popedWay == Way.Right) {
                    popWay();
                } else {
                    goDown();
                }
            }
            //tryToRight
            else if (remanentRight > 0) {
                if (popedWay == Way.Down) {
                    popWay();
                } else if (popedWay == Way.Right) {
                    if (remanentDown == 0) {
                        if (path.isEmpty()) {
                            return result;
                        }
                        popWay();
                        continue;
                    }
                    goDown();
                } else {
                    goRight();
                }
            }
            //
            else {
                result++;
                if (path.isEmpty()) {
                    result--;
                    return result;
                }
                popWay();
            }
        }
    }

    enum Way {
        Right, Down
    }

    public static void goDown() {
        path.push(Way.Down);
        remanentDown--;
        popedWay=null;
    }

    public static void goRight() {
        path.push(Way.Right);
        remanentRight--;
        popedWay=null;
    }

    public static void popWay() {
        popedWay = path.pop();
        if (popedWay == Way.Down) {
            remanentDown++;
        } else {
            remanentRight++;
        }

        if(path.isEmpty())pathEmptiedTime++;
    }

    public static void printlnPath() {
        System.out.println(path.toString()+"---"+popedWay);
    }

}
