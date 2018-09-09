package com.evan.toutiao;


import java.util.*;

/**
 * @author :evan
 * @date :2018-09-09 11:15
 **/
public class Q5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> strs = new ArrayList<>();
        for (int i = 0; i < 2 * m; i++) {
            strs.add(scanner.nextInt());
        }
        ArrayList<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            graph.get(i).add(i);
        }
        for (int i = 0; i < 2*m; i+=2) {
            int j=strs.get(i)-1;
            int k=strs.get(i+1)-1;
            graph.get(k).add(j);
        }
        boolean flag=true;
        while (flag){
            flag=false;
            for (int i = 0; i < 2*m; i+=2) {
                int j=strs.get(i)-1;
                int k=strs.get(i+1)-1;
                int c=graph.get(k).size();
                graph.get(k).addAll(graph.get(j));
                if (c!=graph.get(k).size()){
                    flag=true;
                }
            }

        }
        int count =0;
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size()==n){
                count++;
            }
        }
        System.out.println(count);


    }
}
