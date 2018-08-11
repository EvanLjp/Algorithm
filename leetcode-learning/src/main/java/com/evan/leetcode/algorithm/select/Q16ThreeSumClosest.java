package com.evan.leetcode.algorithm.select;

import java.util.Arrays;

/**
 * @author :evan
 * @date :2018-08-10 08:06
 **/
public class Q16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int bestAnswer = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int val = nums[i] + nums[left] + nums[right];
                if (val == target) {
                    return target;
                } else if (val < target) {
                    bestAnswer = Math.abs(val - target) < Math.abs(bestAnswer - target) ? val : bestAnswer;
                    left++;
                } else if (val > target) {
                    bestAnswer = Math.abs(val - target) < Math.abs(bestAnswer - target) ? val : bestAnswer;
                    right--;
                }
            }
        }
        return bestAnswer;
    }
}
