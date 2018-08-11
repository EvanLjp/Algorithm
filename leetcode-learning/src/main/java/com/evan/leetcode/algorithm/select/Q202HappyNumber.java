package com.evan.leetcode.algorithm.select;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :evan
 * @date :2018-08-09 21:09
 **/
public class Q202HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();
        while (n != 1) {
            if (map.contains(n)) {
                return false;
            }
            map.add(n);
            n = getNext(n);
        }
        return true;

    }

    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }


    /*public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappy(set, n);

    }

    private boolean isHappy(Set<Integer> set, int n) {
        if (set.contains(n)) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        set.add(n);
        int number = getSum(n);
        return isHappy(set, number);
    }

    private int getSum(int n) {
        int sum = 0;
        int temp;
        while (n != 0) {
            temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }*/


}
