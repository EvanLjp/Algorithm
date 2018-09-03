package com.evan.leetcode.algorithm.DynamicPrograming;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by asus on 2018/2/23.
 * https://blog.csdn.net/h12590400327/article/details/79144739
 */
public class Q376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    @Test
    public void test(){
        int[]ar={3,3,3,2,5};
        System.out.println(wiggleMaxLength(ar));
    }

}
