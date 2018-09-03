package com.evan.leetcode.algorithm.DynamicPrograming;

import java.util.HashMap;

/**
 * Created by asus on 2018/2/17.
 */
public class Q279PerfectSquares {
    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public int numSquares_0(int n) {
        int min = Integer.MAX_VALUE;
        if (n == 0) return 0;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + numSquares_0(n - i * i));
        }
        return min;
    }

    /**
     * 记忆化搜索
     * Time:548ms
     *
     * @param n
     * @return
     */
    public int numSquares_1(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        return paration(map, n);

    }

    private int paration(HashMap<Integer, Integer> map, int n) {
        if (map.containsKey(n)) return map.get(n);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + paration(map, n - i * i));
        }
        map.put(n, min);
        return min;
    }

    /**
     * 动态规划
     *Time:65ms
     * @param n
     * @return
     */
    public int numSquares_2(int n) {
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                arr[i] = getMin(arr[i], 1 + arr[i - j * j]);
            }
        }
        return arr[n];
    }

    private int getMin(int a, int b) {
        if (a == 0) return b;
        else return a < b ? a : b;
    }

}
