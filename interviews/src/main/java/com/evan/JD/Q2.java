package com.evan.JD;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-09 20:50
 **/
public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            map[i][0]=scanner.nextInt();
            map[i][1]=scanner.nextInt();
            map[i][2]=scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                if (isMIn(map[i], map[j])) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static boolean isMIn(int[] ints, int[] ints1) {
        if (ints[0] < ints1[0] && ints[1] < ints1[1] && ints[2] < ints1[2]) {
            return true;
        }
        return false;
    }
}
