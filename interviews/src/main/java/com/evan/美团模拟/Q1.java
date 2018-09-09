package com.evan.美团模拟;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-04 11:14
 **/
public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] map = new int[number + 1];
        map[0] = 1;
        map[1] = 1;
        for (int i = 2; i <= number; i++) {
            for (int j = 0; j < i; j++) {
                map[i] += map[j];
            }
        }
        System.out.println(map[number]);


    }
}
