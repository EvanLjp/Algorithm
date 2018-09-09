package com.evan.Qunar;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-06 08:32
 **/
public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int number = scanner.nextInt();
            if (number <= 0) {
                break;
            }
            long[] x = new long[ 2];
            long[] y = new long[2];
            for (int i = 0; i < 2; i++) {
                x[i] = scanner.nextLong();
                y[i] = scanner.nextLong();
            }

            for (int i = 2; i <number ; i++) {
                
            }


            if (number<3){
                System.out.println("NO");
            }else if (number==3){
                System.out.println("YES");
            }else{
                x[number] = x[0];
                y[number] = y[0];
                x[number + 1] = x[1];
                y[number + 1] = y[1];
                long flag = 1L;
                for (int i = 0; i < number; i++) {
                    flag = getDir(x[i], y[i], x[i + 1], y[i + 1], x[i + 2], y[i + 2]);
                    if (flag > 0) {
                        break;
                    }
                }
                if (flag <= 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }


        }
    }

    private static long getDir(long x1, long y1, long x2, long y2, long x3, long y3) {
        //return (x1-x2)*(y3-y2)-(x3-x2)*(y1-y2);
        return (x3 - x1) * (y2 - y1) -  (x2 - x1) * (y3 - y1);
    }
}
