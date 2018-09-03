package com.evan.leetcode.algorithm.DynamicPrograming;

import org.junit.Test;

/**
 * Created by asus on 2018/2/18.
 */
public class Q213HouseRobberII {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] map1 = new int[length];
        int[] map2 = new int[length];
        map1[0] = nums[0];
        map2[1] = nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            map1[i] = Math.max(map1[i - 1], i - 2 >= 0 ? nums[i] + map1[i - 2] : 0);
        }


        for (int i = 2; i < nums.length; i++) {
            map2[i] = Math.max(map2[i - 1], nums[i] + map2[i - 2]);
        }
        return Math.max(map1[length - 2], map2[length - 1]);

    }

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 1};
        System.out.println(rob(arr));
    }


}
