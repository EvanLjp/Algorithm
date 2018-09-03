package com.evan.leetcode.algorithm.recursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/13.
 */
public class Q200NumberofIslands {
    boolean[][] visisted;
    int x, y;
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        x = grid.length;
        if (x == 0) return 0;
        y = grid[0].length;
        visisted = new boolean[x][y];
        int res = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1' && !visisted[i][j]) {
                    res++;
                    dfs(grid, i, j);

                }
            }
        }
        return res;
    }

    private boolean isContained(int inputX, int inputY) {
        if (inputX > -1 && inputX < x && inputY > -1 && inputY < y) return true;
        else return false;
    }

    private void dfs(char[][] grid, int x, int y) {
        visisted[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (isContained(newX, newY) && grid[newX][newY] == '1' && !visisted[newX][newY])
                dfs(grid, newX, newY);
        }
    }

    @Test
    public void test() {
        //char[][] arr={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] arr = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(arr));
    }


}
