package com.evan.interviews;

/**
 * Created by asus on 2018/4/4.
 */
public class Q10_1_斐波那契数列 {


    public int Fibonacci(int n) {
        if(n<=1) return n;
        int []arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i <= n; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public int Fibonacc_2(int n) {
        if(n<=1) return n;
        int first=0;
        int second=1;
        int fib=0;
        for (int i = 2; i <= n; i++) {
            fib=first+second;
            first=second;
            second=fib;
        }
        return fib;
    }
}
