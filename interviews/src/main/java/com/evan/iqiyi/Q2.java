package com.evan.iqiyi;

import java.util.Queue;
import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-15 10:51
 **/
public class Q2 {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int P = scanner.nextInt();
        int [] arr=new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < M; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if (split[0].equals("A")){
                arr[Integer.parseInt(split[1])-1]++;
            }else{
                arr[Integer.parseInt(split[1])-1]--;
            }
        }
        int count=1;
        for (int i = 0; i < N; i++) {
            if (arr[i]>arr[P-1]){
                count++;
            }
        }

        System.out.println(count);



    }
}
