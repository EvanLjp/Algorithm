package com.evan.leetcode.algorithm.array;

/**
 * @author : evan
 * @date : 2018-07-29 10:23
 **/
public class Q283MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums==null||nums.length==0){
            return;
        }
        int flag=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                if (i==flag){
                    flag++;
                }else {
                    nums[flag++]=nums[i];
                    nums[i]=0;
                }
            }
        }

    }

}
