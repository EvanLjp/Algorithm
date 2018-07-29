package com.evan.leetcode.LEETCODE.SELECT;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/1/13.
 */
public class FourSumII_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(A[i] + B[j]))
                    map.put(A[i] + B[j], map.get(A[i] + B[j]) + 1);
                else map.put(A[i] + B[j], 1);
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(0 - C[i] - D[j])) res += map.get(0 - C[i] - D[j]);
            }
        }
        return res;
    }

    //115ms
    /*public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        int[] first = new int[len*len];
        int[] second = new int[len*len];
        int count = 0;

        for(int i=0;i<len;++i){
            for(int j=0;j<len;++j){
                first[i*len + j] = A[i] + B[j];
                second[i*len + j] = C[i] + D[j];
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int m = 0, n = len*len-1;
        while(m<len*len && n>=0){
            if(first[m] + second[n] == 0){
                int a = 1, b = 1;
                while(m+1<len*len && first[m] == first[m+1]){
                    a++; m++;
                }
                while(n-1>=0 && second[n] == second[n-1]){
                    b++;n--;
                }
                count += a*b;
                m++;n--;

            }
            else if(first[m] + second[n] < 0){
                m++;
            }
            else if(first[m] + second[n] > 0){
                n--;
            }
        }

        return count;

    }*/
}
