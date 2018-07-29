package com.evan.leetcode.LEETCODE.SELECT;

import java.util.HashMap;

/**
 * Created by asus on 2018/1/8.
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null){
                return new int[]{map.get(nums[i]),i};
            }else {
                map.put(target-nums[i],i);
            }
        }
        return null;
    }


}
