package com.evan.leetcode.algorithm.graph;

import java.util.*;

/**
 * @author :evan
 * @date :2018-09-01 16:52
 **/
public class Q743NetworkDelayTime {
    class Pair {
        public int node;
        public int time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        HashSet<Integer> visits = new HashSet<>();
        HashMap<Integer, HashMap<Integer, Integer>> edges = new HashMap<>(times.length);
        for (int[] t : times) {
            HashMap<Integer, Integer> edge = edges.get(t[0]);
            if (edge == null) {
                edge = new HashMap<>(times.length);
                edges.put(t[0], edge);
            }
            edge.put(t[1], t[2]);
        }
        int ans = 0;
        queue.offer(new Pair(K, 0));
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            if (visits.contains(front.node)) {
                continue;
            }
            ans = front.time;
            visits.add(front.node);
            HashMap<Integer, Integer> edge = edges.get(front.node);
            if (edge == null) {
                continue;
            }
            for (Map.Entry<Integer, Integer> entry : edge.entrySet()) {
                queue.add(new Pair(entry.getKey(), front.time + entry.getValue()));
            }
        }
        return visits.size() < N ? -1 : ans;


    }

}
