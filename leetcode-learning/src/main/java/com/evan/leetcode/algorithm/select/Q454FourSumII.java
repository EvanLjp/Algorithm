package com.evan.leetcode.algorithm.select;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :evan
 * @date :2018-08-10 09:24
 **/
public class Q454FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(A[i] + B[j])) {
                    map.put(A[i] + B[j], map.get(A[i] + B[j]) + 1);

                } else {
                    map.put(A[i] + B[j], 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(0 - C[i] - D[j])) {
                    res += map.get(0 - C[i] - D[j]);
                }
            }
        }
        return res;
    }

}
