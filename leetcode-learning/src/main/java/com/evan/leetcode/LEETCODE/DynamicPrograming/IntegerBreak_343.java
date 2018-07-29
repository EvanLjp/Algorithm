package com.evan.leetcode.LEETCODE.DynamicPrograming;

import java.util.HashMap;

/**
 * Created by asus on 2018/2/17.
 */
public class IntegerBreak_343 {
    /**
     * version 0 递归版本
     * Time:Time Limit Exceeded
     *
     * @param n
     * @return
     */
    public int integerBreak_0(int n) {
        if (n == 1) return 1;
        int max = -1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.max(i * (n - i), i * integerBreak_0(n - i)));
        }
        return max;
    }

    /**
     * version 1 n记忆化搜索
     * Time:4ms(leetcode)
     *
     * @param n
     * @return
     */
    public int integerBreak_1(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        return paration(map, n);
    }

    private int paration(HashMap<Integer, Integer> map, int n) {
        if (map.containsKey(n)) return map.get(n);
        int max = -1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.max(i * (n - i), i * paration(map, n - i)));
        }
        map.put(n, max);
        return max;
    }

    /**
     * 动态规划
     *Time:2ms
     * @param n
     * @return
     */
    public int integerBreak_2(int n) {
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i- 1; j++) {
                arr[i] = Math.max(arr[i], Math.max(j * (i - j), j * arr[i - j]));
            }
        }
        return arr[n];
    }

}
