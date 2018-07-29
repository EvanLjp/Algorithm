package com.evan.leetcode.LeetCodeQuestions;

import java.util.HashMap;

/**
 * @description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * @author: evan
 * @create: 2018-05-24 21:39
 **/
public class Q1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length<2) return null;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++){
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]),i};
            map.put(target-nums[i],i);
        }
        return new int[]{};
    }



}
