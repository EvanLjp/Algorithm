package com.evan.leetcode.LEETCODE.SELECT;

import java.util.TreeSet;

/**
 * Created by asus on 2018/1/14.
 */
public class ContainsDuplicateIII_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.ceiling((long) nums[i] - (long)t) != null && set.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t) {
                return true;
            } else
                set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }

        }
        return false;


    }


}
