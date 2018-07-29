package com.evan.CSP.CCF_201703;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by asus on 2018/3/8.
 */
public class FenDanGao {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numbers = scanner.nextInt();
        int weight = scanner.nextInt();
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numbers; i++) {
            queue.offer(scanner.nextInt());
        }
        int sum=0,count=0;
        while (queue.size()!=0){
            sum+=queue.poll();
            if(sum>=weight||queue.size()==0) {
                sum=0;
                count++;
            }
        }
        System.out.println(count);
    }



}
