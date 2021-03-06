package com.leetcode;

import com.leetcode.annotations.category.Array;
import com.leetcode.annotations.thinking.DoublePointer;

/**
 * @author : Evan.Liu
 * @date : 2020/6/28 11:12
 */
@Array
@DoublePointer
public class Q27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
