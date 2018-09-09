package com.evan.美团模拟;

import java.util.Scanner;


/**
 * @author :evan
 * @date :2018-09-04 12:24
 **/
public class Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = (i > 0 && j > 0) ? dp[i - 1][j - 1] + 1 : 1;
                }
                max = Math.max(max, dp[i][j]);
                printDP(dp);
            }
        }
        System.out.println(max);

    }

    private static void printDP(int[][] dp) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
