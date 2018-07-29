package com.evan.interviews;

/**
 * Created by asus on 2018/4/8.
 */
public class Q15_二进制中1的个数 {
    /**
     * version 1
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) count++;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * version 2
     *
     * @param n
     * @return
     */
    public int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
