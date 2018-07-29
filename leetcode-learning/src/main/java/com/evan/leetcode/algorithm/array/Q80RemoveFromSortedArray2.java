package com.evan.leetcode.algorithm.array;

/**
 * @author :evan
 * @date :2018-07-29 11:24
 **/
public class Q80RemoveFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int flag = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[flag - 2]) {
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag > nums.length ? nums.length : flag;
    }
}
