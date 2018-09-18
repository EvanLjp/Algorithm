package com.evan.滴滴;

import java.util.*;

/**
 * @author :evan
 * @date :2018-09-18 18:57
 **/
public class Q1 {
    static class c {
        int index;
        String name;
        String original;
        int val;

        public c(int index, String name, String original, int val) {
            this.index = index;
            this.name = name;
            this.original = original;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split(" ");

        String target = split[0];
        PriorityQueue<c> priorityQueue = new PriorityQueue<>(new Comparator<c>() {
            @Override
            public int compare(c o1, c o2) {
                if (o1.val != o2.val) {
                    return o1.val - o2.val;
                } else {
                    return o1.index - o2.index;
                }

            }
        });
        getRes(target, split, priorityQueue);
        int size = priorityQueue.size();
        size = size >= 3 ? 3 : size;
        for (int i = 0; i < size; i++) {
            System.out.print(priorityQueue.poll().original);
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

    }

    private static void getRes(String target, String[] split, PriorityQueue<c> queue) {
        for (int i = 1; i < split.length; i++) {
            int count = getCount(target.toLowerCase(), split[i].toLowerCase());
            queue.add(new c(i, split[i].toLowerCase(), split[i], count));
        }

    }

    private static int getCount(String target, String s) {
        int[][] dp = new int[target.length() + 1][s.length() + 1];

        for (int i = 0; i < target.length() + 1; i++) {
            dp[i][0] = 3*i;
        }
        for (int i = 0; i < s.length() + 1; i++) {
            dp[0][i] = 3*i;
        }

        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (target.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j] + 3, dp[i][j + 1] + 3), dp[i][j] + getSoore(target.charAt(i), s.charAt(j)));
                }
            }
        }
        return dp[target.length()][s.length()];
    }

    private static int getSoore(char c, char c1) {
        char[] char1 = {'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};
        char[] char2 = {'y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'};

        if (contain(char1, c) && contain(char1, c1) || contain(char2, c) && contain(char2, c1)) {
            return 1;
        } else {
            return 2;
        }
    }

    private static boolean contain(char[] char1, char c) {
        for (int i = 0; i < char1.length; i++) {
            if (c == char1[i]) {
                return true;
            }
        }
        return false;
    }
}
