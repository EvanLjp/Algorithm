package com.evan.leetcode.LEETCODE.ARRAY;

import org.junit.Test;

/**
 * Created by asus on 2018/1/5.
 */
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        //[left,right]
        int leftIndex=0;
        int rightIndex=0;
        int minLength=nums.length+1;
        int sum=0;
        while (leftIndex<nums.length){
            if(rightIndex<nums.length&&sum<s) sum+=nums[rightIndex++];
            else sum-=nums[leftIndex++];
            if(sum>=s) minLength=minLength<rightIndex-leftIndex+1?minLength:rightIndex-leftIndex;
        }
        if(minLength==nums.length+1) return 0;
        else  return minLength;
    }

    @Test
    public void test(){
        int [] s={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,s));
    }


}
