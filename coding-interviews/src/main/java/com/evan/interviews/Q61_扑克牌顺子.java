package com.evan.interviews;

import java.util.Arrays;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q61_扑克牌顺子 {
    public boolean isContinuous(int [] nums) {
        if (nums.length < 5)
            return false;
        Arrays.sort(nums);
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }
        return cnt >= 0;
    }




}
