package com.evan.interviews;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q57_1_和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int l=0,r=array.length-1;
        while (l<r){
            int cur=array[l]+array[r];
            if (cur==sum)
                return new ArrayList<>(Arrays.asList(array[l],array[r]));
            else if(cur<sum)
                l++;
            else r--;
        }
        return new ArrayList<>();
    }

}
