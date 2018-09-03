package com.evan.leetcode.algorithm.DynamicPrograming;

/**
 * Created by asus on 2018/2/18.
 */
public class Q198HouseRobber {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] map = new int[length];
        map[0]=nums[0];
        for (int i = 1; i < length; i++) {
                map[i] = Math.max(map[i-1], nums[i] + (i - 2 >= 0 ? map[i - 2] : 0));
        }
        return map[length - 1];
    }
}
