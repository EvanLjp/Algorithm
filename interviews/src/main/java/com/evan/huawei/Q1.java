package com.evan.huawei;
import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-08 19:28
 **/
public class Q1 {
    private static int[][] arr = new int[10][10];
    private static boolean[][] map = new boolean[10][10];
    private static boolean[][] visted = new boolean[10][10];
    private static int x, y;
    private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String s = scanner.nextLine();
            char[] array = s.toCharArray();
            for (int j = 0; j < array.length; j++) {
                if (array[j] == '1') {
                    arr[i][j] = 1;
                    map[i][j] = false;
                } else if (array[j] == '0') {
                    arr[i][j] = 0;
                    map[i][j] = true;
                } else {
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                    map[i][j] = true;
                }
            }
        }
        boolean flag = dfs(arr, map, x, y);
        System.out.println(flag ? 1 : 0);
        System.out.println(System.currentTimeMillis()-l);

    }

    private static boolean dfs(int[][] arr, boolean[][] map, int x, int y) {
        try {
            if (visted[x][y]) {
                return map[x][y];
            }
            if (outOfGraph(x, y)) {
                return true;
            }
            if (!map[x][y]) {
                return false;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (dfs(arr, map, newX, newY)) {
                    return true;
                }
            }
            return false;
        }finally {
            visted[x][y] = true;
        }



    }

    private static boolean outOfGraph(int x, int y) {
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            return true;
        } else {
            return false;
        }
    }

}
