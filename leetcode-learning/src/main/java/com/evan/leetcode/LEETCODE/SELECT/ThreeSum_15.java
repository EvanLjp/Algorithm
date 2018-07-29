package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/1/8.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
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

    @Test
    public void test(){
        int[] a={-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));


    }


}
