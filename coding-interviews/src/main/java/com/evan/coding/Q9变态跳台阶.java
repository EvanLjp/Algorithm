package com.evan.coding;

import jdk.nashorn.internal.runtime.FindProperty;
import org.junit.Test;

/**
 * @author :evan
 * @date :2018-08-20 09:56
 **/
public class Q9变态跳台阶 {
    public int JumpFloorII(int target) {
        if (target < 3) {
            return target;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j];
            }
        }
        return arr[target];
    }


    @Test
    public void test(){
        System.out.println(JumpFloorII(3));

    }
}
