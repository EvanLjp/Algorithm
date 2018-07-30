package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.ReverseThinking;
import org.junit.Test;

/**
 * @author :evan
 * @date :2018-07-29 15:24
 **/
@ReverseThinking
public class Q88MergeSortedArray {

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
    public void test(){
        merge(new int[]{4,5,6,0,0,0},3,new int[]{1,2,3},3);
    }

}
