package com.evan.interviews;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 19:32
 */
public class Q42_连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum=sum<=0?array[i]:sum+array[i];
            max=Math.max(max,sum);
        }
        return max;
    }




}
