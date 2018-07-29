package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asus on 2018/1/7.
 */
public class IntersectionofTwoArrays_349 {

   /* public int[] intersection(int[] nums1, int[] nums2) {
        //sort and two pointers

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                while (i + 1 < nums1.length && nums1[i] == nums1[i + 1])	i++;
                while (j + 1 < nums2.length && nums2[j] == nums2[j + 1])	j++;
                temp.add(nums1[i]);
                i ++; j ++;
            }
            else if (nums1[i] > nums2[j])	j ++;
            else		i++;
        }
        int[] res = new int[temp.size()];
        for (int i1 = 0; i1 < temp.size(); i1 ++)
            res[i1] = temp.get(i1);
        return res;
    }*/




    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) res.add(nums2[i]);
        }
        int [] r=new int[res.size()];
        int flag=0;
        for (int i:res) {
            r[flag++]=i;
        }
        return r;

    }

    @Test
    public  void test(){
        int[] a={1};
        int [] b={1,1};
        System.out.println(intersection(a,b));
    }

}
