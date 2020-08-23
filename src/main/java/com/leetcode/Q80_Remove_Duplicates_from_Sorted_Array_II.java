package com.leetcode;

import com.leetcode.annotations.category.Array;
import com.leetcode.annotations.thinking.DoublePointer;

/**
 * @author : Evan.Liu
 * @date : 2020/6/28 11:43
 */
@Array
@DoublePointer
public class Q80_Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
