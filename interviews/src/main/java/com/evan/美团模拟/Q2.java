package com.evan.美团模拟;

import java.util.*;

/**
 * @author :evan
 * @date :2018-09-04 11:19
 **/
public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] map = {1, 5, 10, 20, 50, 100};
        long[] dp = new long[number + 1];
        dp[0] = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = map[i]; j <= number; j++) {
                dp[j] = dp[j] + dp[j - map[i]];
            }
        }
        System.out.println(dp[number]);

    }
}


    /*public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        int []map=new int[N+1];
        map[0]=1;
        for (int i = 1; i <=N ; i++) {
            if (i>=1){
                map[i]+=map[i-1];
            }
            if (i>=5){
                map[i]+=map[i-5];
            }
            if (i>=10){
                map[i]+=map[i-10];
            }
            if (i>=20){
                map[i]+=map[i-20];
            }
            if (i>=50){
                map[i]+=map[i-50];
            }
            if (i>=100){
                map[i]+=map[i-100];
            }
        }
        System.out.println(map[N]);

    }*/