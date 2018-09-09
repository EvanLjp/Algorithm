package com.evan.toutiao;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-09 10:05
 **/
public class Q2 {
    private static boolean[][] visisted;
    private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int outRange=0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        outRange=n;
        System.out.print(getGroup(arr, n));


    }


    public static int getGroup(int[][] map, int n) {
        visisted = new boolean[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visisted[i][j]) {
                    res++;
                    dfs(map, i, j);

                }
            }
        }
        return res;
    }

    private static boolean isContained(int inputX, int inputY) {
        if (inputX > -1 && inputX < outRange && inputY > -1 && inputY < outRange) return true;
        else return false;
    }

    private static void dfs(int[][] map, int x, int y) {
        visisted[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (isContained(newX, newY) && map[newX][newY] == 1 && !visisted[newX][newY])
                dfs(map, newX, newY);
        }
    }
}
