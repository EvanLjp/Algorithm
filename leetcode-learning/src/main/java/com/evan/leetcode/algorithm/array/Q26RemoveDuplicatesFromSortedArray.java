package com.evan.leetcode.algorithm.array;

/**
 * @author :evan
 * @date :2018-07-29 11:11
 **/
public class Q26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[flag - 1]) {
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag;
    }


}
