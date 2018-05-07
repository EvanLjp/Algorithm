package LEETCODE.DynamicPrograming;

import java.util.Arrays;

/**
 * Created by asus on 2018/2/23.
 */
public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int [] map=new int[length];
        Arrays.fill(map,1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]) map[i]=Math.max(map[i],map[j]+1);
            }
        }
        int res=0;
        for (int i = 0; i < length; i++) {
            res=Math.max(res,map[i]);
        }
        return res;
    }




}
