package com.evan.leetcode.LEETCODE.DynamicPrograming;

/**
 * Created by asus on 2018/2/18.
 */
public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int[][] arr=new int[m+1][n+1];
        arr[0][1]=1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m][n];
    }









}
