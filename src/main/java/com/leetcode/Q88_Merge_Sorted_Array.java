package com.leetcode;

import com.leetcode.annotations.category.Array;
import com.leetcode.annotations.thinking.ReverseThinking;
import org.junit.Test;

/**
 * @author : Evan.Liu
 * @date : 2020/6/27 14:21
 */
@Array
@ReverseThinking
public class Q88_Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }

    }

    @Test
    public void test() {
        merge(new int[] {
            4,
            5,
            6,
            0,
            0,
            0
        }, 3, new int[] {
            1,
            2,
            3
        }, 3);
    }

}
