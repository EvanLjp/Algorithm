package com.evan.leetcode.LeetCodeQuestions;

import org.junit.Test;

/**
 * Created by asus on 2018/4/15.
 */
public class Q71_SortColors {

    /**
     * 计数排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] map=new int[3];
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0: map[0]++;break;
                case 1:map[1]++;break;
                case 2:map[2]++;break;
            }
        }
        for (int i = 0; i < map[0]; i++) {
            nums[i]=0;
        }
        for (int i = 0; i < map[1]; i++) {
            nums[map[0]+i]=1;
        }
        for (int i = 0; i < map[2]; i++) {
            nums[map[0]+map[1]+i]=2;
        }
    }

    /**
     * 三路快排
     * @param nums
     */
    public void sortColors_2(int[] nums) {
        int leftIndex=-1;
        int rightIndex=nums.length;
        for (int i = 0; i < rightIndex; ) {
            if(nums[i]==1){
                i++;
            }
            else if(nums[i]==0)  {
                swap(nums,++leftIndex,i++);
            }else {
                swap(nums,--rightIndex,i);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        if(a==b) return;
        nums[a]=nums[a]^nums[b];
        nums[b]=nums[b]^nums[a];
        nums[a]=nums[a]^nums[b];
    }


    @Test
    public void test(){
        int []arr={2,2};
        sortColors_2(arr);
    }

}
