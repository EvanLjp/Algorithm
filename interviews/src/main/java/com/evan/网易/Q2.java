package com.evan.网易;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-08-11 15:55
 **/
public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[][] = new int[n][2];
        arr[0][0] = 0;
        arr[0][1] = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            arr[i][0] = arr[i - 1][1];
            arr[i][1] = arr[i - 1][1] + scanner.nextInt();
        }
        int m = scanner.nextInt();
        int mid = 0;
        for (int i = 0; i < m; i++) {
            int count = scanner.nextInt();
            int left = 0, right = n - 1;

            while (true) {
                mid = (left + right) / 2;
                if (arr[mid][0] < count&&arr[mid][1]>=count) {
                    break;
                } else if (arr[mid][0] > count) {
                    right = mid-1;
                } else if (arr[mid][1] < count) {
                    left = mid+1;
                } else {
                    break;
                }
            }
            System.out.println(mid+1);
        }

    }
}
