package com.zh.leetcode.foroffer;

public class o31 {
    public static void main(String[] args) {
        new o31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;

        int[] stack = new int[pushed.length];
        int indexStack = 0;
        int indexPop = 0;

        for (int i : pushed) {
            stack[indexStack] = i;
            while (indexStack != -1 && stack[indexStack] == popped[indexPop]) {
                indexStack--;
                indexPop++;
            }
            indexStack++;
        }
        return indexStack == 0;
    }
}
