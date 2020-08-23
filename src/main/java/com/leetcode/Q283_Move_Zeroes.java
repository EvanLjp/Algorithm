package com.leetcode;

import com.leetcode.annotations.thinking.DoublePointer;
import com.leetcode.annotations.category.Array;

/**
 * @author : Evan.Liu
 * @date : 2020/6/27 13:16
 */
@Array
@DoublePointer
public class Q283_Move_Zeroes {

    /**
     * 时间O(n) 空间O(n)
     */
    public void moveZeroes_1(int[] nums) {
        int[] copy = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            copy[j++] = nums[i];
        }
        System.arraycopy(copy, 0, nums, 0, nums.length);
    }

    public void moveZeroes_2(int[] nums) {

        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, l++, i);
            }
        }

    }

    private void swap(final int[] nums, final int l, final int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

}
