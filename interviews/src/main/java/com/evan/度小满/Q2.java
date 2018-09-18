package com.evan.度小满;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-13 15:54
 **/
public class Q2 {
    private static int count=0;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();
        int []arr=new int[number];
        for (int i = 0; i < number; i++) {
            arr[i]=scanner.nextInt();
        }
        int[] val=getRes(arr);
        System.out.println(val[0]+" "+val[1]);

    }

    private static int[] getRes(int[] arr) {
        int length = arr.length;
        if(arr==null||length==0) {
            return new int[]{0,0};
        }
        int[] sell=new int[length];
        int[] sellTimes=new int[length];

        int[] buy=new int[length];
        int[] buyTimes=new int[length];
        sell[0]=0;
        buy[0]=-arr[0];
        buyTimes[0]=1;
        for (int i = 1; i < length; i++) {
            if (buy[i-1]+arr[i]>sell[i-1]){
                sell[i]=buy[i-1]+arr[i];

            }else {
                sell[i]=sell[i-1];
            }

            if (buy[i-1]>sell[i-1]-arr[i]){
                buy[i]=buy[i-1];
            }else {
                buy[i]=sell[i-1]-arr[i];
            }
        }
       /* int step=getStep(buy,sell,sell[length-1]);*/

        return new int[]{sell[length-1],2*count};
    }

    /*private static int getStep(int[] buy, int[] sell, int all,int index,int []arr) {
        int a=getStep(buy,sell,all,index-1,arr);
        all=all-arr[index];
        int b=0;
        for (int i = index; i >=0; i--) {
            if (buy[i]==all){
                b=getStep(buy,sell,all,i,arr);
                bt
            }
        }
    }*/
}
