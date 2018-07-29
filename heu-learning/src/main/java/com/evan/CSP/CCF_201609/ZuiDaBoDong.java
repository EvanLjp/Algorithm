package com.evan.CSP.CCF_201609;

import java.util.Scanner;

/**
 * Created by asus on 2018/3/14.
 */
public class ZuiDaBoDong {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numbers = scanner.nextInt();
        int[] arr=new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i]=scanner.nextInt();

        }
        int max=0;
        for (int i = 1; i <numbers; i++) {
            max=Math.max(max,Math.abs(arr[i]-arr[i-1]));
        }
        System.out.println(max);

    }
}
