package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-20 09:52
 **/
public class Q8跳台阶 {
    public int JumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        int[] arr = new int[target + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= target; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[target];
    }


}
