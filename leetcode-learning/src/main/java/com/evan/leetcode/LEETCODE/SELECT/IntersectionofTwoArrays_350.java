package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2018/1/7.
 */
public class IntersectionofTwoArrays_350 {

    /*public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[j]) {
                while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) i++;
                i++;
            } else {
                while (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) j++;
                j++;
            }
        }

        return Arrays.copyOf(ans, k);
    }*/




    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            int[] s = {};
            return s;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null) map.put(nums1[i], 1);
            else map.put(nums1[i], map.get(nums1[i]) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    @Test
    public void test() {
        int[] a = {2, 1};
        int[] b = {1, 2};
        System.out.println(intersect(a, b));
    }

}
