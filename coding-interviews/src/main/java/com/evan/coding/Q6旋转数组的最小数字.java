package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-20 08:39
 **/
public class Q6旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("无法找到最小元素");
        int target = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                target = array[i];
                break;
            }
        }
        return target;
    }


}
