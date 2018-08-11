package com.evan.leetcode.algorithm.select;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author :evan
 * @date :2018-08-10 21:16
 **/
public class Q220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long)nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t) {
                return true;
            } else {
                set.add((long) nums[i]);
            }
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    @Test
    public void test() {
        int arr[] = {0, 2147483647};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1, 2147483647));

    }
}
