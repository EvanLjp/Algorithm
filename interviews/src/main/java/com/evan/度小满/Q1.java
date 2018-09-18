package com.evan.度小满;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-13 15:38
 **/
public class Q1 {


    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int []map=new int[100003];
        int min=100001;
        int max=0;
        int count =0;
        for (int i = 0; i < n; i++) {
            int end = scanner.nextInt();
            min=Math.min(min,end);
            int start= scanner.nextInt();
            max= Math.max(start,max);
            for (int j = end; j <start ; j++) {
                map[j]++;
                if (map[j]>count){
                    count=map[j];
                }
            }
        }
        /*int count=0;
        for (int i = min; i <= max; i++) {
            count=Math.max(count,map[i]);
        }*/
        System.out.print(count);

    }
}
