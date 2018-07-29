package com.evan.interviews;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/10 22:44
 */
public class Q17_打印从1到最大的n位数 {

    /**
     * version 1
     *
     * @param n
     */
    public void printNum(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!increase(number)) {
            printIt(number);
        }
    }

    private boolean increase(char[] number) {
        boolean isOverFlow = false;
        int takeOver = 0;
        int sum = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            sum = (number[i] - '0') + takeOver + (i == number.length - 1 ? 1 : 0);
            takeOver = 0;
            if (sum >= 10) {
                if (i == 0) isOverFlow = true;
                else {
                    takeOver = 1;
                    sum -= 10;
                    number[i] = (char) ('0' + sum);
                }
            } else {
                number[i] = (char) ('0' + sum);
            }
        }
        return isOverFlow;
    }

    private void printIt(char[] number) {
        boolean isBegining = false;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != '0' || isBegining) {
                isBegining = true;
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    /**
     * version 2
     *
     * @param n
     */
    public void printNum_2(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, -1);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length - 1) {
            printIt(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit + 1] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }


    @Test
    public void test() {
        printNum_2(2);
    }


}
