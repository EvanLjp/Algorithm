package com.evan.leetcode.algorithm.DynamicPrograming;

/**
 * Created by asus on 2018/2/16.
 */
public class Q70ClimbingStairs {

    public int climbStairs(int n) {

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[0] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }


}
