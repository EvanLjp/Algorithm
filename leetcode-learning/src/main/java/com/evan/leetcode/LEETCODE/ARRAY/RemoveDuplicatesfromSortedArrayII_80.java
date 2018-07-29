package com.evan.leetcode.LEETCODE.ARRAY;

/**
 * Created by asus on 2017/12/31.
 */
public class RemoveDuplicatesfromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        int temp=nums.length;
        if(temp<2) return temp;
        int flag=2;
        for (int i = 2; i < nums.length; i++) {
          if(nums[flag-2]!=nums[i]){
              nums[flag]=nums[i];
              flag++;
          }
        }
        return flag;
    }

}
