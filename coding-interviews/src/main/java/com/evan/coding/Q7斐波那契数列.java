package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-20 09:47
 **/
public class Q7斐波那契数列 {
    public int Fibonacci(int n) {
        if(n<=1) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[0] = 0;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }


}
