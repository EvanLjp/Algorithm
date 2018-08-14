package com.evan.网易;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-08-11 15:33
 **/
public class Q1 {

   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }
        int left=0,right=-1;
        for (int i = 0; i < n; i++) {
            if (arr2[i]==1&&right-left<k-1){
                continue;
            }else

        }

    }*/
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }
        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr2[i] == 1) {
                continue;
            }
            int res = 0;
            for (int j = 0; j < k&&i+j<n; j++) {
                res += arr1[i + j];
            }
            if (res > max) {
                max = res;
                index = i;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr2[i] == 1) {
                result += arr1[i];
            }
        }
        int add = 0;
        for (int i = index; i < index + k; i++) {
            if (arr2[i] == 0) {
                add += arr1[i];
            }
        }
        System.out.println(result + add);


    }*/
}
