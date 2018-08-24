package com.evan.coding;

import org.junit.Test;

/**
 * @author :evan
 * @date :2018-08-19 21:55
 **/
public class Q1二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array[0].length == 0) {
            return false;
        }
        int rows = 0, cols = array[0].length - 1;
        while (rows < array.length && cols > -1) {
            if (array[rows][cols] > target) {
                cols--;
            }else if (array[rows][cols] < target) {
                rows++;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(5,arr));
    }
}
