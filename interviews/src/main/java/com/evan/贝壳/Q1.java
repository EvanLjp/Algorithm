package com.evan.贝壳;

import java.util.*;

/**
 * @author :evan
 * @date :2018-09-03 19:40
 **/
public class Q1 {

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>(number);
        HashSet<Integer> visited = new HashSet<>(number);
        int root = -1;
        for (int i = 0; i < number; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (b == -1) {
                root = a;
                continue;
            }
            List<Integer> list = map.get(a);
            if (list == null) {
                map.put(a, new LinkedList<>());
            }
            map.get(a).add(b);
            List<Integer> bIntegers = map.get(b);
            if (bIntegers == null) {
                map.put(b, new LinkedList<>());
            }
            map.get(b).add(a);
        }
        recursion(root, map, visited);
        int question = scanner.nextInt();
        creatTree(map)
        for (int i = 0; i < question; i++) {
            getRes()
        }


    }

    private static List<Integer> recursion(int root, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
        List<Integer> list = map.get(root);

        for (Integer i : list) {

        }

    }*/
}
