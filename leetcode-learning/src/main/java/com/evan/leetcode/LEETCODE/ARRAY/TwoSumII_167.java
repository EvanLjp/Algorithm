package com.evan.leetcode.LEETCODE.ARRAY;

/**
 * Created by asus on 2018/1/4.
 */
public class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] - target == 0) {
                return new int[]{leftIndex+1, rightIndex+1};
            } else if (numbers[leftIndex] + numbers[rightIndex] - target > 0) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return null;


    }

}
