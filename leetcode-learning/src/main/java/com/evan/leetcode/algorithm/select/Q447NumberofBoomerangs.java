package com.evan.leetcode.algorithm.select;

import java.util.HashMap;

/**
 * @author :evan
 * @date :2018-08-10 10:08
 **/
public class Q447NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int length = getLength(points[i], points[j]);
                Integer count = map.getOrDefault(length, 0);
                map.put(length, count + 1);
            }
            for (int t : map.values()) {
                sum += t * (t - 1);
            }
            map.clear();
        }

        return sum;
    }

    private int getLength(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

}
