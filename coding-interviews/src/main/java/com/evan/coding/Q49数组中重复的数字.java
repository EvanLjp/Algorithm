package com.evan.coding;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :evan
 * @date :2018-08-22 10:27
 **/
public class Q49数组中重复的数字 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            if (numbers[i] != i) {
                if (numbers[numbers[i]] != numbers[i]) {
                    int temp = numbers[i];
                    numbers[temp] = numbers[i];
                    numbers[i] = temp;
                } else {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }


}
