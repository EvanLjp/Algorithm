package com.evan.leetcode.LEETCODE.DynamicPrograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/2/19.
 */
public class CoinChange_322 {
    /**
     * version 1递归
     *
     * @param coins
     * @param amount
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        return coinNumber(0, coins, amount);
    }

    private int coinNumber(int index, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (index == coins.length || amount < 0) return -1;
        if (map.containsKey(amount)) return map.get(amount);
        int maxNumber = amount / coins[index];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= maxNumber; i++) {
            int res = coinNumber(index + 1, coins, amount - i * coins[index]);
            if (res != -1) min = Math.min(min, res + i);
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    /**
     * 记忆化搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange_2(coins, amount, new int[amount]);
    }

    private int coinChange_2(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange_2(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public int coinChange_3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }



}
