package com.evan.coding;

import java.util.Arrays;

/**
 * @author :evan
 * @date :2018-08-22 10:35
 **/
public class Q50构建乘积数组 {
    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        Arrays.fill(res, 1);
        int temp = 1;
        for (int i = 0; i < A.length; i++) {
            res[i] *= temp;
            temp *= A[i];
        }
        temp = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= A[i];
        }
        return res;
    }


}
