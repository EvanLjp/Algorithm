package com.evan.leetcode.algorithm.select;

import java.util.HashMap;

/**
 * @author :evan
 * @date :2018-08-09 23:23
 **/
public class Q1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
