package com.evan.coding;

import org.junit.Test;

/**
 * @author :evan
 * @date :2018-08-20 10:38
 **/
public class Q13调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] temp = new int[array.length];
        int flag = 0;
        int flag2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                array[flag++] = array[i];
            } else {
                temp[flag2++] = array[i];
            }
        }
        for (int i = flag, j = 0; i < array.length; i++, j++) {
            array[i] = temp[j];
        }

    }


    @Test
    public void test() {
        reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7});
    }


}
