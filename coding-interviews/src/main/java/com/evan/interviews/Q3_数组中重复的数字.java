package com.evan.interviews;

import org.junit.Test;

/**
 * Created by asus on 2018/4/2.
 */
public class Q3_数组中重复的数字 {
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; ) {
            if (numbers[i] == i) {
                i++;
            } else {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    numbers[temp] = temp;
                }
            }
        }

        return false;
    }


    @Test
    public void test(){
        int[]arr={2,3,1,0,2,5,3};
        System.out.println(duplicate(arr,7,new int[7]));
    }
}
