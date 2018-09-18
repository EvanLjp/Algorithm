package com.evan.JD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author :evan
 * @date :2018-09-09 20:07
 **/
public class Q1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Set<Integer>> hashMap;
        int number = scanner.nextInt();
        boolean[] map1=new boolean[number];
        for (int i = 0; i < number; i++) {
            int N = scanner.nextInt();
            hashMap = new HashMap<>();
            for (int j = 1; j <= N; j++) {
                hashMap.put(j, new HashSet<>());
            }
            int M = scanner.nextInt();
            int[] map = new int[2 * M];
            for (int j = 0; j < 2 * M; j += 2) {
                map[j] = scanner.nextInt();
                map[j + 1] = scanner.nextInt();
                hashMap.get(map[j]).add(map[j + 1]);
                hashMap.get(map[j + 1]).add(map[j]);
            }
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            boolean flag = true;
            for (int j = 0; j < 2 * M; j += 2) {
                if (set1.contains(map[j]) && set2.contains(map[j + 1]) || set1.contains(map[j + 1]) && set2.contains(map[j])) {
                    continue;
                }


                if (set1.contains(map[j]) || set2.contains(map[j])) {
                    Set<Integer> another = set1.contains(map[j]) ? set2 : set1;
                    Set<Integer> thisOne = set1.contains(map[j]) ? set1 : set2;
                    another.add(map[j + 1]);
                    for (int a : thisOne) {
                        if (!hashMap.get(a).contains(map[j + 1])) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == false) {
                        break;
                    }
                } else if (set2.contains(map[j + 1]) || set1.contains(map[j + 1])) {
                    Set<Integer> another = set1.contains(map[j + 1]) ? set2 : set1;
                    Set<Integer> thisOne = set1.contains(map[j + 1]) ? set1 : set2;
                    another.add(map[j]);
                    for (int a : thisOne) {
                        if (!hashMap.get(a).contains(map[j])) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == false) {
                        break;
                    }

                } else {
                    set1.add(map[j]);
                    set2.add(map[j + 1]);
                }
            }
            if (flag) {
                map1[i]=true;
            } else {
                map1[i]=false;
            }

        }
        for (boolean a:map1){
            if (a){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
}
