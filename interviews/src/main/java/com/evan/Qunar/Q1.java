package com.evan.Qunar;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-06 08:32
 **/
public class Q1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
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
            }
        }
        System.out.println(max);
    }
}
