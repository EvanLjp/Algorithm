package com.evan.leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * Created by asus on 2018/2/25.
 */
public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i, j;
        for (i = j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }






}
