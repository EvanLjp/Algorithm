package com.evan.leetcode.LEETCODE.DynamicPrograming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by asus on 2018/2/21.
 */
public class CombinationSumIV_377 {

    private HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 记忆化搜索 12ms
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (map.containsKey(target)) return map.get(target);
        if (target < 0) return 0;
        if (target == 0) return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += combinationSum4(nums, target - nums[i]);
        }
        map.put(target, res);
        return res;

    }

    /**
     * 动态规划4ms
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4_2(int[] nums, int target) {
        int length = nums.length;
        int[] map=new int[target+1];
        Arrays.sort(nums);
        map[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <length ; j++) {
                if(nums[j]>i) break;
                map[i]+=map[i-nums[j]];
            }
        }
        return map[target];

    }
    @Test
    public void test(){
        int[]arr={1,2,3};
        System.out.println(combinationSum4_2(arr,4));
    }


}
