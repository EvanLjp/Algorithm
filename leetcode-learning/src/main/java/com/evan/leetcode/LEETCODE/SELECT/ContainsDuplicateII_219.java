package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asus on 2018/1/14.
 */
public class ContainsDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
            else {
                int lastIndex = map.get(nums[i]);
                if (i - lastIndex <= k) return true;
                map.put(nums[i], i);
            }
        }
        return false;
    }
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (k > 3000) return false;
            if (nums == null || nums.length <= 1) return false;

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
                if (set.size() > k) set.remove(nums[i - k]);
            }
            return false;
        }
    }
    @Test
    public void test() {
        int[] a = {1, 2, 1};
        containsNearbyDuplicate(a, 0);
    }


}
