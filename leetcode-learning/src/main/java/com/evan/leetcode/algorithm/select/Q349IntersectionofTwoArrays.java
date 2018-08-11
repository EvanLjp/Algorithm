package com.evan.leetcode.algorithm.select;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :evan
 * @date :2018-08-09 09:05
 **/
public class Q349IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int [] r=new int[res.size()];
        int flag=0;
        for (int i:res) {
            r[flag++]=i;
        }
        return r;

    }




}
