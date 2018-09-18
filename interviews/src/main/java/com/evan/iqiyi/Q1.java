package com.evan.iqiyi;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-15 09:59
 **/
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] array = s.toCharArray();
        int[] before = new int[3];
        int[] after = new int[3];
        if (compare(array)) {
            for (int i = 0; i < 3; i++) {
                before[i] = array[i] - '0';
            }
            for (int i = 3; i < 6; i++) {
                after[i-3] = array[i] - '0';
            }
        } else {
            for (int i = 0; i < 3; i++) {
                after[i] = array[i] - '0';
            }
            for (int i = 3; i < 6; i++) {
                before[i-3] = array[i] - '0';
            }
        }
        int res = getRes(before, after);
        System.out.println(res);

    }

    private static int getRes(int[] before, int[] after) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 3; i++) {
            sum1 += before[i];
        }
        for (int i = 0; i < 3; i++) {
            sum2 += after[i];
        }
        int sub = sum2 - sum1;
        for (int i = 0; i < 3; i++) {
            before[i] = 9 - before[i];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < 3; i++) {
            queue.add(before[i]);
            queue.add(after[i]);
        }
        int count = 0;
        while (sub > 0) {
            Integer poll = queue.poll();
            sub -= poll;
            count++;
        }
        return count;


    }

    private static boolean compare(char[] array) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 3; i++) {
            sum1 += array[i] - '0';
        }
        for (int i = 3; i < 6; i++) {
            sum2 += array[i] - '0';
        }
        return sum1 < sum2;
    }


}
