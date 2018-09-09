package com.evan.toutiao;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-09 10:43
 **/
public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = (scanner.nextInt() & 255);
        }

        System.out.println(getRes(arr, 0) ? '1' : '0');


    }

    private static boolean getRes(int[] arr, int index) {
        int flag = 128;
        int count = 0;
        while ((arr[index] & flag) >= flag) {
            flag = flag >> 1;
            count++;
        }
        if (count > arr.length - index - 1) {
            return false;
        } else {
            if (count == 0) {
                if (index + 1 == arr.length) {
                    return true;
                }
                return getRes(arr, index + 1);
            } else {
                boolean f = true;
                for (int i = index + 1; i < index + count; i++) {
                    if (!((arr[i] & 128) == 128 && ((arr[i] & 64) == 0))) {
                        f = false;
                        break;
                    }
                }
                if (!f) {
                    return false;
                } else {
                    return getRes(arr, index + count);
                }
            }


        }


    }
}
