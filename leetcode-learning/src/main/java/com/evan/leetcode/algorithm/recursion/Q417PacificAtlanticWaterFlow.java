package com.evan.leetcode.algorithm.recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/13.
 */
public class Q417PacificAtlanticWaterFlow {
    int x, y;
    boolean[][] Pacific, Atlantic;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        x = matrix.length;
        if (x != 0) y = matrix[0].length;
        Pacific = new boolean[x][y];
        Atlantic = new boolean[x][y];
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            if (!Pacific[i][0])dfs(Pacific, matrix, i, 0);
            if (!Atlantic[i][y-1])dfs(Atlantic, matrix, i, y - 1);
        }
        for (int i = 0; i < y; i++) {
            if (!Pacific[0][i])dfs(Pacific, matrix, 0, i);
            if (!Atlantic[x-1][i])dfs(Atlantic, matrix, x - 1, i);
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (Pacific[i][j] && Atlantic[i][j])

                    res.add(new int[]{i, j});
            }
        }
        return res;
    }

    private boolean isContained(int inputX, int inputY) {
        if (inputX > -1 && inputX < x && inputY > -1 && inputY < y) return true;
        else return false;
    }

    private void dfs(boolean[][] map, int[][] matrix, int x, int y) {
        map[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isContained(newX, newY) && !map[newX][newY] && matrix[newX][newY] >= matrix[x][y])
                dfs(map, matrix, newX, newY);
        }
    }

    @Test
    public void test(){
        int[][]arr={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(arr));
    }
}
