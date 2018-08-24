package com.evan.coding;

import org.junit.Test;

/**
 * @author :evan
 * @date :2018-08-20 10:29
 **/
public class Q12数值的整数次方 {
    public double Power(double base, int exponent) {
        int ex = exponent >= 0 ? exponent : -exponent;
        double res = getRes(base, ex);
        return exponent > 0 ? res : 1.0 / res;
    }

    private double getRes(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double half = Power(base, exponent >> 1);
        half *= half;
        if ((exponent & 1) == 1) {
            half *= base;
        }
        return half;
    }

    @Test
    public void test() {
        System.out.println(Power(5, 3));
    }


}
