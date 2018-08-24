package com.evan.coding;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :evan
 * @date :2018-08-21 20:15
 **/
public class Q44扑克牌顺子 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                break;
            }
            count++;
        }
        for (int i = count + 1; i < numbers.length; i++) {

            int sub = numbers[i] - numbers[i - 1];
            if (sub == 0) {
                return false;
            }
            if (sub == 1) {
                continue;
            } else {
                count = count - sub + 1;
                if (count < 0) {
                    return false;
                }
            }
        }
        return true;


    }

    @Test
    public void test() {
        System.out.println(isContinuous(new int[]{1, 3, 2, 6, 4}));
    }


}
