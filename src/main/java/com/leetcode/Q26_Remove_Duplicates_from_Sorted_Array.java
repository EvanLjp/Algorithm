package com.leetcode;

import com.leetcode.annotations.category.Array;
import com.leetcode.annotations.thinking.DoublePointer;
import org.junit.Test;

/**
 * @author : Evan.Liu
 * @date : 2020/6/28 11:22
 */
@Array
@DoublePointer
public class Q26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k++]=nums[i];
            }
        }
        return k;
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[] {
            0,
            0,
            1,
            1,
            1,
            2,
            2,
            3,
            3,
            4
        }));
    }
}
