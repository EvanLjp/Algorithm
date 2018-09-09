package com.evan.贝壳;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-03 19:59
 **/
public class Q2 {

    private static Map<String, Integer> map = new HashMap<>();

    private static int res;
    private static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        res = n;
        int count = 0;
        while (res < m) {
            res = res << 1;
            count++;
        }
        while (res != m) {
            res--;
            count++;
        }
        max = count;

        System.out.println(getRes(n, m, 0));


    }

    private static int getRes(int n, int m, int step) {
        if (step >= max && n != m) {
            return Integer.MAX_VALUE ;
        }

        String key = n + "_" + m;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (n == m) {
            return 0;
        }
        int min = Math.min(getRes(n - 1, m, step + 1), getRes(n << 1, m, step + 1));
        if (min == Integer.MAX_VALUE) {
            map.put(key, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        int res = 1 + min;
        map.put(key, res);
        return res;


    }
}
