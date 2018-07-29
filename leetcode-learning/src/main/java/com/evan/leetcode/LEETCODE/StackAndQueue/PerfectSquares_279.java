package com.evan.leetcode.LEETCODE.StackAndQueue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus on 2018/2/2.
 */
public class PerfectSquares_279 {
    class PAIR {
        private int times;
        private int num;

        PAIR(int num, int times) {
            this.num = num;
            this.times = times;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

    }

    public int numSquares(int n) {
        Queue<PAIR> queue = new LinkedList<>();
        queue.offer(new PAIR(n, 0));
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            PAIR poll = queue.poll();
            int num = poll.getNum();
            int times = poll.getTimes();
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) break;
                if (a == 0) return times + 1;
                if (!visited[a]) {
                    queue.offer(new PAIR(a, times + 1));
                    visited[a] = true;
                }
            }
        }
        return -1;

    }

    @Test
    public void test(){
        System.out.println(numSquares(12));
    }

}
