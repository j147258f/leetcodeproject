package com.zh.leetcode;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberofIslands {
    public static void main(String[] args) {
        System.out.println("".replaceAll("\\[", "{").replaceAll("\\]", "}").replaceAll("\"", "'"));

        char[][] grid = {{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        NumberofIslands n = new NumberofIslands();
        System.out.println(n.numIslands(grid));
    }

    char[][] g;
    int count;

    public int numIslands(char[][] grid) {
        g = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (searchDeep(i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean searchDeep(int i, int j) {
        boolean b = false;

        if (g[i][j] == '1') {
            b = true;
            g[i][j] = '0';
            if (i != g.length - 1) {
                searchDeep(i + 1, j);
            }
            if (j != g[i].length - 1) {
                searchRight(i, j + 1);
            }
            if (j != 0) {
                searchLeft(i, j - 1);
            }
        }

        return b;
    }

    private void searchRight(int i, int j) {
        if (g[i][j] == '1') {
            g[i][j] = '0';
            if (i != g.length - 1) {
                searchDeep(i + 1, j);
            }
            if (i != 0) {
                searchUp(i - 1, j);
            }
            if (j != g[i].length - 1) {
                searchRight(i, j + 1);
            }
        }
    }

    private void searchLeft(int i, int j) {
        if (g[i][j] == '1') {
            g[i][j] = '0';
            if (i != g.length - 1) {
                searchDeep(i + 1, j);
            }
            if (i != 0) {
                searchUp(i - 1, j);
            }
            if (j != 0) {
                searchLeft(i, j - 1);
            }
        }
    }

    private void searchUp(int i, int j) {
        if (g[i][j] == '1') {
            g[i][j] = '0';
            if (i != 0) {
                searchUp(i - 1, j);
            }
            if (j != g[i].length - 1) {
                searchRight(i, j + 1);
            }
            if (j != 0) {
                searchLeft(i, j - 1);
            }
        }
    }
}
