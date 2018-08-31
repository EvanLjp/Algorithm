package com.evan.leetcode.algorithm.stack_queue;


import org.junit.Test;

import java.util.*;

/**
 * @author :evan
 * @date :2018-08-31 09:25
 **/
public class Q347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (queue.peek().getValue() < entry.getValue()) {
                queue.poll();
                queue.offer(entry);
            }
        }
        List<Integer> ans = new ArrayList<>(queue.size());
        for (Map.Entry<Integer, Integer> entry : queue) {
            ans.add(entry.getKey());
        }
        return ans;

    }


    @Test
    public void test(){
        int[] arr={4,1,-1,2,-1,2,3};
        System.out.println(topKFrequent(arr,2));
    }


}
