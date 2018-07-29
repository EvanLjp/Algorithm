package com.evan.leetcode.LEETCODE.ARRAY;

/**
 * Created by asus on 2017/12/31.
 */
public class MOVEZERO_283 {
    public void moveZeroes(int[] nums) {
        int flag= 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                if(i!=flag){
                    nums[flag++]=nums[i];
                    nums[i]=0;
                }else {
                    flag++;
                }
            }


        }
    }

}
