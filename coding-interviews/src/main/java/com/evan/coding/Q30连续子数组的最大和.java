package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-21 13:50
 **/
public class Q30连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int a : array) {
            sum = sum <= 0 ? a : sum + a;
            max = Math.max(max, sum);
        }
        return max;
    }


}
