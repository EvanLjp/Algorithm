package com.evan.coding;

import java.util.ArrayList;

/**
 * @author :evan
 * @date :2018-08-21 19:38
 **/
public class Q41和为S的两个数字 {
    public ArrayList FindNumbersWithSum(int[] array, int sum) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left] + array[right];
            if (temp == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (temp < sum) {
                left++;
            } else {
                right--;
            }
        }


        return new ArrayList();
    }


}
