package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-20 10:08
 **/
public class Q11二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }


    public int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
