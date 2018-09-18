package com.evan.滴滴;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-18 18:57
 **/
public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int np = scanner.nextInt();
        int nq = scanner.nextInt();
        int nr = scanner.nextInt();
        System.out.println(getRs(new int[]{np, nq, nr}, -1));


    }

    public static int getRs(int[] arr, int flag) {
        int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
        if (arr[0] + arr[1] + arr[2] == 1 && arr[flag] != 1) {
            return 1;
        }
        int a = 0;
        if (flag == -1 || arr[flag] != max) {
            a = 1;
        }

        if (max > arr[0] + arr[1] + arr[2] + a) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (i != flag && arr[i] > 0) {
                int[] newArr = new int[arr.length];
                for (int j = 0; j < arr.length; j++) {
                    newArr[j] = arr[j];
                }
                newArr[i]--;
                sum += getRs(newArr, i);
            }
        }
        return sum;
    }
}
