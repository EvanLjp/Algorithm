package com.evan.interviews;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q62_圆圈中最后剩下的数 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

}
