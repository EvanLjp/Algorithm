package com.evan.美团模拟;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-04 11:51
 **/
public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
        }
        int max=0;
        for (int i = 0; i < number; i++) {
            int minHeight=arr[i];
            int left=i,right=i;
           while (left>0&&arr[left-1]>=minHeight){
               left--;
           }
            while (right<number-1&&arr[right+1]>=minHeight){
                right++;
            }
            max= Math.max(max,(right-left+1)*minHeight);
        }
        System.out.println(max);

    }
}
