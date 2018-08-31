package com.evan.leetcode.algorithm.stack_queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :evan
 * @date :2018-08-16 10:39
 **/
public class Q279PerfectSquares {
    private class Pair {
        final int times;
        final int num;

        public Pair(int times, int num) {
            this.times = times;
            this.num = num;
        }
    }

    public int numSquares(int n) {
        Pair pair = new Pair(0, n);
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();

            for (int i = 1; ; i++) {
                int temp = poll.num - i * i;
                if (temp < 0) {
                    break;
                }
                if (temp == 0) {
                    return poll.times + 1;
                }
                if (!visited[temp]) {
                    queue.offer(new Pair(poll.times + 1, temp));
                    visited[temp] = true;
                }
            }
        }
        return -1;
    }
}
