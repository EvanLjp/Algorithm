package com.evan.interviews;

import org.junit.Test;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 22:39
 */
public class Q49_丑数 {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 6)
            return index;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n2 = dp[i2] * 2, n3 = dp[i3] * 3, n5 = dp[i5] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2)
                i2++;
            if (dp[i] == n3)
                i3++;
            if (dp[i] == n5)
                i5++;
        }
        return dp[index - 1];
    }

    @Test
    public void test(){
        System.out.println(GetUglyNumber_Solution(7));
    }


}
