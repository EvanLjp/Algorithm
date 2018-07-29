package com.evan.leetcode.algorithm.array;

/**
 * @author :evan
 * @date :2018-07-29 10:55
 **/
public class Q27RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[flag++] = nums[i];
            }
        }
        return flag;
    }
}
