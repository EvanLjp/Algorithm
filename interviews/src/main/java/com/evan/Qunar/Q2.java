package com.evan.Qunar;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-06 08:32
 **/
public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int number = scanner.nextInt();
            if (number <= 0) {
                break;
            }
            long[] x = new long[number ];
            long[] y = new long[number ];
            for (int i = 0; i < number; i++) {
                x[i] = scanner.nextLong();
                y[i] = scanner.nextLong();
            }

            if (number < 3) {
                System.out.println("NO");
            } else if (number == 3) {
                System.out.println("YES");
            } else {
                long flag = getDir(x[0], y[0], x[1], y[1], x[2], y[2]);
                for (int i = 1; i < number; i++) {
                    flag =flag*getDir(x[i], y[i], x[(i + 1)%number], y[(i + 1)%number], x[(i + 2)%number], y[(i + 2)%number]);
                    if (flag < 0) {
                        break;
                    }
                }
                if (flag > 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }


        }
    }

    private static long getDir(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3);
    }


}
