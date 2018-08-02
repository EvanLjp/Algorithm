package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.CollisionPointer;

/**
 * @author jiapeng.liu
 * @date 2018/8/2 9:23
 **/
@CollisionPointer
public class Q167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;


    }
}
