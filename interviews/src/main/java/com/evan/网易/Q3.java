package com.evan.网易;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-08-11 16:30
 **/
public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int count = scanner.nextInt();
        int temp = m + n-1 ;
        String res = getRes(temp, count);
        System.out.println(res);

    }

    private static String getRes(int temp, int count) {
        int times = getCount(temp);
        if (count == 1) {
            return "a";
        }
        if (count == 2) {
            return "z";
        }
        if (times >= count) {
            return "a" + getRes(temp - 1, count);
        } else if (times < count) {
            return "z" + getRes(temp - 1, count - times);
        } else {
            return "";
        }
    }

    private static int getCount(int temp) {
        int res = 1;
        for (int i = 1; i <= temp; i++) {
            res *= i;
        }
        return res;
    }
}
