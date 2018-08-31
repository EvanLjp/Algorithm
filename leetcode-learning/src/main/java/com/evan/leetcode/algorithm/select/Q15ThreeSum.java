package com.evan.leetcode.algorithm.select;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :evan
 * @date :2018-08-10 07:30
 **/
public class Q15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        //nlogn
        Arrays.sort(nums);
        //n^2
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            twoSum(nums, left, right, target, res);
        }
        return res;
    }

    public void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> res) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> temp = new LinkedList<>();
                temp.add(-target);
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }


}
