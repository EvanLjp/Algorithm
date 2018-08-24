package com.evan.coding;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author :evan
 * @date :2018-08-21 13:05
 **/
public class Q29最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int a : input) {
            max.offer(a);
            if (max.size() > k) {
                max.poll();
            }
        }
        return new ArrayList<>(max);


    }
}
