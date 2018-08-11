package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.SlidingWindow;

/**
 * @author jiapeng.liu
 * @date 2018/8/2 17:29
 **/
@SlidingWindow
public class Q209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        //[l,r]
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }

        if (res == nums.length + 1) {
            return 0;

        }
        return res;

    }
}
