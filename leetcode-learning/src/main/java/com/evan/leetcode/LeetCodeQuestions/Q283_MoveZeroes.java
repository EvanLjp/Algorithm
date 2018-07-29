package com.evan.leetcode.LeetCodeQuestions;

/**
 * Created by asus on 2018/4/15.
 */
public class Q283_MoveZeroes {

    /**
     * version 1.0 双索引赋值,后续元素赋值为0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                if(index==i) index++;
                else nums[index++]=nums[i];
            }
        }
        for (int i = index; i <nums.length ; i++) {
            nums[i]=0;
        }
    }

    /**
     *不使用二次赋值,使用异或交换
     * @param nums
     */
    public void moveZeroes_2(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                if(index==i) index++;
                else {
                    nums[i]=nums[index]^nums[i];
                    nums[index]=nums[i]^nums[index];
                    nums[i]=nums[i]^nums[index];
                    index++;
                }
            }
        }

    }


}
