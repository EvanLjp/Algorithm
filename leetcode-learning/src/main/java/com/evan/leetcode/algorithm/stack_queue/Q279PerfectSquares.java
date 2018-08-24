package com.evan.leetcode.algorithm.stack_queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :evan
 * @date :2018-08-16 10:39
 **/
public class Q279PerfectSquares {
    class Pair {
        private int times;
        private int num;

        public Pair(int times, int num) {
            this.times = times;
            this.num = num;
        }
    }

    public int numSquares(int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, n));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int times = pair.times;
            int num = pair.num;
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return times + 1;
                }
                if (!visited[a]) {
                    queue.offer(new Pair(times+1, a));
                    visited[a] = true;
                }
            }
        }
        throw new IllegalArgumentException("参数错误");
    }

    @Test
    public void test(){
        System.out.println(numSquares(12));
    }

}
