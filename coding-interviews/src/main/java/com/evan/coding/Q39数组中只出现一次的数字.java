package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-21 19:06
 **/
public class Q39数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res=0;

        for (int a:array){
            res^=a;
        }

        res=res&(-res);

        for(int a:array){
            if ((a&res)!=0){
                num1[0]=num1[0]^a;
            }else {
                num2[0]=num2[0]^a;
            }
        }



    }

}
