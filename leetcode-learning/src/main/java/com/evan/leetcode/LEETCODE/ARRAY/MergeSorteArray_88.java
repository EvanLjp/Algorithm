package com.evan.leetcode.LEETCODE.ARRAY;

/**
 * Created by asus on 2018/1/1.
 */
public class MergeSorteArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int index=n+m-1;
        while (i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[index--]=nums1[i--];
            }else {
                nums1[index--]=nums2[j--];
            }
        }
        while (j>=0){
            nums1[index--]=nums2[j--];
        }
    }



}
