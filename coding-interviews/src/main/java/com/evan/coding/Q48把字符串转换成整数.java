package com.evan.coding;

import org.junit.Test;


/**
 * @author :evan
 * @date :2018-08-22 10:09
 **/
public class Q48把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0) {
            return 0;
        }
        char[] array = str.toCharArray();
        int begin = 0;
        if (array[0] == '-') {
            begin = 1;
        }
        int sum = 0;
        for (int i = begin; i < array.length; i++) {
            if (array[i] == '+') {
                continue;
            }
            if (array[i] < '0' || array[i] > '9') {
                return 0;
            }
            sum = sum * 10 + (array[i] - '0');
        }

        return begin == 0 ? sum : -sum;

    }

    @Test
    public void test() {
        System.out.println(StrToInt("+123"));
    }

}
