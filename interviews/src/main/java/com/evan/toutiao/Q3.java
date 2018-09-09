package com.evan.toutiao;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-09 10:29
 **/
public class Q3 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.length() >= 4 && str.length() <= 12) {
            getRes(str, 0);
        }
        System.out.println(count);

    }

    private static void getRes(String s, int step) {
        if (step == 4) {
            if (s.equals("")) {
                count++;
            }
            return;

        }
        for (int j = 1; j < 4 && j <= s.length(); j++) {
            String substring = s.substring(0, j);
            if (j > 1 && substring.charAt(0) == '0') {
                continue;
            }
            int number = Integer.parseInt(substring);
            if (number >= 0 && number <= 255) {
                getRes(s.substring(j), step + 1);
            }
        }

    }
}
