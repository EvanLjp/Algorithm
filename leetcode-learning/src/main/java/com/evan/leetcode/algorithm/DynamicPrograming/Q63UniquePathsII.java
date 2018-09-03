package com.evan.leetcode.algorithm.DynamicPrograming;

import org.junit.Test;

/**
 * Created by asus on 2018/2/18.
 */
public class Q63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m + 1][n + 1];
        arr[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) continue;
                else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m][n];
    }
    @Test
    public void test(){
        int[][]arr={{0},{0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }


}
