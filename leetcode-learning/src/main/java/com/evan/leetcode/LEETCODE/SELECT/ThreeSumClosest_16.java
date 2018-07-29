package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by asus on 2018/1/13.
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        int bestAnswer = nums[1]+nums[2]+nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int val = nums[i] + nums[left] + nums[right];
                if (val == target) {
                    return target;
                } else if (val < target) {
                    bestAnswer = Math.abs(val - target)< Math.abs(bestAnswer - target) ? val : bestAnswer;
                    left++;
                } else if (val > target) {
                    bestAnswer = Math.abs(val - target) < Math.abs(bestAnswer - target) ? val : bestAnswer;
                    right--;
                }
            }
        }
        return bestAnswer;
    }

    @Test
    public void test() {
        int[] a = {-3, -2, -5, 3, -4};
        System.out.println(threeSumClosest(a, -1));


    }


}
