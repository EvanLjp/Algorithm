package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-21 22:51
 **/
public class Q47不用加减乘除做加法 {
    public int Add(int num1, int num2) {
        int tmp=num1;
        num1 ^= num2;
        num2 &= tmp;
        while (num2 != 0) {
            num2 = num2 << 1;
            tmp=num1;
            num1 ^= num2;
            num2 &= tmp;
        }

        return num1;
    }

}
