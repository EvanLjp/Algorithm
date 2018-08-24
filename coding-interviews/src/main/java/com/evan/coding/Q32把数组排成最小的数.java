package com.evan.coding;

import java.util.Arrays;

/**
 * @author :evan
 * @date :2018-08-21 15:34
 **/
public class Q32把数组排成最小的数 {
    public String PrintMinNumber(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        String res = "";
        for (String a : arr) {
            res += a;
        }
        return res;

    }


}
