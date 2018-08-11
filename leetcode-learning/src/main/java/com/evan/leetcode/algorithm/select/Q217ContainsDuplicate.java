package com.evan.leetcode.algorithm.select;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :evan
 * @date :2018-08-10 21:01
 **/
public class Q217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }


}
