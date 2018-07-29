package com.evan.interviews;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q64_求1加到n {
    public int Sum_Solution(int n) {

        boolean flag=(n>0)&&(n+=Sum_Solution(n-1))>0;

        return n;
    }




}
