package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-21 12:53
 **/
public class Q28数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int flag = array[0], times = 1;
        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                flag = array[i];
                times = 1;
            } else if (array[i] == flag) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int a : array) {
            if (a == flag) {
                times++;
            }
        }
        return times > (array.length >> 1) ? flag : 0;
    }
}
