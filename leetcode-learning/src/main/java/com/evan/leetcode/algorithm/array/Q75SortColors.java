package com.evan.leetcode.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :evan
 * @date :2018-07-29 14:46
 **/
public class Q75SortColors {
    public void sortColors(int[] nums) {
        //[0,zero]
        int zero = -1;
        //[two,nums.length-1]
        int two = nums.length;
        for (int i = 0; i < two; ) {
            switch (nums[i]) {
                case 0:
                    swap(nums, i++, ++zero);
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    swap(nums, i, --two);
                    break;
                default:
                    break;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    @Test
    public void test() {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.asList(arr));
    }

}
