package com.evan.coding;

import org.junit.Test;

import java.sql.SQLOutput;

/**
 * @author :evan
 * @date :2018-08-21 14:14
 **/
public class Q31整数中1出现的次数 {


    public int NumberOf1Between1AndN_Solution(int n) {
        int sum=0;
        for (int i = 1; i <=n ; i*=10) {
            int a=n/i,b=n%i;
            sum+=(a+8)/10*i+(a%10==1?b+1:0);
        }
        return sum;




    }

    @Test
    public void test(){
        System.out.println(NumberOf1Between1AndN_Solution(1));
    }

}
