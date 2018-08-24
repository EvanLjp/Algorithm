package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-21 22:47
 **/
public class Q46求1n {
    public int Sum_Solution(int n) {

        boolean flag=(n>0)&&(n+=Sum_Solution(n-1))>0;

        return n;
    }

}
