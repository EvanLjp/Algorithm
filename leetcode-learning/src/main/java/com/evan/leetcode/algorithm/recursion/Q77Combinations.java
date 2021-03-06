package com.evan.leetcode.algorithm.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/11.
 */
public class Q77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if(n<=0||k<=0||k>n) {
            return res;
        }
        getRes(res, new LinkedList<>(), n, 1, k);
        return res;
    }

    private void getRes(List<List<Integer>> res, LinkedList<Integer> temp, int n, int start, int numbers) {
        if (temp.size() == numbers) {
            res.add(new ArrayList<>(temp));
            return;
        }
        int capacity=n-numbers+temp.size()+1;
        for (int i = start; i <= capacity; i++) {
            temp.add(i);
            getRes(res, temp, n, i + 1, numbers);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }


}
