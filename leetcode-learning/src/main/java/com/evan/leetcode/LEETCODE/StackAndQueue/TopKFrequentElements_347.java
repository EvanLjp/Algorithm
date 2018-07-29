package com.evan.leetcode.LEETCODE.StackAndQueue;

import java.util.*;

/**
 * Created by asus on 2018/2/4.
 */
public class TopKFrequentElements_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(queue.size()<k) queue.offer(entry);
            else if(queue.peek().getValue()<entry.getValue()){
                queue.poll();
                queue.offer(entry);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : queue)
            ans.add(entry.getKey());
        return ans;
        
        
    }


}
